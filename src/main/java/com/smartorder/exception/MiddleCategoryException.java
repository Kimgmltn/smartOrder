package com.smartorder.exception;

public class MiddleCategoryException extends RuntimeException{
    public MiddleCategoryException() {
        super();
    }

    public MiddleCategoryException(String message) {
        super(message);
    }

    public MiddleCategoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
