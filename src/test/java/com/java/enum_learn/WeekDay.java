package com.java.enum_learn;

public enum WeekDay {
    MONDAY("monday"),
    SUNDAY("sunday");

    private String value;

    private WeekDay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
