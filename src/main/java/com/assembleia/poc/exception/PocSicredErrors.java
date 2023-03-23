package com.assembleia.poc.exception;

import lombok.Getter;

public enum PocSicredErrors {

    AGENDA_NOT_FOUND("Agenda Not Found"),
    VALUE_INVALID("Value invalid");

    @Getter
    private String message;

    PocSicredErrors(String message) {
        this.message = message;
    }
}
