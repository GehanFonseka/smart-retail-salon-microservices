package com.group24.microservices.order_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

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