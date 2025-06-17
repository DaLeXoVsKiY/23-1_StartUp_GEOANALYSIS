package com.illuminart.geoanalysis.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MeasurementResponse {
    private Long id;
    private Long deviceId;
    private Double temperature;
    private Double humidity;
    private Double light;
    private LocalDateTime timestamp;
}
