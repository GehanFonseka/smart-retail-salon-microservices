package com.group24.microservices.product_service.controller;

import com.group24.microservices.product_service.model.Product;
import com.group24.microservices.product_service.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
        seedData();
    }

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Product create(@RequestBody Product p) {
        if (p.getId() <= 0) {
            p.setId(nextId());
        }

        return productRepository.save(p);
    }


    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product updated) {
        return productRepository.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setPrice(updated.getPrice());
                    existing.setCategory(updated.getCategory());
                    return productRepository.save(existing);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        productRepository.deleteById(id);
        return "Deleted successfully";
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return productRepository.findAll().stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    private int nextId() {
        return productRepository.findAll().stream()
                .mapToInt(Product::getId)
                .max()
                .orElse(0) + 1;
    }

    private void seedData() {
        if (productRepository.count() == 0) {
            productRepository.saveAll(List.of(
                    new Product(1, "Shirt", 2500, "Clothing"),
                    new Product(2, "Shoes", 5000, "Footwear")
            ));
        }
    }
}