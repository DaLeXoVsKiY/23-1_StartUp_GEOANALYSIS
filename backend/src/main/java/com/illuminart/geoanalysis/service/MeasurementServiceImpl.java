//package com.illuminart.geoanalysis.service;
//
//import com.illuminart.geoanalysis.dto.MeasurementRequest;
//import com.illuminart.geoanalysis.dto.MeasurementResponse;
//import com.illuminart.geoanalysis.entity.Device;
//import com.illuminart.geoanalysis.exception.DeviceNotFoundException;
//import com.illuminart.geoanalysis.repository.DeviceRepository;
//import com.illuminart.geoanalysis.repository.MeasurementRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class MeasurementServiceImpl implements MeasurementService {
//
//    private final MeasurementRepository measurementRepository;
//    private final DeviceRepository deviceRepository;
//
//    @Override
//    public List<MeasurementResponse> getAll() {
//        return measurementRepository.findAll().stream()
//                .map(this::mapToDto)
//                .toList();
//    }
//
//    @Override
//    public List<MeasurementResponse> getByDeviceId(Long deviceId) {
//        return measurementRepository.findByDeviceId(deviceId).stream()
//                .map(this::mapToDto)
//                .toList();
//    }
//
//    @Override
//    public MeasurementResponse addMeasurement(MeasurementRequest request) {
//        Device device = deviceRepository.findById(request.getDeviceId())
//                .orElseThrow(() -> new DeviceNotFoundException(request.getDeviceId()));
//
//        Measurement m = new Measurement();
//        m.setDevice(device);
//        m.setTemperature(request.getTemperature());
//        m.setHumidity(request.getHumidity());
//        m.setLight(request.getLight());
//        m.setTimestamp(LocalDateTime.now());
//
//        measurementRepository.save(m);
//        return mapToDto(m);
//    }
//
//    private MeasurementResponse mapToDto(Measurement m) {
//        return MeasurementResponse.builder()
//                .id(m.getId())
//                .deviceId(m.getDevice().getId())
//                .temperature(m.getTemperature())
//                .humidity(m.getHumidity())
//                .light(m.getLight())
//                .timestamp(m.getTimestamp())
//                .build();
//    }
//}
