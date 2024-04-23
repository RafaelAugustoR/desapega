package com.rafaelaugustor.desapega.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {
    MESSAGE("Message"),
    REQUEST("Request")
    ;
    private final String type;
}
