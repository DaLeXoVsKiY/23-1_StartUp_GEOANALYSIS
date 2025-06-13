package com.illuminart.geoanalysis.controller;

import com.illuminart.geoanalysis.dto.RegisterRequest;
import com.illuminart.geoanalysis.entity.User;
import com.illuminart.geoanalysis.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
        authService.register(request);
        User user = new User();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Регистрация успешна");
        response.put("userId", user.getId());
        response.put("email", user.getEmail());
        return ResponseEntity.ok(response);
    }

}



