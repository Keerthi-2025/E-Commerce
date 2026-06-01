package com.Ecom.E_commerce.exceptions;

import java.time.LocalDateTime;

import com.Ecom.E_commerce.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiRequestExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<com.Ecom.E_commerce.exception.ApiRequestExceptionModel> handleApiRequestException(
            ApiRequestException ex) {

        com.Ecom.E_commerce.exception.ApiRequestExceptionModel error = new com.Ecom.E_commerce.exception.ApiRequestExceptionModel(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}