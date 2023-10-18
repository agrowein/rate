package ru.liga.aachebotarev.currency.rate.model;

import java.util.Date;

public class CurrencyRate {
    private final Integer nominal;
    private final Double rate;
    private final String cdx;
    private final Date date;

    public CurrencyRate(Integer nominal, Double rate, String cdx, Date date) {
        this.nominal = nominal;
        this.rate = rate;
        this.cdx = cdx;
        this.date = date;
    }

    public Double getRate() {
        return rate;
    }

    public Double getRatePerNominal() {
        return rate / nominal;
    }

    public Integer getNominal() {
        return nominal;
    }

    public String getCdx() {
        return cdx;
    }

    @Override()
    public String toString() {
        return String.format(
            "Currency: %s, rate: %f, date: %s",
            this.cdx,
            this.getRatePerNominal(),
            this.date.toString()
        );
    }
}
