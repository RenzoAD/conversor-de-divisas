package Vista;

import Model.Converter;

import javax.swing.*;

public class VentanaApp {

    boolean run = true;

    public VentanaApp() {

        while (run) {
            switch (getOperation()) {
                case "Conversor de Moneda" -> run = VentanaCurrency.init();
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
                Converter.getNames(), Converter.getNames()[0]).toString();
    }

}
