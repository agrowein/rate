package ru.liga.aachebotarev.currency.utils;

public enum PathsToRateSource {
    DOLLARS ("src/main/resources/input/dollars.csv"),
    EURO ("src/main/resources/input/euro.csv"),
    LIRA ("src/main/resources/input/lira.csv");

    PathsToRateSource(String path) {}
}
