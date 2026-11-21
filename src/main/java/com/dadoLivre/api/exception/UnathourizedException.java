package com.dadoLivre.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnathourizedException extends RuntimeException {
    public UnathourizedException(String message) {
        super(message);
    }
}
