package com.se.wastemanagementsystem.exception;

import com.se.wastemanagementsystem.enums.ResponseCodes;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SwmsException extends RuntimeException {

    private String internalMessage;
    private HttpStatus httpStatusCode;
    private String customCode;

    public SwmsException(ResponseCodes errorCode) {
        super(errorCode.getMessage());
        this.internalMessage = errorCode.getMessage();
        this.httpStatusCode = errorCode.getHttpStatus();
        this.customCode = errorCode.getCustomCode();
    }

    public SwmsException(ResponseCodes errorCode, String message) {
        super(errorCode.getMessage());
        this.internalMessage = message;
        this.httpStatusCode = errorCode.getHttpStatus();
        this.customCode = errorCode.getCustomCode();
    }

    public SwmsException(ResponseCodes errorCode, String message, HttpStatus httpStatus) {
        super(errorCode.getMessage());
        this.internalMessage = message;
        this.httpStatusCode = httpStatus;
        this.customCode = errorCode.getCustomCode();
    }

}
