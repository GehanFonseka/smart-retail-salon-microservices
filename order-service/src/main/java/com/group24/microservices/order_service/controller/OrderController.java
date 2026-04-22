package com.group24.microservices.order_service.controller;

import com.group24.microservices.order_service.model.Order;
import com.group24.microservices.order_service.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Order create(@RequestBody Order o) {
        if (o.getId() <= 0) {
            o.setId(nextId());
        }

        return orderRepository.save(o);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable int id, @RequestBody Order updated) {
        return orderRepository.findById(id)
                .map(existing -> {
                    existing.setCustomerId(updated.getCustomerId());
                    existing.setProductName(updated.getProductName());
                    existing.setTotalAmount(updated.getTotalAmount());
                    return orderRepository.save(existing);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        orderRepository.deleteById(id);
        return "Order deleted";
    }

    private int nextId() {
        return orderRepository.findAll().stream()
                .mapToInt(Order::getId)
                .max()
                .orElse(0) + 1;
    }
}
// update 0 - 2026-03-25
