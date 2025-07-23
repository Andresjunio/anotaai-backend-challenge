package com.andres.anotaai.exception;

public class DomainException extends NoStacktraceException{

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
