package com.group24.microservices.salon_service.repository;

import com.group24.microservices.salon_service.model.ServiceItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceItemRepository extends MongoRepository<ServiceItem, Integer> {
}