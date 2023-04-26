package Controller;

import ApiServices.ApiCurrencyExchange.CurrencyExchange;
import Model.ExchangeRate;

import java.util.Map;

public class CurrencyConverterController {

    private final CurrencyExchange currencyExchange;

    public CurrencyConverterController(){
        currencyExchange = new CurrencyExchange();
    }
    public double convert(Double amount, String operation) {
        Map<String, Double> mapRates = currencyExchange.getMapRates();
        double from = mapRates.get(getSymbolFrom(operation));
        double to = mapRates.get(getSymbolTo(operation));
        return (to/ from) * amount ;
    }
    public String getSymbolFrom(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).getSymbolFrom();
    }
    public String getSymbolTo(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).getSymbolTo();
    }
    public String getCodeFrom(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).getCodeFrom();
    }
    public String getCodeTo(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).getCodeTo();
    }
}
