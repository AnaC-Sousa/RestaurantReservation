package com.restaurante.restaurante.domain;

import com.restaurante.restaurante.menu.Menu;
import com.restaurante.restaurante.reservation.ReservationStatus;

public class Reservation {

    private int id;
    private int client_id;
    private int restaurant_id;
    private int numberOfPeople;
    private Menu menu;
    private ReservationStatus status;

    public Reservation(int id, int client_id, int restaurant_id, int numberOfPeople, Menu menu, ReservationStatus status) {
        this.id = id;
        this.client_id = client_id;
        this.restaurant_id = restaurant_id;
        this.numberOfPeople = numberOfPeople;
        this.menu = menu;
        this.status = status;
    }

    public int getNumberOfPeople(){
        return this.numberOfPeople;
    }
    public ReservationStatus getStatus(){
        return this.status;
    }
}
