package com.illuminart.geoanalysis.controller;

import com.illuminart.geoanalysis.dto.DeviceRequest;
import com.illuminart.geoanalysis.dto.DeviceResponse;
import com.illuminart.geoanalysis.service.DeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping
    public List<DeviceResponse> getAllDevices() {
        return deviceService.getAllDevicesForCurrentUser();
    }

    @GetMapping("/{id}")
    public DeviceResponse getDevice(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }

    @PostMapping
    public ResponseEntity<DeviceResponse> createDevice(@RequestBody @Valid DeviceRequest request) {
        DeviceResponse device = deviceService.createDevice(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(device);
    }

    @PatchMapping("/{id}")
    public DeviceResponse updateDevice(@PathVariable Long id,
                                       @RequestBody @Valid DeviceRequest request) {
        return deviceService.updateDevice(id, request);
    }
}
