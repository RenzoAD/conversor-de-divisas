package Vista;

import Model.ExchangeRate;
import Operaciones.CurrencyConverter;

import javax.swing.*;

public class VentanaCurrency {

    public static Boolean init() {
        String operation = getExchangeRate();
        Double amount = getAmount();
        Double convert = CurrencyConverter.convert(amount, operation);
        String currencyTo = ExchangeRate.getCurrencyTo(operation);
        sendMessage(convert,currencyTo);
        return confirmExit();
    }

    public static Boolean confirmExit(){
        int option = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Seleccione una opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option != 0) {
            JOptionPane.showMessageDialog(null, "Programa Finalizado ", "Message", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        return true;
    }

    public static void sendMessage(Double convertCurrency, String codeCurrency) {
        JOptionPane.showMessageDialog(null,
                "Tienes " + convertCurrency + codeCurrency,
                "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String getExchangeRate(){
       return JOptionPane.showInputDialog(null, "Elije la moneda a la que deseas convertir tu dinero", "Monedas",
                JOptionPane.PLAIN_MESSAGE,
                null, ExchangeRate.getNames(), ExchangeRate.getNames()[0]).toString();
    }

    public static Double getAmount(){
        Double amount=0d;
        boolean validacion = true;
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
       return amount;
    }

}
