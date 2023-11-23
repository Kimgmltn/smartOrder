package com.smartorder.orders.exception;

public class OrdersException extends RuntimeException{
    public OrdersException() {
        super();
    }

    public OrdersException(String message) {
        super(message);
    }

    public OrdersException(String message, Throwable cause) {
        super(message, cause);
    }
}
