package ru.liga.aachebotarev.currency.command.model;

import ru.liga.aachebotarev.currency.rate.RateCalculator;
import ru.liga.aachebotarev.currency.rate.RateCollector;
import ru.liga.aachebotarev.currency.rate.model.CurrencyRate;
import ru.liga.aachebotarev.currency.utils.PathsToRateSource;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Command {
    private final Currencies currency;
    private final TimePeriods timePeriod;

    private PathsToRateSource pathToFile;

    private RateCalculator rateCalculator = new RateCalculator();

    public Command(Currencies currency, TimePeriods timePeriod) {
        this.timePeriod = timePeriod;
        this.currency = currency;

        switch (this.currency) {
            case EUR -> this.pathToFile = PathsToRateSource.EURO;
            case TRY -> this.pathToFile = PathsToRateSource.LIRA;
            case USD -> this.pathToFile = PathsToRateSource.DOLLARS;
            default -> {
                return;
            }
        }
    }

    public List<String> execute() throws ParseException {
        List<String> resultLines = new ArrayList<>();

        RateCollector rateCollector = new RateCollector(this.pathToFile);

        switch (this.timePeriod) {
            case TOMORROW -> {
                List<String[]> lines = rateCollector.readLines(7);
                List<CurrencyRate> rates = rateCollector.collect(lines);
                // TODO: Остановился здесь
            }
        }

        return resultLines;
    }
}
