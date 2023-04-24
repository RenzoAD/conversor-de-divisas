package ApiServices.ApiCurrencyExchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Map;

public class ApiCurrencyExchange {

    private final String token = "Token " + System.getenv("API_KEY_CURRENCY");

    public String getJson() {
        String symbols = "USD%2CEUR%2CGBP%2CJPY%2CKRW%2CMXN%2CPEN";
        String url = "https://openexchangerates.org/api/latest.json?symbols=" + symbols;
        try {
            HttpResponse<String> jsonResquest = Unirest.get(url)
                    .header("Authorization", this.token)
                    .asString();
            System.out.println("Api Usada");
            return jsonResquest.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public DataApiExchange getDataApiExchange() {
        try {
            return new ObjectMapper().readValue(getJson(), DataApiExchange.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Double> getMapRates() {
        return getDataApiExchange().rates();
    }

}
