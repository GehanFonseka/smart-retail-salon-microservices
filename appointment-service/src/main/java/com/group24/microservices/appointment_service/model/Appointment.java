package com.group24.microservices.appointment_service.model;


public class Appointment {

    private int id;
    private int customerId;
    private String customerName;
    private String serviceName;
    private String date;      // e.g., 2026-03-30
    private String time;      // e.g., 10:30 AM
    private String status;    // BOOKED, CANCELLED, COMPLETED

    public Appointment() {}

    public Appointment(int id, int customerId, String customerName,
                       String serviceName, String date, String time, String status) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.serviceName = serviceName;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getServiceName() { return serviceName; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }
    public void setStatus(String status) { this.status = status; }
}