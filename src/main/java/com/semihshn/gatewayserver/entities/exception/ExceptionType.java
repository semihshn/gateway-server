package com.semihshn.gatewayserver.entities.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {

    GENERIC_EXCEPTION(1, "Bilinmeyen bir sorun oluştu"),
    AUTHENTICATION_ERROR(4001, "Yetkiniz yok"),
    ALREADY_EXISTS(4002, "Zaten mevcut");

    private final Integer code;
    private final String message;
}
