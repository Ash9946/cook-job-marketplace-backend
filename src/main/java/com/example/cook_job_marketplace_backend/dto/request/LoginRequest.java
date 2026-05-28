package com.example.cook_job_marketplace_backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String email;

    private String password;
}