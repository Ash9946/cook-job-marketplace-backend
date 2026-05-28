package com.example.cook_job_marketplace_backend.service.auth;

import com.example.cook_job_marketplace_backend.dto.request.LoginRequest;
import com.example.cook_job_marketplace_backend.dto.request.RegisterRequest;
import com.example.cook_job_marketplace_backend.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    void forgotPassword(String email);

    void resetPassword(
            String token,
            String newPassword
    );

    void sendOtp(String email);

    void resetPasswordWithOtp(
            String email,
            String otp,
            String newPassword
    );
}