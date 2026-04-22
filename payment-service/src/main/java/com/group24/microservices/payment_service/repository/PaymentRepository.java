package com.group24.microservices.payment_service.repository;

import com.group24.microservices.payment_service.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, Integer> {
}