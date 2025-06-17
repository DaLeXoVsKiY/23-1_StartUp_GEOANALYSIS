package com.illuminart.geoanalysis.service;

import com.illuminart.geoanalysis.dto.DeviceRequest;
import com.illuminart.geoanalysis.dto.DeviceResponse;
import com.illuminart.geoanalysis.entity.Device;
import com.illuminart.geoanalysis.entity.User;
import com.illuminart.geoanalysis.exception.DeviceNotFoundException;
import com.illuminart.geoanalysis.repository.DeviceRepository;
import com.illuminart.geoanalysis.repository.UserRepository;
import com.illuminart.geoanalysis.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    @Override
    public List<DeviceResponse> getAllDevicesForCurrentUser() {
        User currentUser = getCurrentUser();
        return deviceRepository.findAllByUserId(currentUser.getId())
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public DeviceResponse getDeviceById(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException(id));
        return mapToResponse(device);
    }

    @Override
    public DeviceResponse createDevice(DeviceRequest request) {
        User currentUser = getCurrentUser();

        Device device = Device.builder()
                .deviceSerial(request.getDeviceSerial())
                .location(request.getLocation())
                .batteryLevel(request.getBatteryLevel())
                .createdAt(LocalDateTime.now())
                .user(currentUser)
                .build();

        deviceRepository.save(device);
        return mapToResponse(device);
    }

    @Override
    public DeviceResponse updateDevice(Long id, DeviceRequest request) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException(id));

        device.setDeviceSerial(request.getDeviceSerial());
        device.setLocation(request.getLocation());
        device.setBatteryLevel(request.getBatteryLevel());

        deviceRepository.save(device);
        return mapToResponse(device);
    }

    private DeviceResponse mapToResponse(Device device) {
        return DeviceResponse.builder()
                .id(device.getId())
                .deviceSerial(device.getDeviceSerial())
                .location(device.getLocation())
                .batteryLevel(device.getBatteryLevel())
                .createdAt(device.getCreatedAt())
                .build();
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new JwtUtil.JwtValidationException("Пользователь не найден"));
    }
}