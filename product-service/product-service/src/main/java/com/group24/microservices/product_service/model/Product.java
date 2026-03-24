package com.group24.microservices.product_service.model;

public class Product {

    private int id;
    private String name;

    // Constructor
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Default constructor
    public Product() {}

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
