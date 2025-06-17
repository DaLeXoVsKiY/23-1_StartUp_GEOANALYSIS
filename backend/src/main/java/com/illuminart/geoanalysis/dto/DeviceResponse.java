package com.illuminart.geoanalysis.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DeviceResponse {

    private Long id;
    private String deviceSerial;
    private String location;
    private Integer batteryLevel;
    private LocalDateTime createdAt;
}
