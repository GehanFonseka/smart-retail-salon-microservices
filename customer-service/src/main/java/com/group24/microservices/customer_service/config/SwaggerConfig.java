package com.group24.microservices.customer_service.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Customer Service API",
                version = "1.0",
                description = "Handles customer information including registration, profile management, and retrieval of customer details."
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "API Gateway - Local"
        )
)
public class SwaggerConfig {
}