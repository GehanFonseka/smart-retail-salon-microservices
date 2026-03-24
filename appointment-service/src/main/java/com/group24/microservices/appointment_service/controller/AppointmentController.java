package com.group24.microservices.appointment_service.controller;

import com.group24.microservices.appointment_service.model.Appointment;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private List<Appointment> list = new ArrayList<>(
            List.of(new Appointment(1, "2026-03-25"))
    );

    @GetMapping
    public List<Appointment> getAll() {
        return list;
    }

    @PostMapping
    public Appointment add(@RequestBody Appointment a) {
        list.add(a);
        return a;
    }
}