package com.restaurante.restaurante.domain.reservation;

import com.restaurante.restaurante.domain.Client;
import com.restaurante.restaurante.domain.Restaurant;
import com.restaurante.restaurante.domain.menu.Menu;
import com.restaurante.restaurante.domain.reservation.ReservationStatus;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Restaurant restaurant;

    @Column(name = "NUMBER_OF_PEOPLE")
    private int numberOfPeople;

    @Column(name = "MENU")
    private Menu menu;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @Column(name = "DESCRIPTION")
    private String description;



    public Reservation(int numberOfPeople, Menu menu, ReservationStatus status) {
        this.numberOfPeople = numberOfPeople;
        this.menu = menu;
        this.status = status;
    }

    private void setDescription(){
        description = client.getName() + restaurant.getName() + menu.displayMenu() + status.toString();
    }
    public int getNumberOfPeople(){
        return this.numberOfPeople;
    }

    public ReservationStatus getReservationStatus(){
        return this.status;
    }


    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Menu getMenu() {
        return menu;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String displayReservation(){
        return description;
    }
}
