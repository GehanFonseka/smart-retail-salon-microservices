package com.group24.microservices.product_service.controller;

import com.group24.microservices.product_service.model.Product;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private List<Product> products = new ArrayList<>(
            List.of(
                    new Product(1, "Shirt"),
                    new Product(2, "Shoes"),
                    new Product(3, "Watch")
            )
    );

    // GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    // GET product by ID
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // ADD product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        return removed ? "Deleted successfully" : "Product not found";
    }
}