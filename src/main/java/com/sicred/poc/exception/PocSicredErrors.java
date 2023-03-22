package com.sicred.poc.exception;

import lombok.Getter;

public enum PocSicredErrors {

    ORIGIN_NOT_SAVED("Origin not saved on database");

    @Getter
    private String message;

    PocSicredErrors(String message) {
        this.message = message;
    }
}
