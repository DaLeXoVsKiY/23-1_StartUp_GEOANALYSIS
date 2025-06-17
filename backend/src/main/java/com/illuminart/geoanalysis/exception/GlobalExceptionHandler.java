package com.illuminart.geoanalysis.exception;

import com.illuminart.geoanalysis.dto.ApiErrorResponse;
import com.illuminart.geoanalysis.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new ApiErrorResponse(
                ex.getMessage(), 400, "Некорректный запрос"));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiErrorResponse> handleNullPointer(NullPointerException ex) {
        return ResponseEntity.status(500).body(new ApiErrorResponse(
                "Ошибка: обращение к null!", 500, "NullPointerException"));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(NoSuchElementException ex) {
        return ResponseEntity.status(404).body(new ApiErrorResponse(
                ex.getMessage(), 404, "Объект не найден"));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        return ResponseEntity.status(409).body(new ApiErrorResponse(
                ex.getMessage(), 409, "Пользователь уже существует"));
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidCredentials(InvalidCredentialsException ex) {
        return ResponseEntity.status(401).body(new ApiErrorResponse(
                ex.getMessage(), 401, "Ошибка авторизации"));
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<ApiErrorResponse> handleTokenExpired(TokenExpiredException ex) {
        return ResponseEntity.status(401).body(new ApiErrorResponse(
                ex.getMessage(), 401, "JWT истёк"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleUnexpectedException(Exception ex) {
        return ResponseEntity.status(500).body(new ApiErrorResponse(
                "Произошла неизвестная ошибка", 500, ex.getClass().getSimpleName()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        ApiErrorResponse response = new ApiErrorResponse(
                "Ошибка валидации",
                HttpStatus.BAD_REQUEST.value(),
                errors
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeviceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleDeviceNotFound(DeviceNotFoundException ex) {
        ApiErrorResponse response = new ApiErrorResponse(
                "Устройство не найдено",
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiErrorResponse> handleAccessDenied(AccessDeniedException ex) {
        ApiErrorResponse response = new ApiErrorResponse(
                "Доступ запрещён",
                HttpStatus.FORBIDDEN.value(),
                List.of("У вас нет прав для выполнения этого действия")
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(JwtUtil.JwtValidationException.class)
    public ResponseEntity<ApiErrorResponse> handleJwtValidation(JwtUtil.JwtValidationException ex) {
        ApiErrorResponse response = new ApiErrorResponse(
                "Ошибка авторизации (JWT)",
                HttpStatus.UNAUTHORIZED.value(),
                List.of(ex.getMessage())
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(JwtUtil.JwtValidationException.class)
    public ResponseEntity<ApiErrorResponse> handleJwt(JwtUtil.JwtValidationException ex) {
        ApiErrorResponse response = new ApiErrorResponse(
                "Ошибка авторизации",
                401,
                List.of(ex.getMessage())
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
