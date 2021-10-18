package ru.netology.statistic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/dataCalculateSum.csv", delimiter = ';', numLinesToSkip = 1)
    void souldCalculateSum(String purchases, long expected) {

        StatisticsService service = new StatisticsService();

        long actual = service.calculateSum(strToLong(purchases));

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataFindMax.csv", delimiter = ';', numLinesToSkip = 1)
    void souldFindMax(String purchases, long expected) {

        StatisticsService service = new StatisticsService();

        long actual = service.findMax(strToLong(purchases));

        assertEquals(expected, actual);
    }

    //Перевод строки в массив long
    private long[] strToLong(String purchases) {
        String[] strPurchases = purchases.split(",");

        long[] longPurchases = new long[strPurchases.length];
        for (int i = 0; i < strPurchases.length; i++) {
            longPurchases[i] = Long.parseLong(strPurchases[i]);
        }
        return longPurchases;
    }
}