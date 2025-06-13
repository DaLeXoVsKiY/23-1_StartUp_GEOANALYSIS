package com.illuminart.geoanalysis.service;

import com.illuminart.geoanalysis.dto.RegisterRequest;
import com.illuminart.geoanalysis.entity.User;
import com.illuminart.geoanalysis.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            logger.warn("Попытка регистрации существующего пользователя: {}", request.getEmail());
            throw new IllegalArgumentException("Пользователь уже существует");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());

        userRepository.save(user);
        logger.info("Пользователь {} успешно зарегистрирован", request.getEmail());
    }

}

