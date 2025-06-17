package com.illuminart.geoanalysis.exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("Неверный email или пароль");
    }
}

