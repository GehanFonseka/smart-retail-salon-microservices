package com.group24.microservices.order_service.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Order Service API",
                version = "1.0",
                description = "Processes customer orders, manages order details, and tracks order-related operations in the system."
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "API Gateway - Local"
        )
)
public class SwaggerConfig {
}