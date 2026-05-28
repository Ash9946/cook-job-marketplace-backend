package com.example.cook_job_marketplace_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CookJobMarketplaceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookJobMarketplaceBackendApplication.class, args);
    }
}