package com.example.cook_job_marketplace_backend.service.auth;

import com.example.cook_job_marketplace_backend.dto.request.LoginRequest;
import com.example.cook_job_marketplace_backend.dto.request.RegisterRequest;
import com.example.cook_job_marketplace_backend.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}