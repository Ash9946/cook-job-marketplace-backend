package com.example.cook_job_marketplace_backend.controller.auth;

import com.example.cook_job_marketplace_backend.dto.request.LoginRequest;
import com.example.cook_job_marketplace_backend.dto.request.RegisterRequest;
import com.example.cook_job_marketplace_backend.dto.request.ResetPasswordOtpRequest;
import com.example.cook_job_marketplace_backend.dto.response.AuthResponse;
import com.example.cook_job_marketplace_backend.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(
            @RequestParam String email
    ) {

        authService.forgotPassword(email);

        return "Reset token sent to email";
    }

    @PostMapping("/reset-password")
    public String resetPassword(
            @RequestParam String token,
            @RequestParam String newPassword
    ) {

        authService.resetPassword(
                token,
                newPassword
        );

        return "Password reset successful";
    }
    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(
            @RequestParam String email) {

        authService.sendOtp(email);

        return ResponseEntity.ok("OTP Sent Successfully");
    }

    @PostMapping("/reset-password-otp")
    public ResponseEntity<String> resetPasswordWithOtp(
            @RequestBody ResetPasswordOtpRequest request) {

        authService.resetPasswordWithOtp(
                request.getEmail(),
                request.getOtp(),
                request.getNewPassword()
        );

        return ResponseEntity.ok(
                "Password Reset Successfully"
        );
    }
}