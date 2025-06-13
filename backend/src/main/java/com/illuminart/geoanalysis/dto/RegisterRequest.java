package com.illuminart.geoanalysis.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterRequest {

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Введите корректный email")
    private String email;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 6)
    private String password;

    @NotBlank(message = "Поле с именем не может быть пустым")
    private String fullName;

    // геттеры/сеттеры

}
