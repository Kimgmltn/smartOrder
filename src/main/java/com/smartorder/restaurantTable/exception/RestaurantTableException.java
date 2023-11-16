package com.smartorder.restaurantTable.exception;

public class RestaurantTableException extends RuntimeException {
    public RestaurantTableException() {
        super();
    }

    public RestaurantTableException(String message) {
        super(message);
    }

    public RestaurantTableException(String message, Throwable cause) {
        super(message, cause);
    }
}
