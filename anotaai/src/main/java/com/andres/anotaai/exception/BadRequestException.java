package com.andres.anotaai.exception;

public class BadRequestException extends NoStacktraceException{
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
