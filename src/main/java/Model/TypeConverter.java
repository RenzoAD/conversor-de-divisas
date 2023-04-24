package Model;

import java.util.Arrays;

public enum TypeConverter {
    Conversor_de_Moneda,
    Conversor_de_Temperatura;

    public static Object[] getNames(){
    return Arrays.stream(TypeConverter.values())
            .map(x-> x.toString().replace("_"," "))
            .toArray();
    }
}
