package com.rafaelaugustor.desapega.rest.controllers;

import com.rafaelaugustor.desapega.rest.dtos.request.UserRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.response.UserResponseDTO;
import com.rafaelaugustor.desapega.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static com.rafaelaugustor.desapega.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<UserResponseDTO> findUserByToken(Principal principal){
        var user = service.findUserByToken(principal);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody UserRequestDTO request, Principal principal){
         service.update(request, principal);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(Principal principal){
        service.delete(principal);
        return ResponseEntity.noContent().build();
    }

}
