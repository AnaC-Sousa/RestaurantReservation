package com.restaurante.restaurante.domain;

public enum RestaurantRate {
    BAD(1),
    AVERAGE(2),
    NICE(3),
    GOOD(4),
    EXCELLENT(5);

    int rate;
    RestaurantRate(int rate){
        this.rate = rate;
    }

}
