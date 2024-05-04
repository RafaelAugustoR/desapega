package com.rafaelaugustor.desapega.rest.controllers;

import com.rafaelaugustor.desapega.rest.dtos.request.LoginRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.request.RegisterRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.response.LoginResponseDTO;
import com.rafaelaugustor.desapega.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.rafaelaugustor.desapega.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        log.info("Processing new request for login: {}", request.getEmail());
        LoginResponseDTO response = authService.login(request);
        log.info("A new user has been logged! {}", request.getEmail());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequestDTO request) {
        log.info("Processing new request for register: {}", request.getEmail());
        authService.register(request);
        log.info("A new user has been registered! {}", request.getEmail());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/confirm-email")
    public ResponseEntity<String> confirmEmail(@RequestParam String email) {
        log.info("Verifying email for user register: {}", email);
        authService.confirmEmail(email);
        log.info("Email confirmed successfully for user with email: {}", email);
        return ResponseEntity.ok("Email confirmed successfully!");
    }

}
