package com.group24.microservices.customer_service.model;

public class Customer {
    private int id;
    private String name;

    public Customer() {}

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}