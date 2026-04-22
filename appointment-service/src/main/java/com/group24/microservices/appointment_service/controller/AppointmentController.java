package com.group24.microservices.appointment_service.controller;

import com.group24.microservices.appointment_service.model.Appointment;
import com.group24.microservices.appointment_service.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
        seedData();
    }

    // GET ALL
    @GetMapping
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Appointment getById(@PathVariable int id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    // CREATE APPOINTMENT
    @PostMapping
    public Appointment create(@RequestBody Appointment a) {
        a.setStatus("BOOKED"); // default status
        if (a.getId() <= 0) {
            a.setId(nextId());
        }

        return appointmentRepository.save(a);
    }

    // UPDATE APPOINTMENT
    @PutMapping("/{id}")
    public Appointment update(@PathVariable int id, @RequestBody Appointment updated) {
        return appointmentRepository.findById(id)
                .map(existing -> {
                    existing.setDate(updated.getDate());
                    existing.setTime(updated.getTime());
                    existing.setServiceName(updated.getServiceName());
                    existing.setCustomerId(updated.getCustomerId());
                    existing.setCustomerName(updated.getCustomerName());
                    existing.setStatus(updated.getStatus());
                    return appointmentRepository.save(existing);
                })
                .orElse(null);
    }

    // CANCEL APPOINTMENT
    @PutMapping("/{id}/cancel")
    public String cancel(@PathVariable int id) {
        return appointmentRepository.findById(id)
                .map(a -> {
                    a.setStatus("CANCELLED");
                    appointmentRepository.save(a);
                    return "Appointment cancelled";
                })
                .orElse("Appointment not found");
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        appointmentRepository.deleteById(id);
        return "Deleted successfully";
    }

    // FILTER BY DATE
    @GetMapping("/date")
    public List<Appointment> getByDate(@RequestParam String date) {
        return appointmentRepository.findAll().stream()
                .filter(a -> a.getDate().equals(date))
                .toList();
    }

    // FILTER BY CUSTOMER
    @GetMapping("/customer")
    public List<Appointment> getByCustomer(@RequestParam String name) {
        return appointmentRepository.findAll().stream()
                .filter(a -> a.getCustomerName().equalsIgnoreCase(name))
                .toList();
    }

    // FILTER BY STATUS
    @GetMapping("/status")
    public List<Appointment> getByStatus(@RequestParam String status) {
        return appointmentRepository.findAll().stream()
                .filter(a -> a.getStatus().equalsIgnoreCase(status))
                .toList();
    }

    private int nextId() {
        return appointmentRepository.findAll().stream()
                .mapToInt(Appointment::getId)
                .max()
                .orElse(0) + 1;
    }

    private void seedData() {
        if (appointmentRepository.count() == 0) {
            appointmentRepository.saveAll(List.of(
                    new Appointment(1, 101, "John", "Haircut", "2026-03-30", "10:30 AM", "BOOKED"),
                    new Appointment(2, 102, "Jane", "Facial", "2026-03-31", "02:00 PM", "COMPLETED")
            ));
        }
    }
}
// update 1 - 2026-03-23
