package com.sicred.poc.exception;

import lombok.Getter;

public enum PocSicredErrors {

    AGENDA_NOT_FOUND("Agenda Not Found");

    @Getter
    private String message;

    PocSicredErrors(String message) {
        this.message = message;
    }
}
