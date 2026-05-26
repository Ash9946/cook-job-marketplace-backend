package com.example.cook_job_marketplace_backend.repository;

import com.example.cook_job_marketplace_backend.entity.Role;
import com.example.cook_job_marketplace_backend.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleType roleType);
}
