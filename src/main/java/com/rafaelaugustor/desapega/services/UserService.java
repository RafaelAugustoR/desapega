package com.rafaelaugustor.desapega.services;

import com.rafaelaugustor.desapega.domain.entities.User;
import com.rafaelaugustor.desapega.repositories.UserRepository;
import com.rafaelaugustor.desapega.rest.dtos.request.UserRequestDTO;
import com.rafaelaugustor.desapega.rest.dtos.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository repository;

    public UserResponseDTO findUserByToken(Principal principal) {
        User user = repository.findByEmail(principal.getName());

        return UserResponseDTO.builder()
                .name(user.getName())
                .cpf(user.getCpf())
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .profilePicture(user.getProfilePicture())
                .address(user.getAddress())
                .build();
    }

    public void update(UserRequestDTO request, Principal principal){
        User user = repository.findByEmail(principal.getName());

        user.setName(request.getName());
        user.setAddress(request.getAddress());
        user.setBirthDate(request.getBirthDate());
        user.setProfilePicture(request.getProfilePicture());

        repository.save(user);
        log.info("User {} has been updated", user.getEmail());
    }

    public void delete(Principal principal){
        User user = repository.findByEmail(principal.getName());
        repository.delete(user);
    }
}
