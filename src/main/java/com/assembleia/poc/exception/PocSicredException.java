package com.assembleia.poc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PocSicredException extends Exception {

    public PocSicredException(String message, Exception exception) {
        super(message, exception);
    }

    public PocSicredException(PocSicredErrors message) {
        super(message.getMessage());
    }
}
