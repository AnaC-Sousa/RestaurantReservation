package com.restaurante.restaurante.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "NAME_STREET")
    private  String nameStreet;
    @Column(name = "BUILDING_NAME")
    private  String buildingName;
    @Column(name = "BUILDING_NUMBER")
    private  String buildingNumber;
    @Column(name = "FLOOR")
    private  String floor;
    @Column(name = "DIRECTION")
    private  String direction;

    public Address(){}
    private Address(String nameStreet, String buildingNumber){
        this.nameStreet = nameStreet;
        this.buildingNumber = buildingNumber;
    }


    private Address(String nameStreet, String buildingNumber, String floor, String direction){
        this.nameStreet = nameStreet;
        this.buildingNumber = buildingNumber;
        this.floor = floor;
        this.direction = direction;
    }

    public String getClientAddress(){
        return nameStreet + buildingNumber + floor + direction;
    }

    public String getRestaurantAddress(){
        return nameStreet + buildingNumber;
    }

    public static Address createClientAddress(String nameStreet, String buildingNumber, String floor, String direction){
        return new Address(nameStreet, buildingNumber, floor, direction );
    }
    public static Address createRestaurantAddress(String nameStreet, String buildingNumber){
        return new Address(nameStreet, buildingNumber);
    }
}
