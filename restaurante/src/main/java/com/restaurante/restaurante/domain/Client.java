package com.restaurante.restaurante.domain;

import com.restaurante.restaurante.address.Address;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private Address address;


    public Client(int id, String firstName, String lastName, long phoneNumber, Address address){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress(){
        return this.address;
    }

    public Long getPhoneNumber(){ return this.phoneNumber; }

    public void setName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setPhoneNumber(Long phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address){
        this.address = address;
    }
}
