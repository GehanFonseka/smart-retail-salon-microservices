package com.group24.microservices.payment_service.controller;

import com.group24.microservices.payment_service.model.Payment;
import com.group24.microservices.payment_service.repository.PaymentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
        seedData();
    }

    // GET ALL
    @GetMapping
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Payment getById(@PathVariable int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    // CREATE PAYMENT (INITIAL)
    @PostMapping
    public Payment create(@RequestBody Payment p) {
        p.setStatus("PENDING");
        p.setDate("2026-04-01");
        if (p.getId() <= 0) {
            p.setId(nextId());
        }

        return paymentRepository.save(p);
    }

    // PROCESS PAYMENT
    @PutMapping("/{id}/process")
    public String process(@PathVariable int id) {
        return paymentRepository.findById(id)
                .map(p -> {
                    p.setStatus("SUCCESS");
                    paymentRepository.save(p);
                    return "Payment processed successfully";
                })
                .orElse("Payment not found");
    }

    // FAIL PAYMENT
    @PutMapping("/{id}/fail")
    public String fail(@PathVariable int id) {
        return paymentRepository.findById(id)
                .map(p -> {
                    p.setStatus("FAILED");
                    paymentRepository.save(p);
                    return "Payment failed";
                })
                .orElse("Payment not found");
    }

    // REFUND PAYMENT
    @PutMapping("/{id}/refund")
    public String refund(@PathVariable int id) {
        return paymentRepository.findById(id)
                .map(p -> {
                    p.setStatus("REFUNDED");
                    paymentRepository.save(p);
                    return "Payment refunded";
                })
                .orElse("Payment not found");
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        paymentRepository.deleteById(id);
        return "Deleted successfully";
    }

    // FILTER BY STATUS
    @GetMapping("/status")
    public List<Payment> getByStatus(@RequestParam String status) {
        return paymentRepository.findAll().stream()
                .filter(p -> p.getStatus().equalsIgnoreCase(status))
                .toList();
    }

    // FILTER BY METHOD
    @GetMapping("/method")
    public List<Payment> getByMethod(@RequestParam String method) {
        return paymentRepository.findAll().stream()
                .filter(p -> p.getMethod().equalsIgnoreCase(method))
                .toList();
    }

    private int nextId() {
        return paymentRepository.findAll().stream()
                .mapToInt(Payment::getId)
                .max()
                .orElse(0) + 1;
    }

    private void seedData() {
        if (paymentRepository.count() == 0) {
            paymentRepository.saveAll(List.of(
                    new Payment(1, 101, 2500, "CARD", "SUCCESS", "2026-03-30"),
                    new Payment(2, 102, 5000, "CASH", "PENDING", "2026-03-31")
            ));
        }
    }
}