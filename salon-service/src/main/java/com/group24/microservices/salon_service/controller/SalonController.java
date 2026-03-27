package com.group24.microservices.salon_service.controller;

import com.group24.microservices.salon_service.model.ServiceItem;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/services")
public class SalonController {

    private List<ServiceItem> services = new ArrayList<>(
            List.of(
                    new ServiceItem(1, "Haircut", "Hair", 1500, 30, true),
                    new ServiceItem(2, "Facial", "Skin", 3000, 60, true),
                    new ServiceItem(3, "Spa", "Relax", 5000, 90, false)
            )
    );

    // GET ALL
    @GetMapping
    public List<ServiceItem> getAll() {
        return services;
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ServiceItem getById(@PathVariable int id) {
        return services.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // CREATE
    @PostMapping
    public ServiceItem create(@RequestBody ServiceItem s) {
        services.add(s);
        return s;
    }

    // UPDATE
    @PutMapping("/{id}")
    public ServiceItem update(@PathVariable int id, @RequestBody ServiceItem updated) {
        for (ServiceItem s : services) {
            if (s.getId() == id) {
                s.setName(updated.getName());
                s.setCategory(updated.getCategory());
                s.setPrice(updated.getPrice());
                s.setDuration(updated.getDuration());
                s.setAvailable(updated.isAvailable());
                return s;
            }
        }
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        services.removeIf(s -> s.getId() == id);
        return "Service deleted successfully";
    }

    // SEARCH BY NAME
    @GetMapping("/search")
    public List<ServiceItem> search(@RequestParam String name) {
        return services.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    // FILTER BY CATEGORY
    @GetMapping("/category")
    public List<ServiceItem> getByCategory(@RequestParam String category) {
        return services.stream()
                .filter(s -> s.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    // GET AVAILABLE SERVICES
    @GetMapping("/available")
    public List<ServiceItem> getAvailable() {
        return services.stream()
                .filter(ServiceItem::isAvailable)
                .toList();
    }
}