package com.group24.microservices.salon_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "services")
public class ServiceItem {

    @Id
    private int id;
    private String name;
    private String category;   // Hair, Spa, Facial
    private double price;
    private int duration;      // minutes
    private boolean available;

    public ServiceItem() {}

    public ServiceItem(int id, String name, String category, double price, int duration, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.duration = duration;
        this.available = available;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getDuration() { return duration; }
    public boolean isAvailable() { return available; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setAvailable(boolean available) { this.available = available; }
}