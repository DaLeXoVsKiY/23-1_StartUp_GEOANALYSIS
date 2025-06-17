package com.illuminart.geoanalysis.controller;

import com.illuminart.geoanalysis.dto.*;
import com.illuminart.geoanalysis.entity.User;
import com.illuminart.geoanalysis.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth/")
@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        User user = authService.register(request);
        RegisterResponse response = new RegisterResponse(
                user.getId(),
                user.getEmail()
        );
        ApiResponse<RegisterResponse> apiResponse = new ApiResponse<>(
                "Регистрация успешна",
                HttpStatus.CREATED,
                response
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = authService.login(request.getEmail(), request.getPassword());
        User user = authService.getAuthenticatedUser(token);
        LoginResponse response = new LoginResponse(
                "Аутентификация успешна",
                token,
                user.getId(),
                authService.getJwtExpirationTime() / 1000
                );


        return ResponseEntity.ok(response);
    }



}



