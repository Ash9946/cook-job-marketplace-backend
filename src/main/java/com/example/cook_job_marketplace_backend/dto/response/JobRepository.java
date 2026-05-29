package com.example.cook_job_marketplace_backend.dto.response;

import com.example.cook_job_marketplace_backend.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}