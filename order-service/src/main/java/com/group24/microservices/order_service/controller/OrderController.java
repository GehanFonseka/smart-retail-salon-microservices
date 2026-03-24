package com.group24.microservices.order_service.controller;

import com.group24.microservices.order_service.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private List<Order> orders = new ArrayList<>(
            List.of(new Order(1, "Shirt"))
    );

    @GetMapping
    public List<Order> getAll() {
        return orders;
    }

    @PostMapping
    public Order add(@RequestBody Order o) {
        orders.add(o);
        return o;
    }
}