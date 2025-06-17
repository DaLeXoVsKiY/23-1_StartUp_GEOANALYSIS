package com.illuminart.geoanalysis.service;

import com.illuminart.geoanalysis.dto.MeasurementRequest;
import com.illuminart.geoanalysis.dto.MeasurementResponse;

import java.util.List;

public interface MeasurementService {
    List<MeasurementResponse> getAll();
    List<MeasurementResponse> getByDeviceId(Long deviceId);
    MeasurementResponse addMeasurement(MeasurementRequest request);
}
