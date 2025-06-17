package com.illuminart.geoanalysis.service;

import com.illuminart.geoanalysis.dto.DeviceRequest;
import com.illuminart.geoanalysis.dto.DeviceResponse;

import java.util.List;

public interface DeviceService {
    List<DeviceResponse> getAllDevicesForCurrentUser();
    DeviceResponse getDeviceById(Long id);
    DeviceResponse createDevice(DeviceRequest request);
    DeviceResponse updateDevice(Long id, DeviceRequest request);
}

