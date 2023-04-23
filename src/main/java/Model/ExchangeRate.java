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

    private String currencyCodeConvert;
    private String currencyCodeFrom;
    private String currencyCodeTo;
    private Double exchangeValue;

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
    public static String getCurrencyTo(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).currencyCodeTo;
    }
    public static String getCurrencyFrom(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).currencyCodeFrom;
    }
    public static Double getExchangeValue(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).exchangeValue;
    }
    public static Double getCodeConvert(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).exchangeValue;
    }
}