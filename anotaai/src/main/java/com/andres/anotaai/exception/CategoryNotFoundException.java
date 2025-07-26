package com.andres.anotaai.exception;

public class CategoryNotFoundException extends NoStacktraceException {

    public CategoryNotFoundException(final String message) {
        super(message);
    }

    public CategoryNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
