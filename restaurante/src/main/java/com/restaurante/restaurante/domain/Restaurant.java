package com.restaurante.restaurante.domain;

import com.restaurante.restaurante.domain.address.Address;
import com.restaurante.restaurante.domain.reservation.Reservation;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "CURRENT_CAPACITY")
    private int currentCapacity;

    @Column(name = "MAX_CAPACITY")
    private int maxCapacity;

    @Column(name = "BILL")
    private int bill;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @OneToMany(mappedBy = "restaurant")
    private List<Reservation> reservationList;

    public Long getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getBill() {
        return bill;
    }

    public Address getAddress() {
        return address;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    /*
    private Long phoneNumber;
    private CountryFood countryFood;
    private Menu menu;
    private Reservation reservation;
    private RestaurantRate rate;
    private List<Table> tables;
    private Table table;


    public Restaurant(String name, Long phoneNumber, Address address, int maxCapacity, CountryFood countryFood, Menu menu) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.maxCapacity = maxCapacity;
        this.countryFood = countryFood;
        this.menu = menu;
    }

    public void setId(Long id) {
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
    }*/
}

