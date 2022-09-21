package com.semihshn.gatewayserver.entities.exception;

import lombok.Getter;

@Getter
public class SemRefreshTokenException extends RuntimeException {

    private final ExceptionType exceptionType;
    private String detail;

    public SemRefreshTokenException(ExceptionType exceptionType, String detail) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
        this.detail = detail;
    }

    public SemRefreshTokenException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
