package com.rafaelaugustor.desapega.rest.dtos.request;

import com.rafaelaugustor.desapega.domain.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String name;

    private String profilePicture;

    private LocalDate birthDate;

    private Address address;

}
