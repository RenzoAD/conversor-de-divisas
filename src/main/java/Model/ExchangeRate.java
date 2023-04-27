package Model;

import java.util.Arrays;

public enum ExchangeRate {

    De_Sol_a_Dolar("PEN", "USD", "S/.", "$"),
    De_Sol_a_Euro("PEN","EUR", "S/.", "€"),
    De_Sol_a_Libras("PEN","GBP", "S/.", "£"),
    De_Sol_a_Yen("PEN","JPY", "S/.", "¥"),
    De_Sol_a_Won_Coreano("PEN","KRW", "S/.", "₩"),
    De_Sol_a_PesoMX("PEN","MXN", "S/.", "$"),
    De_Dolar_a_Sol("USD", "PEN", "$", "S/."),
    De_PesoMX_a_Sol("MXN","PEN", "$", "S/."),
    De_Won_Coreano_a_Sol("KRW","PEN", "₩", "S/."),
    De_Yen_a_Sol("JPY","PEN", "¥", "S/."),
    De_Libras_a_Sol("GBP","PEN", "£", "S/."),
    De_Euro_a_Sol("EUR","PEN", "€", "S/.");

    private final String symbolFrom;
    private final String symbolTo;
    private final String codeFrom;
    private final String codeTo;

    ExchangeRate(String symbolFrom, String symbolTo, String codeFrom, String codeTo) {
        this.symbolFrom = symbolFrom;
        this.symbolTo = symbolTo;
        this.codeFrom = codeFrom;
        this.codeTo = codeTo;
    }

    public static Object[] getNames() {
            return Arrays.stream(ExchangeRate.values())
                    .map(x -> x.toString().replace("_"," "))
                    .toArray();
    }
    public String getSymbolFrom() {
        return symbolFrom;
    }
    public String getSymbolTo() {
        return symbolTo;
    }
    public String getCodeFrom() {
        return codeFrom;
    }
    public String getCodeTo() {
        return codeTo;
    }
}
