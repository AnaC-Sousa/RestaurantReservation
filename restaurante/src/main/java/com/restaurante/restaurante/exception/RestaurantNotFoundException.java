package com.restaurante.restaurante.exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(int id) {
        super("Could not find restaurant " + id);
    }
}
