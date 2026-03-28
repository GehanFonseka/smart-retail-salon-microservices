package com.group24.microservices.api_gateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Smart Retail & Salon Microservices Platform")
                        .version("1.0")
                        .description("""
                                Unified API documentation for the Smart Retail & Salon Platform.

                                This gateway provides a central entry point for all core platform services,
                                including product, customer, order, salon, appointment, and payment management.
                                Use the Swagger UI service selector to explore each microservice.
                                """))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("API Gateway - Local Environment")
                ))
                .tags(List.of(
                        new Tag().name("API Gateway").description("Central gateway for routing requests and exposing unified platform API documentation"),
                        new Tag().name("Product Service").description("Manages product catalog, inventory data, and product-related operations"),
                        new Tag().name("Customer Service").description("Handles customer profiles, customer information, and account-related operations"),
                        new Tag().name("Order Service").description("Processes customer orders, order history, and order lifecycle operations"),
                        new Tag().name("Salon Service").description("Manages salon service catalog, service details, and salon offerings"),
                        new Tag().name("Appointment Service").description("Handles appointment booking, scheduling, and salon reservation management"),
                        new Tag().name("Payment Service").description("Processes payments, transaction records, and payment-related operations")
                ));
    }
}