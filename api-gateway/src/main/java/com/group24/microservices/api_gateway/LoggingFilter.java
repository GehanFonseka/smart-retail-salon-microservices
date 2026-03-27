package com.group24.microservices.api_gateway;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class LoggingFilter {

    @Bean
    public GlobalFilter customFilter() {
        return (exchange, chain) -> {
            System.out.println("Incoming request: " + exchange.getRequest().getURI());
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        System.out.println("Response sent");
                    }));
        };
    }
}