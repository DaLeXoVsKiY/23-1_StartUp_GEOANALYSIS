const items = document.querySelectorAll('.item');
  let activeItem = null;

  items.forEach(item => {
    const question = item.querySelector('.question');
    const arrow = item.querySelector('.arrow');
    const answerWrapper = item.querySelector('.answer-wrapper');

    question.addEventListener('click', () => {
      const isSame = item === activeItem;

      // Убираем анимации со всех стрелок
      document.querySelectorAll('.arrow').forEach(arrow => {
        arrow.classList.remove('animate-in', 'animate-out');
      });

      if (isSame) {
        item.classList.remove('active');
        collapse(answerWrapper);

        // Анимация закрытия стрелки
        arrow.classList.add('animate-out');

        activeItem = null;
        return;
      }

      // Закрываем предыдущий
      if (activeItem) {
        const prevWrapper = activeItem.querySelector('.answer-wrapper');
        const prevArrow = activeItem.querySelector('.arrow');
        collapse(prevWrapper);
        activeItem.classList.remove('active');

        // Анимация закрытия предыдущей стрелки
        prevArrow.classList.add('animate-out');
      }

      // Открываем текущий
      expand(answerWrapper);
        item.classList.add('active');

        // Добавляем bounce анимацию
        item.classList.add('animate');
        setTimeout(() => item.classList.remove('animate'), 500); // сбросить после анимации

      // Анимация открытия стрелки
      arrow.classList.add('animate-in');

      activeItem = item;
    });
  });

  function expand(wrapper) {
    wrapper.style.maxHeight = wrapper.scrollHeight + "px";
  }

  function collapse(wrapper) {
    wrapper.style.maxHeight = "0px";
  }
