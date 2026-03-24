package com.group24.microservices.salon_service.controller;

import com.group24.microservices.salon_service.model.ServiceItem;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/services")
public class SalonController {

    private List<ServiceItem> services = new ArrayList<>(
            List.of(new ServiceItem(1, "Haircut"))
    );

    @GetMapping
    public List<ServiceItem> getAll() {
        return services;
    }

    @PostMapping
    public ServiceItem add(@RequestBody ServiceItem s) {
        services.add(s);
        return s;
    }
}