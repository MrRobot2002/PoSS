package com.vu.localhost.poss.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ServiceBookingStatusEnum {
    FREE(0, "FREE"),

    SCHEDULED(1, "SCHEDULED"),

    COMPLETED(2, "COMPLETED"),

    CANCELLED(3, "CANCELLED");

    private Integer intValue;
    private String stringValue;

    ServiceBookingStatusEnum(Integer intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(stringValue);
    }

    public static ServiceBookingStatusEnum fromValue(String text) {
        for (ServiceBookingStatusEnum b : ServiceBookingStatusEnum.values()) {
            if (String.valueOf(b.stringValue).equals(text)) {
                return b;
            }
        }
        return null;
    }

    public static Long getEnumId(String text) {
        for (ServiceBookingStatusEnum b : ServiceBookingStatusEnum.values()) {
            if (String.valueOf(b.stringValue).equals(text)) {
                return Long.valueOf(b.ordinal());
            }
        }
        return null;
    }

    public static ServiceBookingStatusEnum getEnumById(Long id) {
        for (ServiceBookingStatusEnum b : ServiceBookingStatusEnum.values()) {
            if (b.ordinal() == id) {
                return b;
            }
        }
        return null;
    }

    public Long getOrdinal() {
        return Long.valueOf(this.ordinal());
    }

}
