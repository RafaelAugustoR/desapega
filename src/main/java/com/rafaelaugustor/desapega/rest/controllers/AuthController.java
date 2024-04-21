package com.rafaelaugustor.desapega.rest.controllers;

import com.rafaelaugustor.desapega.rest.dtos.request.RegisterRequestDTO;
import com.rafaelaugustor.desapega.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rafaelaugustor.desapega.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final AuthService authService;



    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequestDTO request) {
        this.authService.register(request);
        return ResponseEntity.noContent().build();
    }

}
