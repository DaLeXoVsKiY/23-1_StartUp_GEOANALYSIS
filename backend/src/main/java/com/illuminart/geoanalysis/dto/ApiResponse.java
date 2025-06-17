package com.illuminart.geoanalysis.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private String message;
    private HttpStatus httpStatus;
    private T data;
    private LocalDateTime timestamp;

    public ApiResponse(String message, HttpStatus httpStatus, T data) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

}


