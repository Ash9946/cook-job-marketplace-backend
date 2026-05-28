package com.example.cook_job_marketplace_backend.service;

public interface EmailService {

    void sendEmail(
            String to,
            String subject,
            String body
    );
}