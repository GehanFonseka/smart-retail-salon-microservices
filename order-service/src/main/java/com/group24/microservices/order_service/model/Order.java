package com.group24.microservices.order_service.model;

public class Order {
    private int id;
    private int customerId;
    private String productName;
    private double totalAmount;

    public Order() {}

    public Order(int id, int customerId, String productName, double totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.productName = productName;
        this.totalAmount = totalAmount;
    }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public String getProductName() { return productName; }
    public double getTotalAmount() { return totalAmount; }

    public void setId(int id) { this.id = id; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}