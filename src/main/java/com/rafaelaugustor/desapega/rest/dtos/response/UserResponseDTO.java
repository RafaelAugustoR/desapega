package com.rafaelaugustor.desapega.rest.dtos.response;

import com.rafaelaugustor.desapega.domain.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {

    private String name;

    private String cpf;

    private LocalDate birthDate;

    private String password;

    private String email;

    private String profilePicture;

    private Address address;
}
