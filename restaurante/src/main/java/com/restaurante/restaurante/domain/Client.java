package com.restaurante.restaurante.domain;

import com.restaurante.restaurante.address.Address;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "PHONE_NUMBER")
    private long phoneNumber;

    @OneToOne
    private Address address;


    public Client(){}
    public Client(Long id, String firstName, String lastName, long phoneNumber, Address address){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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
