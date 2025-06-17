package com.illuminart.geoanalysis.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
public class ApiErrorResponse {
    private String message;
    private int status;
    private List<String> errors;
    private LocalDateTime timestamp;

    public ApiErrorResponse(String message, int status, String errorMessage) {
        this.message = message;
        this.status = status;
        this.errors = Arrays.asList(errorMessage);
        this.timestamp = LocalDateTime.now();
    }

    public ApiErrorResponse(String message, int status, List<String> errors) {
        this.message = message;
        this.status = status;
        this.errors = errors; // полноценный список
        this.timestamp = LocalDateTime.now();
    }


}
