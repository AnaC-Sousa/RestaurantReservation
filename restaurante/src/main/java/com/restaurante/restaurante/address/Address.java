package com.restaurante.restaurante.address;

public class Address {

    private static String nameStreet;
    private static String buildingName;
    private static String buildingNumber;
    private static String floor;
    private static String direction;

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

    public static Address createClientAddress(){
        return new Address(nameStreet, buildingNumber, floor, direction );
    }

    public static Address getRestaurantAddress(){
        return new Address(nameStreet, buildingNumber);
    }
}
