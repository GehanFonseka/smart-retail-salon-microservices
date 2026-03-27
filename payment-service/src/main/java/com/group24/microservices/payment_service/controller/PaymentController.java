package com.group24.microservices.payment_service.controller;

import com.group24.microservices.payment_service.model.Payment;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private List<Payment> payments = new ArrayList<>(
            List.of(
                    new Payment(1, 101, 2500, "CARD", "SUCCESS", "2026-03-30"),
                    new Payment(2, 102, 5000, "CASH", "PENDING", "2026-03-31")
            )
    );

    // GET ALL
    @GetMapping
    public List<Payment> getAll() {
        return payments;
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Payment getById(@PathVariable int id) {
        return payments.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // CREATE PAYMENT (INITIAL)
    @PostMapping
    public Payment create(@RequestBody Payment p) {
        p.setStatus("PENDING");
        p.setDate("2026-04-01");
        payments.add(p);
        return p;
    }

    // PROCESS PAYMENT
    @PutMapping("/{id}/process")
    public String process(@PathVariable int id) {
        for (Payment p : payments) {
            if (p.getId() == id) {
                p.setStatus("SUCCESS");
                return "Payment processed successfully";
            }
        }
        return "Payment not found";
    }

    // FAIL PAYMENT
    @PutMapping("/{id}/fail")
    public String fail(@PathVariable int id) {
        for (Payment p : payments) {
            if (p.getId() == id) {
                p.setStatus("FAILED");
                return "Payment failed";
            }
        }
        return "Payment not found";
    }

    // REFUND PAYMENT
    @PutMapping("/{id}/refund")
    public String refund(@PathVariable int id) {
        for (Payment p : payments) {
            if (p.getId() == id) {
                p.setStatus("REFUNDED");
                return "Payment refunded";
            }
        }
        return "Payment not found";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        payments.removeIf(p -> p.getId() == id);
        return "Deleted successfully";
    }

    // FILTER BY STATUS
    @GetMapping("/status")
    public List<Payment> getByStatus(@RequestParam String status) {
        return payments.stream()
                .filter(p -> p.getStatus().equalsIgnoreCase(status))
                .toList();
    }

    // FILTER BY METHOD
    @GetMapping("/method")
    public List<Payment> getByMethod(@RequestParam String method) {
        return payments.stream()
                .filter(p -> p.getMethod().equalsIgnoreCase(method))
                .toList();
    }
}