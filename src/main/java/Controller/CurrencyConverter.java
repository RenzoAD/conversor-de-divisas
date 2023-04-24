package Controller;

import ApiServices.ApiCurrencyExchange.ApiCurrencyExchange;
import Model.ExchangeRate;

import java.util.Map;

public class CurrencyConverter {

    private ApiCurrencyExchange apiCurrencyExchange;

    public CurrencyConverter(){
        apiCurrencyExchange = new ApiCurrencyExchange();
    }
    public double convert(Double amount, String operation) {
        String[] symbolCodes= getCodeConvert(operation).split("-");
        String symbolFrom = symbolCodes[0];
        String symbolTo = symbolCodes[1];
        Map<String, Double> mapRates = apiCurrencyExchange.getMapRates();
        return (mapRates.get(symbolTo)/ mapRates.get(symbolFrom)) * amount ;
    }
    public String getCurrencyTo(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).getCurrencyCodeTo();
    }

    public String getCurrencyFrom(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).getCurrencyCodeFrom();
    }
    public Double getExchangeValue(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).getExchangeValue();
    }
    public String getCodeConvert(String operation){
        return ExchangeRate.valueOf(operation.replace(" ","_")).getCurrencyCodeConvert();
    }
}
