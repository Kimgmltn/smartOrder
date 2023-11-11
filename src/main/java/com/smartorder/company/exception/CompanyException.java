package com.smartorder.company.exception;

public class CompanyException extends RuntimeException{
    public CompanyException() {
        super();
    }

    public CompanyException(String message) {
        super(message);
    }

    public CompanyException(String message, Throwable cause) {
        super(message, cause);
    }
}
