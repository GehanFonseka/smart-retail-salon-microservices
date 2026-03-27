package com.group24.microservices.product_service.controller;

import com.group24.microservices.product_service.model.Product;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> products = new ArrayList<>(
            List.of(
                    new Product(1, "Shirt", 2500, "Clothing"),
                    new Product(2, "Shoes", 5000, "Footwear")
            )
    );

    @GetMapping
    public List<Product> getAll() {
        return products;
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Product create(@RequestBody Product p) {
        products.add(p);
        return p;
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product updated) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(updated.getName());
                p.setPrice(updated.getPrice());
                p.setCategory(updated.getCategory());
                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        products.removeIf(p -> p.getId() == id);
        return "Deleted successfully";
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}