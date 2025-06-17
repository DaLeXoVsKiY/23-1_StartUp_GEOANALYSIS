package com.illuminart.geoanalysis.exception;

public class TokenExpiredException extends RuntimeException {
    public TokenExpiredException() {
        super("JWT токен истёк. Необходимо авторизоваться заново.");
    }
}
