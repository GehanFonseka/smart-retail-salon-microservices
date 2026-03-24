package com.group24.microservices.payment_service.controller;

import com.group24.microservices.payment_service.model.Payment;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private List<Payment> payments = new ArrayList<>(
            List.of(new Payment(1, 500.0))
    );

    @GetMapping
    public List<Payment> getAll() {
        return payments;
    }

    @PostMapping
    public Payment add(@RequestBody Payment p) {
        payments.add(p);
        return p;
    }
}