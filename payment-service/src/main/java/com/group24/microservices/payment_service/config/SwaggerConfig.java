package com.group24.microservices.payment_service.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Payment Service API",
                version = "1.0",
                description = "Manages payment processing, transaction handling, payment status updates, and refund operations within the system."
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "API Gateway - Local"
        )
)
public class SwaggerConfig {
}