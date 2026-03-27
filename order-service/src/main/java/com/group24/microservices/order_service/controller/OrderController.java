package com.group24.microservices.order_service.controller;

import com.group24.microservices.order_service.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private List<Order> orders = new ArrayList<>();

    @GetMapping
    public List<Order> getAll() {
        return orders;
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable int id) {
        return orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Order create(@RequestBody Order o) {
        orders.add(o);
        return o;
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable int id, @RequestBody Order updated) {
        for (Order o : orders) {
            if (o.getId() == id) {
                o.setProductName(updated.getProductName());
                o.setTotalAmount(updated.getTotalAmount());
                return o;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        orders.removeIf(o -> o.getId() == id);
        return "Order deleted";
    }
}