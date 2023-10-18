package ru.liga.aachebotarev.currency.rate;

import ru.liga.aachebotarev.currency.rate.model.CurrencyRate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RateCalculator {
    public CurrencyRate forecast(List<CurrencyRate> latestRates) {
        double sum = 0.0;
        for (CurrencyRate currencyRate : latestRates) {
            sum += currencyRate.getRatePerNominal();
        }
        double rate = sum / latestRates.size();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);
        return new CurrencyRate(1, rate, latestRates.get(0).getCdx(), c.getTime());
    }
}
