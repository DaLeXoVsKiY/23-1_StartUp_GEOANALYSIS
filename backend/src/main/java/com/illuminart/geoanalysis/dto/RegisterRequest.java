package com.illuminart.geoanalysis.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
public class RegisterRequest {

    @Getter
    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Введите корректный email")
    private String email;

    @NotBlank(message = "Пароль не может быть пустым")
    private String password;

    @NotBlank(message = "Поле с именем не может быть пустым")
    private String fullName;

    // геттеры/сеттеры

    public CharSequence getPassword() {
        return password;
    }

    public Object getFullName() {
        return fullName;
    }

}
