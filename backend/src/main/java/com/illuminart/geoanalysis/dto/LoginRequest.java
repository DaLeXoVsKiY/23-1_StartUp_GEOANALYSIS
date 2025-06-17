package com.illuminart.geoanalysis.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Введите корректный email")
    private String email;

    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
}
