package com.rafaelaugustor.desapega.rest.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecoveryPasswordRequestDTO {

    private String password;
    private String confirmPassword;
}
