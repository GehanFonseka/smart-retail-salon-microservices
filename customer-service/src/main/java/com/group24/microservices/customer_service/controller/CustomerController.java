package com.group24.microservices.customer_service.controller;

import com.group24.microservices.customer_service.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(
            List.of(
                    new Customer(1, "John"),
                    new Customer(2, "Jane")
            )
    );

    @GetMapping
    public List<Customer> getAll() {
        return customers;
    }

    @PostMapping
    public Customer add(@RequestBody Customer c) {
        customers.add(c);
        return c;
    }
}