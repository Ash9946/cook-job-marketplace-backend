package com.example.cook_job_marketplace_backend.config;

import com.example.cook_job_marketplace_backend.entity.Role;
import com.example.cook_job_marketplace_backend.enums.RoleType;
import com.example.cook_job_marketplace_backend.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {

        for (RoleType roleType : RoleType.values()) {

            roleRepository.findByRoleName(roleType)
                    .orElseGet(() -> roleRepository.save(
                            Role.builder()
                                    .roleName(roleType)
                                    .build()
                    ));
        }

        System.out.println("Roles Initialized");
    }
}