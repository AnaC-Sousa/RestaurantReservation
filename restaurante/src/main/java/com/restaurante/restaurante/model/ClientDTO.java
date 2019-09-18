package com.restaurante.restaurante.model;

import com.restaurante.restaurante.domain.reservation.Reservation;

import java.util.List;

public class ClientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private AddressDTO address;
    private List<Reservation> reservationList;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<Reservation> getReservationList(){
        return this.reservationList;
    }

    public void setReservationList(List<Reservation> reservationList){
        this.reservationList = reservationList;
    }
}
