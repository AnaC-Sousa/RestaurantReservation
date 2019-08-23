package com.restaurante.restaurante.domain;

public class Table {
    public final int numberOfSeats = 4;
    private String format;
    private Location place;
    private TableStatus status = TableStatus.FREE;
    private Reservation reservation;


    private Table(String format, Location place) {
        this.format = format;
        this.place = place;
    }

    public Table createTable(String format, Location place){
        return new Table(format, place);
    }

    public TableStatus getStatus(){
        return this.status;
    }

    public void setStatus(TableStatus status){
        this.status = status;
    }

    public Reservation getReservation(){
        return this.reservation;
    }
}
