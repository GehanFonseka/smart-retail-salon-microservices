package com.group24.microservices.appointment_service.repository;

import com.group24.microservices.appointment_service.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment, Integer> {
}