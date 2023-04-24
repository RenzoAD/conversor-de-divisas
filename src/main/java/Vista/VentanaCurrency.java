package Vista;

import Controller.CurrencyConverter;
import Model.ExchangeRate;

import javax.swing.*;

public class VentanaCurrency {

    private CurrencyConverter currencyConverter;
    public VentanaCurrency(){
        currencyConverter = new CurrencyConverter();
    }
    public Boolean init() {
        String operation = getExchangeRate();
        Double amount = getAmount();

        Double converted = currencyConverter.convert(amount, operation);
        String currencyTo = currencyConverter.getCurrencyTo(operation);

        sendMessage(converted,currencyTo);
        return confirmExit();
    }

    public Boolean confirmExit(){
        int option = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Seleccione una opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option != 0) {
            JOptionPane.showMessageDialog(null, "Programa Finalizado ", "Message", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        return true;
    }

    public void sendMessage(Double convertCurrency, String codeCurrency) {
        JOptionPane.showMessageDialog(null,
                String.format("Tienes %.2f %s",convertCurrency,codeCurrency),
                "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getExchangeRate(){
       return JOptionPane.showInputDialog(null, "Elije la moneda a la que deseas convertir tu dinero", "Monedas",
                JOptionPane.PLAIN_MESSAGE,
                null, ExchangeRate.getNames(), ExchangeRate.getNames()[0]).toString();
    }

    public Double getAmount(){
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
