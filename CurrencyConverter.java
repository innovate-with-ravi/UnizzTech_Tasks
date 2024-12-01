import java.util.Scanner;

public class CurrencyConverter {
    static Scanner sc = new Scanner(System.in); // Global Scanner

    static String convertingFrom, convertingTo; // Variables
    static float initialCurrency, convertedCurrency, currencyFactor; // Variables

    static void ConverterWelcome() {
        System.out.println("!!Welcome to Currency Converter!!");// welcome!
    }

    static void CurrencyOptions() {
        System.out.println("Write: " + "\"INR\" for Indian Rupees, " + "\"USD\" for US Dollar, " + "\"EUR\" for Euro and " + "\"AUD\" for Australian Dollar\n");//Options for Currencies!
    }

    static String getConvertingFrom() {
        System.out.format("Converting From: ");// Converting form which currency?
        return sc.nextLine();
    }

    static String getConvertingTo() {
        System.out.format("Converting To: ");// Converting to which currency?
        return sc.nextLine();
    }

    static float getInitialCurrency() {
        System.out.format("Enter the Amount to be converted: ");
        return sc.nextFloat();
    }

    static void ConvertingFrom_To_Conditions() { // this method checks the conditions of conversion!

        if (convertingFrom.equalsIgnoreCase("INR")) {

            if (convertingTo.equalsIgnoreCase("USD")) {
                currencyFactor = 0.012f;
            } else if (convertingTo.equalsIgnoreCase("EUR")) {
                currencyFactor = 0.011f;
            } else if (convertingTo.equalsIgnoreCase("AUD")) {
                currencyFactor = 0.018f;
            } else {
                System.out.println("Please choose a valid currency!");
                CurrencyOptions();
                convertingTo = getConvertingTo();
                ConvertingFrom_To_Conditions();
            }
        } else if (convertingFrom.equalsIgnoreCase("USD")) {

            if (convertingTo.equalsIgnoreCase("INR")) {
                currencyFactor = 84.56F;
            } else if (convertingTo.equalsIgnoreCase("EUR")) {
                currencyFactor = 0.95F;
            } else if (convertingTo.equalsIgnoreCase("AUD")) {
                currencyFactor = 1.54F;
            } else {
                System.out.println("Please choose a valid currency!");
                CurrencyOptions();
                convertingTo = getConvertingTo();
                ConvertingFrom_To_Conditions();
            }
        } else if (convertingFrom.equalsIgnoreCase("EUR")) {

            if (convertingTo.equalsIgnoreCase("INR")) {
                currencyFactor = 89.48F;
            } else if (convertingTo.equalsIgnoreCase("USD")) {
                currencyFactor = 1.06F;
            } else if (convertingTo.equalsIgnoreCase("AUD")) {
                currencyFactor = 1.63F;
            } else {
                System.out.println("Please choose a valid currency!");
                CurrencyOptions();
                convertingTo = getConvertingTo();
                ConvertingFrom_To_Conditions();
            }
        } else if (convertingFrom.equalsIgnoreCase("AUD")) {

            if (convertingTo.equalsIgnoreCase("INR")) {
                currencyFactor = 55.10F;
            } else if (convertingTo.equalsIgnoreCase("EUR")) {
                currencyFactor = 0.62F;
            } else if (convertingTo.equalsIgnoreCase("USD")) {
                currencyFactor = 0.65F;
            } else {
                System.out.println("Please choose a valid currency!");
                CurrencyOptions();
                convertingTo = getConvertingTo();
                ConvertingFrom_To_Conditions();
            }
        } else {
            System.out.println("Please choose a valid currency!");
            CurrencyOptions();
            convertingFrom = getConvertingFrom();
            convertingTo = getConvertingTo();
            ConvertingFrom_To_Conditions();
        }
    }

    static void CurrencyConverterFunction() {
        // this method is the CurrencyConverterFunction which runs till the user chooses 'Y'!
        boolean convertAnotherCurrency = true;
        char y_n;

        ConverterWelcome();
        while (convertAnotherCurrency) {
            CurrencyOptions();

            convertingFrom = getConvertingFrom();
            convertingTo = getConvertingTo();

            ConvertingFrom_To_Conditions();

            initialCurrency = getInitialCurrency();

            convertedCurrency = initialCurrency * currencyFactor;
            System.out.format("%s \"%.3f\" in %s is: \"%.3f\"\n", convertingFrom, initialCurrency, convertingTo, convertedCurrency);
            System.out.println();

            System.out.println("Do you want to convert more currencies?");
            System.out.format("Write 'Y' for yes and 'N' for no: ");
            y_n = sc.next().charAt(0);
            sc.nextLine(); // Clear the newline character from the buffer
            System.out.println();

            if ((y_n != 'Y') && (y_n != 'y')) {
                convertAnotherCurrency = false;
            }

        }
    }

    public static void main(String[] args) {
        CurrencyConverterFunction(); // calling the method!
    }
}
