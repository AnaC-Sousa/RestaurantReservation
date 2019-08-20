package com.restaurante.restaurante.domain;

import com.restaurante.restaurante.address.Address;
import com.restaurante.restaurante.menu.Menu;

public class Restaurant {

    private String name;
    private Long phoneNumber;
    private Address address;
    private Reservation reservation;
    private int currentCapacity;
    private int maxCapacity;
    private FoodType foodType;
    private Menu menu;
    private Table table;


    public Restaurant(String name, Long phoneNumber, Address address, Reservation reservation, int maxCapacity, FoodType foodType, Menu menu, Table table) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.reservation = reservation;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = maxCapacity;
        this.foodType = foodType;
        this.menu = menu;
        this.table = table;
    }

    public Long getPhoneNumber(){
        return this.phoneNumber;
    }
    public Menu getMenu(){
        return this.menu;
    }

    public int getCapacity(){
        return this.currentCapacity;
    }

    public Address getAddress(){
        return this.address;
    }
    public Reservation getReservation() {
        return this.reservation;
    }
    public int getReservationNumberOfPeople(){
        return this.reservation.getNumberOfPeople();
    }

    private int decrementCapacity(int capacity){
        currentCapacity = currentCapacity - this.getReservationNumberOfPeople();
        return currentCapacity;
    }

    private int incrementCurrentCapacity(){
        currentCapacity = currentCapacity + this.getReservationNumberOfPeople();
        return currentCapacity;
    }



}
