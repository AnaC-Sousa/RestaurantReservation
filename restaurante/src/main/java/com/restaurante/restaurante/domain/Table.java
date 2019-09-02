package com.restaurante.restaurante.domain;

import javax.persistence.*;

@Entity
public class Table {
    @Id
    @GeneratedValue
    private Long id;
    public final int numberOfSeats = 4;
    @Column(name = "FORMAT")
    private String format;

    @Enumerated(EnumType.STRING)
    private TableLocation place;

    @Enumerated(EnumType.STRING)
    private TableStatus status = TableStatus.FREE;
    private Reservation reservation;


    private Table(String format, TableLocation place) {
        this.format = format;
        this.place = place;
    }

    public Table createTable(String format, TableLocation place){
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
