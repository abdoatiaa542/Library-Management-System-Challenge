package com.example.lms.controller;


import com.example.lms.dto.LoginRequest;
import com.example.lms.dto.RegistrationRequest;
import com.example.lms.service.auth.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService service;
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest request) {
        log.info("Login attempt for username: {}", request.username());
        return ResponseEntity.accepted().body(service.loginUser(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@RequestParam(value = "device-token", required = false) String deviceToken) {
        log.info("Logout attempt. Device token: {}", deviceToken);
        return ResponseEntity.accepted().body(service.logoutUser(deviceToken));
    }

    @PostMapping("/register/admin")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody RegistrationRequest request) {
        log.info("Registering new Admin: {}", request.username());
        return ResponseEntity.created(URI.create("/api/v1/auth/user-registration"))
                .body(service.registerAdmin(request));
    }

    @PostMapping("/register/librarian")
    public ResponseEntity<?> registerLibrarian(@Valid @RequestBody RegistrationRequest request) {
        log.info("Registering new Librarian: {}", request.username());
        return ResponseEntity.created(URI.create("/api/v1/auth/user-registration"))
                .body(service.registerLibrarian(request));
    }

    @PostMapping("/register/staff")
    public ResponseEntity<?> registerStaff(@Valid @RequestBody RegistrationRequest request) {
        log.info("Registering new Staff: {}", request.username());
        return ResponseEntity.created(URI.create("/api/v1/auth/user-registration"))
                .body(service.registerStaff(request));
    }

    @PostMapping("/register/member")
    public ResponseEntity<?> registerMember(@Valid @RequestBody RegistrationRequest request) {
        log.info("Registering new Member: {}", request.username());
        return ResponseEntity.created(URI.create("/api/v1/auth/user-registration"))
                .body(service.registerMember(request));
    }
}

