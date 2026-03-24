package com.group24.microservices.order_service.model;

public class Order {
    private int id;
    private String item;

    public Order() {}

    public Order(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public int getId() { return id; }
    public String getItem() { return item; }

    public void setId(int id) { this.id = id; }
    public void setItem(String item) { this.item = item; }
}