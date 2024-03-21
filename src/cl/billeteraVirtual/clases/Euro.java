package cl.billeteraVirtual.clases;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Euro implements Conversor {

    double valorEuro = 1052.42;

    @Override
    public void convertirSaldo(int saldo) {

        Scanner scanner = new Scanner(System.in);
        double euro = (double) saldo / valorEuro;

        DecimalFormat formatoSaldo = new DecimalFormat("#,##0.00");
        String saldoFormateado = formatoSaldo.format(euro);

        if (saldoFormateado.length() > 28) {
            saldoFormateado = saldoFormateado.substring(0, 28);
        }

        int longitudSaldo = saldoFormateado.length();

        int espacios = 28 - longitudSaldo;

        // Imprimir saldo
        System.out.println("=================================");
        System.out.println("|         SALDO EN EUROS        |");
        System.out.println("=================================");
        System.out.printf("| %-" + espacios + "s %s |%n", "", saldoFormateado);
        System.out.println("=================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }
}
