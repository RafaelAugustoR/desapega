package com.rafaelaugustor.desapega.rest.controllers;

import com.rafaelaugustor.desapega.rest.dtos.request.EmailRequestDTO;
import com.rafaelaugustor.desapega.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rafaelaugustor.desapega.utils.Constants.APP_ROOT;

@RestController
@RequiredArgsConstructor
@RequestMapping(APP_ROOT + "/email")
public class EmailController {

    private final EmailService service;

    @PostMapping
    public ResponseEntity<Void> sendEmail(@RequestBody EmailRequestDTO request){
        service.sendEmail(request);
        return ResponseEntity.noContent().build();
    }
}
