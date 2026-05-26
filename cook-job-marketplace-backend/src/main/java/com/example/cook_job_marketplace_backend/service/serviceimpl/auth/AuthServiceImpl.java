package com.example.cook_job_marketplace_backend.serviceimpl.auth;

import com.example.cook_job_marketplace_backend.dto.request.LoginRequest;
import com.example.cook_job_marketplace_backend.dto.request.RegisterRequest;
import com.example.cook_job_marketplace_backend.dto.response.AuthResponse;
import com.example.cook_job_marketplace_backend.entity.Role;
import com.example.cook_job_marketplace_backend.entity.User;
import com.example.cook_job_marketplace_backend.enums.RoleType;
import com.example.cook_job_marketplace_backend.repository.RoleRepository;
import com.example.cook_job_marketplace_backend.repository.UserRepository;
import com.example.cook_job_marketplace_backend.security.JwtService;
import com.example.cook_job_marketplace_backend.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {

            throw new RuntimeException("Email already exists");
        }

        RoleType roleType;

        if ("JOB_GIVER".equalsIgnoreCase(request.getRole())) {

            roleType = RoleType.ROLE_JOB_GIVER;

        } else {

            roleType = RoleType.ROLE_JOB_SEEKER;
        }

        Role role = roleRepository.findByRoleName(roleType)
                .orElseThrow(() ->
                        new RuntimeException("Role not found"));

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .isActive(true)
                .isVerified(true)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .message("User Registered Successfully")
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        String token = jwtService.generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .message("Login Successful")
                .build();
    }
}