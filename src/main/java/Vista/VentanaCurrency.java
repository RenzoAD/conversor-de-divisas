package Vista;

import Controller.CurrencyConverterController;
import Model.ExchangeRate;

import javax.swing.*;

public class VentanaCurrency {

    private final CurrencyConverterController currencyConverterController;
    public VentanaCurrency(){
        currencyConverterController = new CurrencyConverterController();
    }
    public Boolean init() {

        Double amount = getAmount();
        String operation = getExchangeRate();

        Double converted = currencyConverterController.convert(amount, operation);
        String currencyTo = currencyConverterController.getCodeTo(operation);

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
                String.format("Tienes %s %.2f",codeCurrency,convertCurrency),
                "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getExchangeRate(){
       return JOptionPane.showInputDialog(null, "Elije la moneda a la que deseas convertir tu dinero", "Monedas",
                JOptionPane.PLAIN_MESSAGE,
                null, ExchangeRate.getNames(), ExchangeRate.getNames()[0]).toString();
    }

    public double getAmount(){
        var amount=0d;
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
