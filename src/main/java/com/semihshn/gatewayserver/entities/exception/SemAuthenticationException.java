package com.semihshn.gatewayserver.entities.exception;

import lombok.Getter;

@Getter
public class SemAuthenticationException extends RuntimeException {

    private final ExceptionType exceptionType;
    private String detail;

    public SemAuthenticationException(ExceptionType exceptionType, String detail) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
        this.detail = detail;
    }

    public SemAuthenticationException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
