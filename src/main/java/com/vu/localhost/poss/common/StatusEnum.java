package com.vu.localhost.poss.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {
    DONE(0, "DONE"),
    IN_PROCESS(1, "IN_PROCESS"),
    FREEZED(2, "FREEZED");

    private int intValue;
    private String stringValue;

    StatusEnum(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    @Override
    @JsonValue
    public String toString() {
        return stringValue;
    }

    public static StatusEnum fromInt(int code) {
        for (StatusEnum status : StatusEnum.values()) {
            if (status.getIntValue() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status code: " + code);
    }
}
