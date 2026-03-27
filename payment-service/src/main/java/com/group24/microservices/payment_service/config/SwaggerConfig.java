package com.group24.microservices.order_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Payment Service API",
                version = "1.0",
                description = "Manages payment processing, transaction handling, payment status updates, and refund operations within the system."
        )
)
public class SwaggerConfig {
}