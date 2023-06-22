package com.leninvalenzuelapt.prueba.exception;

public class BadRequestException extends ApiException{
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
