package ru.liga.aachebotarev.currency.rate;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import ru.liga.aachebotarev.currency.rate.model.CurrencyRate;
import ru.liga.aachebotarev.currency.utils.PathsToRateSource;

import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RateCollector {
    private final PathsToRateSource pathToFile;
    private char separator = ';';

    public RateCollector(PathsToRateSource pathToFile) {
        this.pathToFile = pathToFile;
    }

    public List<CurrencyRate> collect(List<String[]> lines) throws ParseException {
        List<CurrencyRate> currencyRates = new ArrayList<>();
        for (String[] line : lines) {
            currencyRates.add(new CurrencyRate(
                    Integer.valueOf(line[0]),
                    NumberFormat.getInstance(Locale.FRANCE).parse(line[2]).doubleValue(),
                    line[3],
                    new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(line[1])
            ));
        }
        return currencyRates;
    }

    public List<String[]> readLines() throws RuntimeException {
        try {
            FileReader fileReader = new FileReader(this.pathToFile.name());
            CSVParser csvParser = new CSVParserBuilder().withSeparator(this.separator).build();
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).withSkipLines(1).build();

            return csvReader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String[]> readLines(int countOfLines) throws RuntimeException {
        try {
            FileReader fileReader = new FileReader(this.pathToFile);
            CSVParser csvParser = new CSVParserBuilder().withSeparator(this.separator).build();
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).withSkipLines(1).build();

            List<String[]> chunk = new ArrayList<>();
            while (countOfLines != 0) {
                chunk.add(csvReader.readNext());
                countOfLines--;
            }

            return chunk;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }

    public String getPathToFile() {
        return pathToFile;
    }
}
