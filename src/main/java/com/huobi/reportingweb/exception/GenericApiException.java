package com.huobi.reportingweb.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GenericApiException extends RuntimeException {
    public GenericApiException() {
        super();
    }
    public GenericApiException(String message, Throwable cause) {
        super(message, cause);
    }
    public GenericApiException(String message) {
        super(message);
    }
    public GenericApiException(Throwable cause) {
        super(cause);
    }
}