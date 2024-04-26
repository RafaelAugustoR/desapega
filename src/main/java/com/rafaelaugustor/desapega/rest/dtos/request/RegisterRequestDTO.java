package com.rafaelaugustor.desapega.rest.dtos.request;

import com.rafaelaugustor.desapega.domain.entities.Address;
import com.rafaelaugustor.desapega.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {

    private String name;

    private String cpf;

    private LocalDate birthDate;

    private String password;

    private String confirmPassword;

    private String email;

    private String profilePicture;

    private Address address;

    public RegisterRequestDTO(User entity){
        BeanUtils.copyProperties(entity, this);
    }
}
