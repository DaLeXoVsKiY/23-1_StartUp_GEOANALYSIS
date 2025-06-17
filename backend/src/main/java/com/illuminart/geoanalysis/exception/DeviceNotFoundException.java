package com.illuminart.geoanalysis.exception;

public class DeviceNotFoundException extends RuntimeException {
    public DeviceNotFoundException(Long id) {
        super("Устройство с ID " + id + " не найдено");
    }
}

