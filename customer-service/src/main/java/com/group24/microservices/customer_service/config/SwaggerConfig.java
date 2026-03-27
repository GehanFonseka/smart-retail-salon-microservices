package com.group24.microservices.customer_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Customer Service API",
                version = "1.0",
                description = "Handles customer information including registration, profile management, and retrieval of customer details."
        )
)
public class SwaggerConfig {
}