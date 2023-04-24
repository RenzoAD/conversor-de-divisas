package Model;

import java.util.Arrays;

public enum ExchangeRate {
    De_Sol_a_Dolar("PEN-USD", "S/.", "$", 0.26),
    De_Sol_a_Euro("PEN-EUR", "S/.", "€", 0.24),
    De_Sol_a_Libras("PEN-GBP", "S/.", "£", 0.21),
    De_Sol_a_Yen("PEN-JPY", "S/.", "¥", 34.79),
    De_Sol_a_Won_Coreano("PEN-KRW", "S/.", "₩", 344.88),
    De_Sol_a_PesoMX("PEN-MXN", "S/.", "$", 4.98),
    De_Dolar_a_Sol("USD-PEN", "$", "S/.", 3.79),
    De_Dolar_a_PesoMX("USD-MXN", "$", "$", 18.91),
    De_Dolar_a_Won_Coreano("USD-KRW", "$", "₩", 1308.75),
    De_Dolar_a_Yen("USD-JPY", "$", "¥", 131.87),
    De_Dolar_a_Libras("USD-GBP", "$", "£", 0.82),
    De_Dolar_a_Euro("USD-EUR", "$", "€", 0.94);

    private final String currencyCodeConvert;
    private final String currencyCodeFrom;
    private final String currencyCodeTo;
    private final Double exchangeValue;

    ExchangeRate(String currencyCodeConvert, String currencyCodeFrom, String currencyCodeTo, double exchangeValue) {
        this.currencyCodeConvert = currencyCodeConvert;
        this.currencyCodeFrom = currencyCodeFrom;
        this.currencyCodeTo = currencyCodeTo;
        this.exchangeValue = exchangeValue;
    }

    public static Object[] getNames() {
            return Arrays.stream(ExchangeRate.values())
                    .map(x -> x.toString().replace("_"," "))
                    .toArray();
    }

    public String getCurrencyCodeConvert() {
        return currencyCodeConvert;
    }
    public String getCurrencyCodeFrom() {
        return currencyCodeFrom;
    }
    public String getCurrencyCodeTo() {
        return currencyCodeTo;
    }
    public Double getExchangeValue() {
        return exchangeValue;
    }
}
