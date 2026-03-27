package com.group24.microservices.appointment_service.controller;

import com.group24.microservices.appointment_service.model.Appointment;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private List<Appointment> appointments = new ArrayList<>(
            List.of(
                    new Appointment(1, 101, "John", "Haircut", "2026-03-30", "10:30 AM", "BOOKED"),
                    new Appointment(2, 102, "Jane", "Facial", "2026-03-31", "02:00 PM", "COMPLETED")
            )
    );

    // GET ALL
    @GetMapping
    public List<Appointment> getAll() {
        return appointments;
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Appointment getById(@PathVariable int id) {
        return appointments.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // CREATE APPOINTMENT
    @PostMapping
    public Appointment create(@RequestBody Appointment a) {
        a.setStatus("BOOKED"); // default status
        appointments.add(a);
        return a;
    }

    // UPDATE APPOINTMENT
    @PutMapping("/{id}")
    public Appointment update(@PathVariable int id, @RequestBody Appointment updated) {
        for (Appointment a : appointments) {
            if (a.getId() == id) {
                a.setDate(updated.getDate());
                a.setTime(updated.getTime());
                a.setServiceName(updated.getServiceName());
                return a;
            }
        }
        return null;
    }

    // CANCEL APPOINTMENT
    @PutMapping("/{id}/cancel")
    public String cancel(@PathVariable int id) {
        for (Appointment a : appointments) {
            if (a.getId() == id) {
                a.setStatus("CANCELLED");
                return "Appointment cancelled";
            }
        }
        return "Appointment not found";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        appointments.removeIf(a -> a.getId() == id);
        return "Deleted successfully";
    }

    // FILTER BY DATE
    @GetMapping("/date")
    public List<Appointment> getByDate(@RequestParam String date) {
        return appointments.stream()
                .filter(a -> a.getDate().equals(date))
                .toList();
    }

    // FILTER BY CUSTOMER
    @GetMapping("/customer")
    public List<Appointment> getByCustomer(@RequestParam String name) {
        return appointments.stream()
                .filter(a -> a.getCustomerName().equalsIgnoreCase(name))
                .toList();
    }

    // FILTER BY STATUS
    @GetMapping("/status")
    public List<Appointment> getByStatus(@RequestParam String status) {
        return appointments.stream()
                .filter(a -> a.getStatus().equalsIgnoreCase(status))
                .toList();
    }
}