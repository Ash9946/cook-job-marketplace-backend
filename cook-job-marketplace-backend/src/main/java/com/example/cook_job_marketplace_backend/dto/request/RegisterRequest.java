package com.example.cook_job_marketplace_backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String fullName;

    private String email;

    private String mobile;

    private String password;

    private String role;
}