package com.group24.microservices.payment_service.model;

public class Payment {
    private int id;
    private double amount;

    public Payment() {}

    public Payment(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() { return id; }
    public double getAmount() { return amount; }

    public void setId(int id) { this.id = id; }
    public void setAmount(double amount) { this.amount = amount; }
}