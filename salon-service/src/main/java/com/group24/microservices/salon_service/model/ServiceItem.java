package com.group24.microservices.salon_service.model;

public class ServiceItem {
    private int id;
    private String name;

    public ServiceItem() {}

    public ServiceItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}