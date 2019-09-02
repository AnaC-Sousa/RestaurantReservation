package com.restaurante.restaurante.domain;

import com.restaurante.restaurante.menu.Menu;
import com.restaurante.restaurante.reservation.ReservationStatus;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "CLIENT_ID")
    private int client_id;
    @Column(name = "RESTAURANT_ID")
    private int restaurant_id;
    @Column(name = "NUMBER_OF_PEOPLE")
    private int numberOfPeople;
    @Column(name = "MENU")
    private Menu menu;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public Reservation(Long id, int client_id, int restaurant_id, int numberOfPeople, Menu menu, ReservationStatus status) {
        this.id = id;
        this.client_id = client_id;
        this.restaurant_id = restaurant_id;
        this.numberOfPeople = numberOfPeople;
        this.menu = menu;
        this.status = status;
    }

    int getNumberOfPeople(){
        return this.numberOfPeople;
    }

    ReservationStatus getReservationStatus(){
        return this.status;
    }
}
