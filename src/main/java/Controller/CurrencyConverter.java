package Controller;

import Model.ExchangeRate;
public class CurrencyConverter {

    public static double convert(Double amount, String operation) {
        return amount * ExchangeRate.getExchangeValue(operation);
    }

}
