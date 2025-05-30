# GeoAnalysis

**GeoAnalysis** — это веб-приложение для анализа геопространственных данных, разработанное компанией **Illuminart**.  
Бэкенд построен на Spring Boot (Java), фронтенд — на любом современном фреймворке (например, React, Vue или простом HTML/JS).

---

## 📁 Структура проекта

```
geoanalysis/
├── backend/                         # Spring Boot + Java (Maven)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/illuminart/geoanalysis/...
│   │   │   └── resources/
│   │   │       └── static/         # Сюда копируется сборка фронта
│   │   └── test/
│   ├── pom.xml
│   └── application.properties
│
├── frontend/                        # Исходный код frontend (React/Vue и т.д.)
│   ├── public/
│   ├── src/
│   ├── package.json
│   ├── vite.config.js / webpack.config.js
│   └── README.md
│
├── README.md
└── .gitignore
```

---

## ⚙️ Backend (Spring Boot)

### 📦 Стек:
- Java 17+
- Maven 3.6+
- Spring Boot 3.x
- PostgreSQL (опционально)

### 🚀 Запуск

```bash
cd backend
mvn spring-boot:run
```

По умолчанию, приложение запускается на [http://localhost:8081](http://localhost:8081).

---

## 🌐 Frontend

### 🚧 Разработка:

```bash
cd frontend
npm install
npm run dev
```

### 🛠 Сборка и публикация:

После завершения разработки выполните:

```bash
npm run build
```

И скопируйте содержимое папки `dist/` (или `build/` для React) в:

```
backend/src/main/resources/static/
```

Spring Boot автоматически раздаёт эти файлы как статику по URL `http://localhost:8081`.

---

## 👥 Работа в команде

- Фронтенд-разработчики работают в папке `frontend/`
- После сборки **обязательно копируйте** в `backend/src/main/resources/static/`
- Все участники проекта используют `git pull`, `git push`, `pull request` — по согласованному процессу
- Деплой возможен через Docker, Heroku, Vercel и т.д. (по выбору команды)

---

## 🧪 Примеры API (если есть)

`GET /api/data` — получить список геоданных  
`POST /api/upload` — загрузка пользовательского слоя  
...

---

## 🧠 Авторские права

© 2025 Illuminart. Все права защищены.
