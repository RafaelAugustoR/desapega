package com.rafaelaugustor.desapega.rest.dtos.request;

import com.rafaelaugustor.desapega.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

    private String email;
    private String password;

    public LoginRequestDTO(User entity){
        BeanUtils.copyProperties(entity, this);
    }
}
