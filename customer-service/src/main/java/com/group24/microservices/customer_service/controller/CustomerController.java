package com.group24.microservices.customer_service.controller;

import com.group24.microservices.customer_service.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {



    private List<Customer> customers = new ArrayList<>();

    @GetMapping
    public List<Customer> getAll() {
        return customers;
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Customer create(@RequestBody Customer c) {
        customers.add(c);
        return c;
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer updated) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                c.setName(updated.getName());
                c.setEmail(updated.getEmail());
                c.setPhone(updated.getPhone());
                return c;
            }
        }
        return null;
    }








    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        customers.removeIf(c -> c.getId() == id);
        return "Customer deleted";
    }

    @GetMapping("/search")
    public List<Customer> search(@RequestParam String name) {
        return customers.stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
