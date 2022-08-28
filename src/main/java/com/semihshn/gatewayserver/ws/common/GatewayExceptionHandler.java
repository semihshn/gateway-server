package com.semihshn.gatewayserver.ws.common;

import com.semihshn.gatewayserver.entities.exception.ExceptionType;
import com.semihshn.gatewayserver.entities.exception.SemAuthenticationException;
import com.semihshn.gatewayserver.entities.exception.SemUserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GatewayExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(Exception e) {
        return new ExceptionResponse(ExceptionType.GENERIC_EXCEPTION, e.getMessage());
    }

    @ExceptionHandler(SemAuthenticationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse handleAuthenticationException(SemAuthenticationException e) {
        return new ExceptionResponse(e.getExceptionType(), e.getDetail());
    }

    @ExceptionHandler(SemUserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse handleUserAlreadyExistsException(SemUserAlreadyExistsException e) {
        return new ExceptionResponse(e.getExceptionType(), e.getDetail());
    }
}
