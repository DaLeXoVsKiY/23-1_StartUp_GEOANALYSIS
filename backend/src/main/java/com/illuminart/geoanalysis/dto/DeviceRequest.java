package com.illuminart.geoanalysis.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeviceRequest {

    @NotBlank
    private String deviceSerial;

    @NotBlank
    private String location;

    @Min(0)
    @Max(100)
    private Integer batteryLevel;
}