package com.group24.microservices.order_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Product Service API",
                version = "1.0",
                description = "Manages product catalog including creation, retrieval, updating, and deletion of products within the Smart Retail system."
        )
)
public class SwaggerConfig {
}