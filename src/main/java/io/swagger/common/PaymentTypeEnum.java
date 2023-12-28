package io.swagger.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentTypeEnum {
    CARD(0, "CARD"),

    CASH(1, "CASH");

    private Integer intValue;
    private String stringValue;

    PaymentTypeEnum(Integer intValue, String stringValue) {
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

    public static PaymentTypeEnum fromInt(int code) {
        for (PaymentTypeEnum type : PaymentTypeEnum.values()) {
            if (type.getIntValue() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown payment type code: " + code);
    }
}
