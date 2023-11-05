package com.smartorder.exception;

public class MainCategoryException extends RuntimeException{
    public MainCategoryException() {
        super();
    }

    public MainCategoryException(String message) {
        super(message);
    }

    public MainCategoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
