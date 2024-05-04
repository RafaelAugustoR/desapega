package com.rafaelaugustor.desapega.rest.controllers;

import com.rafaelaugustor.desapega.rest.dtos.request.RecoveryPasswordRequestDTO;
import com.rafaelaugustor.desapega.services.PasswordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.rafaelaugustor.desapega.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/recovery-password")
@RequiredArgsConstructor
@Slf4j
public class PasswordController {

    private final PasswordService passwordService;

    @PostMapping("/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email) {
        log.info("Verifying email for password recovery: {}", email);
        passwordService.verifyEmail(email);
        log.info("Email sent for verification: {}", email);
        return ResponseEntity.ok("Email sent for verification!");
    }

    @PostMapping("/verify-otp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp, @PathVariable String email) {
        log.info("Verifying OTP {} for email {}", otp, email);
        passwordService.verifyOtp(otp, email);
        log.info("OTP verified for email: {}", email);
        return ResponseEntity.ok("OTP verified!");
    }

    @PostMapping("/change-password/{email}")
    public ResponseEntity<String> changePassword(@RequestBody RecoveryPasswordRequestDTO request, @PathVariable String email) {
        log.info("Changing password for email: {}", email);
        passwordService.changePassword(request, email);
        log.info("Password changed for email: {}", email);
        return ResponseEntity.ok("Password has been changed!");
    }

}
