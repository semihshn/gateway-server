package com.semihshn.gatewayserver.entities.exception;

import lombok.Getter;

@Getter
public class SemUserAlreadyExistsException extends RuntimeException {

    private final ExceptionType exceptionType;
    private String detail;

    public SemUserAlreadyExistsException(ExceptionType exceptionType, String detail) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
        this.detail = detail;
    }

    public SemUserAlreadyExistsException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
