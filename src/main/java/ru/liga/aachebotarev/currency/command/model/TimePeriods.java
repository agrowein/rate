package ru.liga.aachebotarev.currency.command.model;

public enum TimePeriods {
    TOMORROW ("tomorrow"),
    WEEK ("week");

    private String value;

    TimePeriods(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
