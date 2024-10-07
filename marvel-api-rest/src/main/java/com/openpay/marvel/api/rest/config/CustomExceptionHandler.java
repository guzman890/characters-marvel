package com.openpay.marvel.api.rest.config;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Map<String, String>> handleFeignNotFoundException(FeignException.NotFound e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Resource not found");
        response.put("status", e.status() + "");
        response.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity<Map<String, String>> handleFeignBadRequestException(FeignException.BadRequest e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Bad request");
        response.put("status", e.status() + "");
        response.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(FeignException.InternalServerError.class)
    public ResponseEntity<Map<String, String>> handleFeignInternalServerErrorException(FeignException.InternalServerError e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Internal server error");
        response.put("status", e.status() + "");
        response.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Map<String, String>> handleFeignStatusException(FeignException e) {
        Map<String, String> response = new HashMap<>();
        HttpStatus status = HttpStatus.resolve(e.status());
        if (status == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        response.put("error", "Feign error");
        response.put("status", e.status() + "");
        response.put("message", e.getMessage());
        return ResponseEntity.status(status).body(response);
    }
}