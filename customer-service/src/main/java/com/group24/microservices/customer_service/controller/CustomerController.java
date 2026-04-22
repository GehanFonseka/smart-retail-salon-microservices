package com.group24.microservices.customer_service.controller;

import com.group24.microservices.customer_service.model.Customer;
import com.group24.microservices.customer_service.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Customer create(@RequestBody Customer c) {
        if (c.getId() <= 0) {
            c.setId(nextId());
        }

        return customerRepository.save(c);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer updated) {
        return customerRepository.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setEmail(updated.getEmail());
                    existing.setPhone(updated.getPhone());
                    return customerRepository.save(existing);
                })
                .orElse(null);
    }








    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        customerRepository.deleteById(id);
        return "Customer deleted";
    }

    @GetMapping("/search")
    public List<Customer> search(@RequestParam String name) {
        return customerRepository.findAll().stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    private int nextId() {
        return customerRepository.findAll().stream()
                .mapToInt(Customer::getId)
                .max()
                .orElse(0) + 1;
    }
}
