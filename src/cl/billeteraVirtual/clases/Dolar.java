package cl.billeteraVirtual.clases;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Dolar implements Conversor {

    double valorDolar = 969.12;


    @Override
    public void convertirSaldo(double saldo) {

        Scanner scanner = new Scanner(System.in);
        double dolar = (double) saldo / valorDolar;

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
