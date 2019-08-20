package com.restaurante.restaurante.domain;

public class Table {
    public final int numberOfSeats = 4;
    private String format;
    private String place;


    private Table(String format, String place) {
        this.format = format;
        this.place = place;
    }

    public Table createTable(String format, String place){
        return new Table(format, place);
    }
}
