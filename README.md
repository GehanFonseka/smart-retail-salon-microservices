# 🛒 Smart Retail & Salon Microservices System

## 📌 Overview

This project is a **Microservices-Based Backend System** developed for the IT4020 – Modern Topics in IT module at SLIIT.

The system combines:

* 🛒 E-commerce (Product & Order Management)
* 💇 Salon Booking System

Each functionality is implemented as an independent microservice and accessed through an **API Gateway**.

---

## 🎯 Objectives

* Understand microservices architecture
* Implement independent backend services
* Use API Gateway for centralized communication
* Provide API documentation using Swagger

---

## 🧩 Microservices

| Service             | Port | Description           |
| ------------------- | ---- | --------------------- |
| Customer Service    | 8081 | Manage customers      |
| Product Service     | 8082 | Manage products       |
| Order Service       | 8083 | Handle orders         |
| Salon Service       | 8084 | Manage salon services |
| Appointment Service | 8085 | Handle bookings       |
| Payment Service     | 8086 | Process payments      |
| API Gateway         | 8080 | Central routing       |

---

## 🌐 API Gateway

The API Gateway acts as a **single entry point**:

Example:
http://localhost:8080/products → Product Service
http://localhost:8080/customers → Customer Service

---


## ⚙️ Technologies Used

* Java (Spring Boot)
* Spring Cloud Gateway
* Maven
* Swagger (OpenAPI)

---

## 🚀 How to Run

### 🔹 Requirements

* Java 17+
* Maven
* IntelliJ IDEA (recommended)

---

### 🔹 Run Services (IMPORTANT ORDER)

1. customer-service
2. product-service
3. order-service
4. salon-service
5. appointment-service
6. payment-service
7. api-gateway

---

### 🔹 Run via Terminal

cd product-service
mvn spring-boot:run

Repeat for all services.

---

## 🧪 Testing

### 🔹 Swagger (Direct Access)

http://localhost:8082/swagger-ui.html
http://localhost:8081/swagger-ui.html

---

### 🔹 API Gateway Access

http://localhost:8080/products
http://localhost:8080/customers
http://localhost:8080/orders

---


## 👥 Team Contributions

| Member   | Contribution        |
| -------- | ------------------- |
| Member 1 | Customer Service    |
| Member 2 | Product Service     |
| Member 3 | Order Service       |
| Member 4 | Salon Service       |
| Member 5 | Appointment Service |
| Member 6 | Payment Service     |

---

## 🎯 Conclusion

This project demonstrates how microservices architecture can be used to build scalable and modular applications. The API Gateway simplifies communication by providing a unified entry point.

---

## ⚠️ Notes

* Each service runs independently
* API Gateway must be started last
* Ensure ports are not already in use

---

## 📚 Module

IT4020 – Modern Topics in IT
Sri Lanka Institute of Information Technology
