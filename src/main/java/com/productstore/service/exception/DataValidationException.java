package com.productstore.service.exception;

public class DataValidationException extends RuntimeException {
    
    public DataValidationException(String message) {
        super(message);
    }
    
    public DataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}