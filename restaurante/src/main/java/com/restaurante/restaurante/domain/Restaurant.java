package com.restaurante.restaurante.domain;

import com.restaurante.restaurante.address.Address;
import com.restaurante.restaurante.menu.CountryFood;
import com.restaurante.restaurante.menu.FoodType;
import com.restaurante.restaurante.menu.Menu;

public class Restaurant {

    private int id;
    private String name;
    private Long phoneNumber;
    private Address address;
    private Reservation reservation;
    private int currentCapacity;
    private int maxCapacity;
    private CountryFood countryFood;
    private Menu menu;
    private Table table;
    private int bill;


    public Restaurant(int id, String name, Long phoneNumber, Address address, Reservation reservation, int maxCapacity, CountryFood countryFood, Menu menu) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.reservation = reservation;
        this.maxCapacity = maxCapacity;
        this.countryFood = countryFood;
        this.menu = menu;
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

    private int getReservationNumberOfPeople(){
        return this.reservation.getNumberOfPeople();
    }

    private int getBill(){
        return this.menu.getTotalPrice() * this.getReservationNumberOfPeople();
    }

    private int decrementCapacity(int capacity){
        currentCapacity = currentCapacity - this.getReservationNumberOfPeople();
        return currentCapacity;
    }

    private int incrementCurrentCapacity(){
        currentCapacity = currentCapacity + this.getReservationNumberOfPeople();
        return currentCapacity;
    }

    private int getNumberOfTables(){
       return currentCapacity/table.numberOfSeats;
    }


}
