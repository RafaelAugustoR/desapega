package com.rafaelaugustor.desapega.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionStatus {

    AVAILABLE("AVAILABLE"),
    IN_EXCHANGE("IN_EXCHANGE"),
    COMPLETED("COMPLETED"),
    CANCELED("CANCELED");

    private final String status;
}

