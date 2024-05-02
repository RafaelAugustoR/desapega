package com.rafaelaugustor.desapega.rest.controllers;

import com.rafaelaugustor.desapega.rest.dtos.request.RecoveryPasswordRequestDTO;
import com.rafaelaugustor.desapega.services.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.rafaelaugustor.desapega.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/recovery-password")
@RequiredArgsConstructor
public class PasswordController {

    private final PasswordService passwordService;

    @PostMapping("/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email){
        passwordService.verifyEmail(email);
        return ResponseEntity.ok("Email sent for verification!");
    }

    @PostMapping("/verify-otp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp, @PathVariable String email){
        passwordService.verifyOtp(otp, email);
        return ResponseEntity.ok("OTP verified!");
    }

    @PostMapping("/change-password/{email}")
    public ResponseEntity<String> changePassword(@RequestBody RecoveryPasswordRequestDTO request, @PathVariable String email){
        passwordService.changePassword(request, email);
        return ResponseEntity.ok("Password has been changed!");
    }

}
