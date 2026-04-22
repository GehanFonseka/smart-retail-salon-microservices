package com.group24.microservices.customer_service.repository;

import com.group24.microservices.customer_service.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}