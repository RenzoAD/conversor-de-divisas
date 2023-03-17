package Vista;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {
        String[] conversor = {"Conversor de Moneda", "Conversor de Temperatura"};
        String[] servicio = {"De Sol a Dolar",
                "De Sol a Euro",
                "De Sol a Libras",
                "De Sol a Yen",
                "De Sol a Won Coreano",
                "De Sol a Peso",
                "De Dolar a Sol",
                "De Dolar a Peso",
                "De Dolar a Won Coreano",
                "De Dolar a Yen",
                "De Dolar a Libras",
                "De Dolar a Euro"};
        boolean run = true;
        while (run) {
            String optionConversor = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion de conversión", "Menú",
                    JOptionPane.PLAIN_MESSAGE,
                    null, conversor, conversor[0]);
            String optionServicio = (String) JOptionPane.showInputDialog(null, "Elije la moneda a la que deseas convertir tu dinero", "Monedas",
                    JOptionPane.PLAIN_MESSAGE,
                    null, servicio, servicio[0]);

            boolean validacion = true;
            Double monto = 0.0;
            while (validacion) {
                try {
                    monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa la cantidad de dinero que deseas convertir", "Input",
                            JOptionPane.QUESTION_MESSAGE));
                    validacion = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor no valido", "Message", JOptionPane.INFORMATION_MESSAGE);
                    e.printStackTrace();
                }
            }

            double rs = monto * 1; //implementar metodo conversion

            JOptionPane.showMessageDialog(null, "Tienes " + rs, "Message", JOptionPane.INFORMATION_MESSAGE);
            int optionContinuar = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Seleccione una opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (optionContinuar!=0){
                run = false;
                JOptionPane.showMessageDialog(null, "Programa Finalizado ", "Message", JOptionPane.PLAIN_MESSAGE);
            }
            System.out.println(optionContinuar);
            System.out.println(optionConversor);
            System.out.println(optionServicio);
            System.out.println(monto);
        }


    }

}
