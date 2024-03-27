package cl.billeteraVirtual.clases;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Dolar implements Conversor {

    double valorDolar = 969.12;


    /**
     * Método que realiza una conversión de pesos a dólares
     * y muestra el saldo en dólares. Unicamente para poder
     * visualizar lo que se tiene en de saldo en dólares.
     *
     * @param saldo saldo en pesos a realizar conversión a dólares
     */
    @Override
    public void convertirSaldo(double saldo) {

        Scanner scanner = new Scanner(System.in);
        double dolar = saldo / valorDolar;

        DecimalFormat formatoSaldo = new DecimalFormat("#,##0.00");
        String saldoFormateado = formatoSaldo.format(dolar);

        if (saldoFormateado.length() > 28) {
            saldoFormateado = saldoFormateado.substring(0, 28);
        }

        int longitudSaldo = saldoFormateado.length();

        int espacios = 28 - longitudSaldo;

        // Imprimir saldo
        System.out.println("=================================");
        System.out.println("|         SALDO EN DÓLAR        |");
        System.out.println("=================================");
        System.out.printf("| %-" + espacios + "s %s |%n", "", saldoFormateado);
        System.out.println("=================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }
}
