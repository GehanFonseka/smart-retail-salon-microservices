package com.group24.microservices.salon_service.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Salon Service API",
                version = "1.0",
                description = "Manages salon services such as haircuts, spa treatments, and beauty services, including pricing, categories, and availability."
        )
)
public class SwaggerConfig {
}