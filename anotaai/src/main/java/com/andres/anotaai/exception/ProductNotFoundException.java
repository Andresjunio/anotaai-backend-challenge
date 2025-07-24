package com.andres.anotaai.exception;

public class ProductNotFoundException extends NoStacktraceException{

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
