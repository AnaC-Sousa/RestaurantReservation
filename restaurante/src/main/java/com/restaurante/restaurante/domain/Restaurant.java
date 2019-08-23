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


    private int getReservationNumberOfPeople(){
        return this.reservation.getNumberOfPeople();
    }

    private int getBill(){
        return this.menu.getTotalPrice() * this.getReservationNumberOfPeople();
    }

    private void decrementCapacity(){
        currentCapacity = currentCapacity - this.getReservationNumberOfPeople();
    }

    private void incrementCurrentCapacity(){
        currentCapacity = currentCapacity + this.getReservationNumberOfPeople();
    }

    private List<Table> getFreeTables(){
        return tables.stream().filter(table -> table.getStatus() == TableStatus.FREE).collect(Collectors.toList());
    }

    private void reserveTables(){
        int numberOfPeople =  this.getReservationNumberOfPeople();
        int numberOfSeats = this.getFreeTables().size()/table.numberOfSeats;
        int numberOfSeatsToReserve = numberOfPeople / numberOfSeats;
        if(numberOfSeatsToReserve % 2 == 0){
            List<Table> tablesToReserve = this.getFreeTables().subList(0, numberOfSeatsToReserve-1);
            for(Table table : tablesToReserve){
                table.setStatus(TableStatus.RESERVED);
            }
        }else {
            List<Table> tablesToReserve = this.getFreeTables().subList(0, numberOfSeatsToReserve);
            for(Table table : tablesToReserve){
                table.setStatus(TableStatus.RESERVED);
            }
        }

    }

    private void freeTables(){
        for (Table table : tables){
            if(table.getReservation().getReservationStatus() == ReservationStatus.TERMINATED){
                table.setStatus(TableStatus.FREE);
            }
        }
    }

    private void GiveARate(RestaurantRate rate){
        this.rate = rate;
    }
}
