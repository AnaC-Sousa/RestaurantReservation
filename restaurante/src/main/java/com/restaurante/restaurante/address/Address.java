package com.restaurante.restaurante.address;

public class Address {

    private  String nameStreet;
    private  String buildingName;
    private  String buildingNumber;
    private  String floor;
    private  String direction;

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
