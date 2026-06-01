package com.Ecom.E_commerce.exception;

import java.time.LocalDateTime;

public class ApiRequestExceptionModel {

    private String message;
    private int statusCode;
    private LocalDateTime timestamp;

    public ApiRequestExceptionModel() {
    }

    public ApiRequestExceptionModel(String message, int statusCode, LocalDateTime timestamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }


}