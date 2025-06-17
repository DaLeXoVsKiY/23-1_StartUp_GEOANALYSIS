package com.illuminart.geoanalysis.config;

import com.illuminart.geoanalysis.entity.Device;
import com.illuminart.geoanalysis.entity.User;
import com.illuminart.geoanalysis.model.enums.Role;
import com.illuminart.geoanalysis.repository.DeviceRepository;
import com.illuminart.geoanalysis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final DeviceRepository deviceRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Создаём админа, если его нет
        User admin = userRepository.findByEmail("admin@example.com")
                .orElseGet(() -> {
                    User user = new User();
                    user.setEmail("admin@example.com");
                    user.setPasswordHash(passwordEncoder.encode("admin123"));
                    user.setRole(Role.ADMIN);
                    user.setCreatedAt(LocalDateTime.now());
                    return userRepository.save(user);
                });

        // Создаём устройства, если их ещё нет
        if (deviceRepository.count() == 0) {
            List<Device> devices = List.of(
                    Device.builder()
                            .deviceSerial("SN-C101")
                            .location("Склад 1")
                            .batteryLevel(84)
                            .createdAt(LocalDateTime.now())
                            .user(admin)
                            .build()
            );
            deviceRepository.saveAll(devices);
            System.out.println("✅ Админ и устройства созданы");
        }
    }
}
