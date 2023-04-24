package Vista;

import Model.TypeConverter;

import javax.swing.*;

public class VentanaPrincipal {

    boolean run = true;

    public VentanaPrincipal() {

        while (run) {
            switch (getOperation()) {
                case "Conversor de Moneda" -> run = new VentanaCurrency().init();
                case "Conversor de Temperatura" -> {System.out.println("Funcion no implementada"); run=false;}
            }
        }
    }

    public String getOperation() {
        return JOptionPane.showInputDialog(
                null,
                "Seleccione una opcion de conversión",
                "Menú",
                JOptionPane.PLAIN_MESSAGE,
                null,
                TypeConverter.getNames(), TypeConverter.getNames()[0]).toString();
    }

}
