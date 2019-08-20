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

    public String getClientName(String firstName, String lastName){
        return firstName + lastName;
    }

    public Address getClientAddress(Address address){
        return this.address;
    }
}
