package ApiServices.ApiCurrencyExchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CurrencyExchange {

    private static final String TOKEN = "Token " + System.getenv("API_KEY_CURRENCY");
    private static final Long TIME_TO_UPDATE = TimeUnit.HOURS.toMillis(1);
    private static final String FILE_NAME_LOG = "CurrencyAPI";
    private final APIPersistenceLog apiPersistenceLog;
    private final DataAPI dataAPI;

    public CurrencyExchange(){
        apiPersistenceLog = new APIPersistenceLog();
        dataAPI = getDataObject();
        updateRates();
    }

    public String getJsonAPI() {
        String symbols = "USD%2CEUR%2CGBP%2CJPY%2CKRW%2CMXN%2CPEN";
        String url = "https://openexchangerates.org/api/latest.json?symbols=" + symbols;
        try {
            HttpResponse<String> jsonResquest = Unirest.get(url)
                    .header("Authorization", CurrencyExchange.TOKEN)
                    .asString();
            System.out.println("Api Usada");
            return jsonResquest.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public DataAPI getDataObject() {
        try {
            return new ObjectMapper().readValue(apiPersistenceLog.readLog(CurrencyExchange.FILE_NAME_LOG), DataAPI.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
    public void updateRates(){
        long timeNow = System.currentTimeMillis();
        if (dataAPI == null || (dataAPI.timestamp()*1000L)+TIME_TO_UPDATE<timeNow) {
            apiPersistenceLog.writeLog(FILE_NAME_LOG, getJsonAPI());
        }
    }

    public Map<String, Double> getMapRates() {
        return getDataObject().rates();
    }

}
