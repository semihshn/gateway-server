package com.semihshn.gatewayserver.entities.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {

    GENERIC_EXCEPTION(1, "Bilinmeyen bir sorun oluştu");

    private final Integer code;
    private final String message;
}
