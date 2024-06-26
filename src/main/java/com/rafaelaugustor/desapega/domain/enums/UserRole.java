package com.rafaelaugustor.desapega.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER");

    private final String role;
}
