package Model;

import java.util.Arrays;

public enum Converter {
    Conversor_de_Moneda,
    Conversor_de_Temperatura;

    public static Object[] getNames(){
    return Arrays.stream(Converter.values())
            .map(x-> x.toString().replace("_"," "))
            .toArray();
    }
}
