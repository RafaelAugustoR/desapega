package com.rafaelaugustor.desapega.rest.controllers;

import com.rafaelaugustor.desapega.rest.dtos.request.LoginRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.request.RecoveryPasswordRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.request.RegisterRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.response.LoginResponseDTO;
import com.rafaelaugustor.desapega.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.rafaelaugustor.desapega.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        LoginResponseDTO response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequestDTO request) {
        this.authService.register(request);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/recovery-password/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email){
        authService.verifyEmail(email);
        return ResponseEntity.ok("Email sent for verification!");
    }

    @PostMapping("/verify-otp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp, @PathVariable String email){
        authService.verifyOtp(otp, email);
        return ResponseEntity.ok("OTP verified!");
    }

    @PostMapping("/change-password/{email}")
    public ResponseEntity<String> changePassword(@RequestBody RecoveryPasswordRequestDTO request, @PathVariable String email){
        authService.changePassword(request, email);
        return ResponseEntity.ok("Password has been changed!");
    }

}
