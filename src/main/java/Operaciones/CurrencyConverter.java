package Operaciones;

import Datos.ExchangeRateAccess;

import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {

    public static double convert(Double amount, String operation) {
        return amount * (double) getOperationAttributes(operation).get(ExchangeRateAccess.EXCHANGE_VALUE);
    }

    public static List getOperationAttributes(String operation){
        return ExchangeRateAccess.getOperationValues().get(operation);
    }

}
