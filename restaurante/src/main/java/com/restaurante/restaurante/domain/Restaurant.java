package com.restaurante.restaurante.domain;

import com.restaurante.restaurante.address.Address;
import com.restaurante.restaurante.menu.CountryFood;
import com.restaurante.restaurante.menu.FoodType;
import com.restaurante.restaurante.menu.Menu;
import com.restaurante.restaurante.reservation.ReservationStatus;

import java.util.List;
import java.util.stream.Collectors;

public class Restaurant {

    private int id;
    private int currentCapacity;
    private int maxCapacity;
    private int bill;
    private Long phoneNumber;
    private String name;
    private CountryFood countryFood;
    private Menu menu;
    private RestaurantRate rate;
    private List<Table> tables;
    private Table table;
    private Address address;
    private Reservation reservation;


    public Restaurant(int id, String name, Long phoneNumber, Address address, int maxCapacity, CountryFood countryFood, Menu menu) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.maxCapacity = maxCapacity;
        this.countryFood = countryFood;
        this.menu = menu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCountryFood(CountryFood countryFood) {
        this.countryFood = countryFood;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRate(RestaurantRate rate) {
        this.rate = rate;
    }

    private int getReservationNumberOfPeople() {
        return this.reservation.getNumberOfPeople();
    }

    public int getBill() {
        return this.menu.getTotalPrice() * this.getReservationNumberOfPeople();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public CountryFood getCountryFood() {
        return countryFood;
    }


    private void decrementCapacity() {
        currentCapacity = currentCapacity - this.getReservationNumberOfPeople();
    }

    private void incrementCurrentCapacity() {
        currentCapacity = currentCapacity + this.getReservationNumberOfPeople();
    }

    private List<Table> getFreeTables() {
        return tables.stream().filter(table -> table.getStatus() == TableStatus.FREE).collect(Collectors.toList());
    }

    private void reserveTables() {
        int numberOfPeople = this.getReservationNumberOfPeople();
        int numberOfSeats = this.getFreeTables().size() / table.numberOfSeats;
        int numberOfSeatsToReserve = numberOfPeople / numberOfSeats;
        if (numberOfSeatsToReserve % 2 == 0) {
            List<Table> tablesToReserve = this.getFreeTables().subList(0, numberOfSeatsToReserve - 1);
            for (Table table : tablesToReserve) {
                table.setStatus(TableStatus.RESERVED);
            }
        } else {
            List<Table> tablesToReserve = this.getFreeTables().subList(0, numberOfSeatsToReserve);
            for (Table table : tablesToReserve) {
                table.setStatus(TableStatus.RESERVED);
            }
        }

    }

    private void freeTables() {
        for (Table table : tables) {
            if (table.getReservation().getReservationStatus() == ReservationStatus.TERMINATED) {
                table.setStatus(TableStatus.FREE);
            }
        }
    }
}

