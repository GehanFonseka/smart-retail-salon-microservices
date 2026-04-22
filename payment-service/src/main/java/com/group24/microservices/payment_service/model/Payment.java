package com.group24.microservices.payment_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class Payment {

    @Id
    private int id;
    private int orderId;
    private double amount;
    private String method;   // CARD, CASH, ONLINE
    private String status;   // PENDING, SUCCESS, FAILED, REFUNDED
    private String date;

    public Payment() {}

    public Payment(int id, int orderId, double amount, String method, String status, String date) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.date = date;
    }

    public int getId() { return id; }
    public int getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getStatus() { return status; }
    public String getDate() { return date; }

    public void setId(int id) { this.id = id; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setMethod(String method) { this.method = method; }
    public void setStatus(String status) { this.status = status; }
    public void setDate(String date) { this.date = date; }
}