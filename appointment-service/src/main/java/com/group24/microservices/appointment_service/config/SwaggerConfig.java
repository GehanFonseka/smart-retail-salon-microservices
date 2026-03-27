package com.group24.microservices.appointment_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Appointment Service API",
                version = "1.0",
                description = "Handles appointment scheduling, booking management, cancellations, and tracking of service appointments."
        )
)
public class SwaggerConfig {
}