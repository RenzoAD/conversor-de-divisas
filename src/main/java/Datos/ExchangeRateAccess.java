package Datos;
import java.util.*;
public class ExchangeRateAccess {

    public static final int CURRENCY_CODE_CONVERT=0;
    public static final int CURRENCY_CODE_FROM=1;
    public static final int CURRENCY_CODE_TO=2;
    public static final int EXCHANGE_VALUE =3;

    public static String[] getOperationNames() {
        String[] enumArray = new String[ExchangeRate.values().length];
        int index = 0;
        for (ExchangeRate tdc : ExchangeRate.values()) {
            enumArray[index] = tdc.name().replaceAll("_", " ");
            index++;
        }
        return enumArray;
    }

    public static Map<String, List> getOperationValues() {
        Map<String, List> mapTipoDeCambio = new HashMap<>();

        for (ExchangeRate tdc : ExchangeRate.values()) {

            List listTipoDeCambioValues = new ArrayList();
            listTipoDeCambioValues.add(tdc.getCurrencyCodeConvert());
            listTipoDeCambioValues.add(tdc.getCurrencyCodeFrom());
            listTipoDeCambioValues.add(tdc.getCurrencyCodeTo());
            listTipoDeCambioValues.add(tdc.getExchangeValue());
            mapTipoDeCambio.put(tdc.name().replaceAll("_", " "), listTipoDeCambioValues);
        }
        return mapTipoDeCambio;
    }
}
