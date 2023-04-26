package ApiServices.ApiCurrencyExchange;

import java.util.HashMap;

public record DataAPI(
        String disclaimer,
        String license,
        Long timestamp,
        String base,
        HashMap<String, Double> rates
) {
}
