package com.rafaelaugustor.desapega.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionStatus {

    AVAILABLE("Disponível"),
    IN_EXCHANGE("Em processo"),
    COMPLETED("Finalizado"),
    CANCELED("Cancelado");

    private final String status;
}

