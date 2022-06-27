package com.semihshn.gatewayserver.ws.common;

import com.semihshn.gatewayserver.entities.exception.ExceptionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionResponse {
    private Integer code;
    private String message;
    private String detail;

    public ExceptionResponse(ExceptionType exceptionType, String detail) {
        this.code = exceptionType.getCode();
        this.message = exceptionType.getMessage();
        this.detail = detail;
    }

}
