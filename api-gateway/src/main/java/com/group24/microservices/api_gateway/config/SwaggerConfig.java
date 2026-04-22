package com.group24.microservices.api_gateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Smart Retail & Salon Microservices Platform")
                        .version("1.0")
                        .description("""
                                Unified API documentation for the Smart Retail & Salon Platform.

                                This API Gateway aggregates documentation from all core platform microservices.
                                Select a service from the dropdown menu to explore its full API documentation:

                                • Customer Service: Manages customer profiles and accounts
                                • Product Service: Manages product catalog and inventory
                                • Order Service: Processes orders and order management
                                • Salon Service: Manages salon service offerings
                                • Appointment Service: Handles appointment booking and scheduling
                                • Payment Service: Processes payments and transactions
                                """))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("API Gateway - Local")));
    }

}