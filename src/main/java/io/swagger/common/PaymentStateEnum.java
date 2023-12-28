package io.swagger.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentStateEnum {
    UNPAID(0, "UNPAID"),

    PENDING(1, "PENDING"),

    PARTIALLY_PAID(2, "PARTIALLY_PAID"),

    PAID(3, "PAID");

    private Integer intValue;
    private String stringValue;

    PaymentStateEnum(Integer intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    @Override
    @JsonValue
    public String toString() {
        return stringValue;
    }

    public static PaymentStateEnum fromInt(int code) {
        for (PaymentStateEnum state : PaymentStateEnum.values()) {
            if (state.getIntValue() == code) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown payment state code: " + code);
    }
}
