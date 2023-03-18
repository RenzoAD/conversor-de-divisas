package Vista;

import Datos.ExchangeRateAccess;
import Operaciones.CurrencyConverter;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        String[] conversor = {"Conversor de Moneda", "Conversor de Temperatura"};

        boolean run = true;
        while (run) {
            String optionConverter = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion de conversión", "Menú",
                    JOptionPane.PLAIN_MESSAGE,
                    null, conversor, conversor[0]);

            //Refactorizado 17.03.23
            String operation = JOptionPane.showInputDialog(null, "Elije la moneda a la que deseas convertir tu dinero", "Monedas",
                    JOptionPane.PLAIN_MESSAGE,
                    null, ExchangeRateAccess.getOperationNames(), ExchangeRateAccess.getOperationNames()[0]).toString();

            boolean validacion = true;
            Double amount = 0.0;
            while (validacion) {
                try {
                    amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa la cantidad de dinero que deseas convertir", "Input",
                            JOptionPane.QUESTION_MESSAGE));
                    validacion = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor no valido", "Message", JOptionPane.INFORMATION_MESSAGE);
                    e.printStackTrace();
                }
            }
            //Refactorizado 17.03.23
            double rs = CurrencyConverter.convert(amount, operation);
            JOptionPane.showMessageDialog(null,
                    "Tienes " + rs+ CurrencyConverter.getOperationAttributes(operation).get(ExchangeRateAccess.CURRENCY_CODE_TO),
                    "Message", JOptionPane.INFORMATION_MESSAGE);

            int optionContinuar = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Seleccione una opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (optionContinuar!=0){
                run = false;
                JOptionPane.showMessageDialog(null, "Programa Finalizado ", "Message", JOptionPane.PLAIN_MESSAGE);
            }
        }

    }

}
