package com.group24.microservices.salon_service.controller;

import com.group24.microservices.salon_service.model.ServiceItem;
import com.group24.microservices.salon_service.repository.ServiceItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/services")
public class SalonController {

    private final ServiceItemRepository serviceItemRepository;

    public SalonController(ServiceItemRepository serviceItemRepository) {
        this.serviceItemRepository = serviceItemRepository;
        seedData();
    }

    // GET ALL
    @GetMapping
    public List<ServiceItem> getAll() {
        return serviceItemRepository.findAll();
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ServiceItem getById(@PathVariable int id) {
        return serviceItemRepository.findById(id).orElse(null);
    }

    // CREATE
    @PostMapping
    public ServiceItem create(@RequestBody ServiceItem s) {
        if (s.getId() <= 0) {
            s.setId(nextId());
        }

        return serviceItemRepository.save(s);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ServiceItem update(@PathVariable int id, @RequestBody ServiceItem updated) {
        return serviceItemRepository.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setCategory(updated.getCategory());
                    existing.setPrice(updated.getPrice());
                    existing.setDuration(updated.getDuration());
                    existing.setAvailable(updated.isAvailable());
                    return serviceItemRepository.save(existing);
                })
                .orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        serviceItemRepository.deleteById(id);
        return "Service deleted successfully";
    }

    // SEARCH BY NAME
    @GetMapping("/search")
    public List<ServiceItem> search(@RequestParam String name) {
        return serviceItemRepository.findAll().stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    // FILTER BY CATEGORY
    @GetMapping("/category")
    public List<ServiceItem> getByCategory(@RequestParam String category) {
        return serviceItemRepository.findAll().stream()
                .filter(s -> s.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    // GET AVAILABLE SERVICES
    @GetMapping("/available")
    public List<ServiceItem> getAvailable() {
        return serviceItemRepository.findAll().stream()
                .filter(ServiceItem::isAvailable)
                .toList();
    }

    private int nextId() {
        return serviceItemRepository.findAll().stream()
                .mapToInt(ServiceItem::getId)
                .max()
                .orElse(0) + 1;
    }

    private void seedData() {
        if (serviceItemRepository.count() == 0) {
            serviceItemRepository.saveAll(List.of(
                    new ServiceItem(1, "Haircut", "Hair", 1500, 30, true),
                    new ServiceItem(2, "Facial", "Skin", 3000, 60, true),
                    new ServiceItem(3, "Spa", "Relax", 5000, 90, false)
            ));
        }
    }
}