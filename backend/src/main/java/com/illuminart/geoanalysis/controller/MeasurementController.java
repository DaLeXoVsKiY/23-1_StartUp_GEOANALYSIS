//package com.illuminart.geoanalysis.controller;
//
//import com.illuminart.geoanalysis.dto.MeasurementRequest;
//import com.illuminart.geoanalysis.dto.MeasurementResponse;
//import com.illuminart.geoanalysis.service.MeasurementService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/measurements")
//@RequiredArgsConstructor
//public class MeasurementController {
//
//    private final MeasurementService measurementService;
//
//    @GetMapping
//    public List<MeasurementResponse> getAll(@RequestParam(required = false) Long deviceId) {
//        if (deviceId != null) {
//            return measurementService.getByDeviceId(deviceId);
//        }
//        return measurementService.getAll();
//    }
//
//    @PostMapping
//    public ResponseEntity<MeasurementResponse> add(@RequestBody @Valid MeasurementRequest request) {
//        MeasurementResponse response = measurementService.addMeasurement(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
//}
