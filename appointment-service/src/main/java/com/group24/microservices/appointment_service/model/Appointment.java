package com.group24.microservices.appointment_service.model;

public class Appointment {
    private int id;
    private String date;

    public Appointment() {}

    public Appointment(int id, String date) {
        this.id = id;
        this.date = date;
    }

    public int getId() { return id; }
    public String getDate() { return date; }

    public void setId(int id) { this.id = id; }
    public void setDate(String date) { this.date = date; }
}