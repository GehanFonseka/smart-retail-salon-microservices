package com.group24.microservices.appointment_service.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Appointment Service API",
                version = "1.0",
                description = "Handles appointment scheduling, booking management, cancellations, and tracking of service appointments."
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "API Gateway - Local"
        )
)
public class SwaggerConfig {
}