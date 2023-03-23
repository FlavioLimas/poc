package com.sicred.poc.exception;

import lombok.Getter;

public enum PocSicredErrors {

    AGENDA_NOT_FOUND("Agenda Not Found"),
    VALUE_INVALID("Value Invalid"),
    AGENDA_NOT_SAVED("Agenda Not Saved"),
    ID_MUST_BE_NULL_WHEN_SAVE("Id Must Be Null When Save");

    @Getter
    private String message;

    PocSicredErrors(String message) {
        this.message = message;
    }
}
