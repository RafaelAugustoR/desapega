package com.rafaelaugustor.desapega.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {

    CONVERSATION("CONVERSATION"),
    ITEM_REQUEST("ITEM_REQUEST");

    private final String type;
}
