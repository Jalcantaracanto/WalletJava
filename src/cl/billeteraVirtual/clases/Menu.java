package cl.billeteraVirtual.clases;

import java.util.Scanner;

public class Menu {
    //Menus

    public void menuInicio() {
        System.out.println("============================");
        System.out.println("|   BIENVENIDO A WALLET    |");
        System.out.println("============================");
        System.out.println("| Opciones:                |");
        System.out.println("|        1. Conectar       |");
        System.out.println("|        2. Registrar      |");
        System.out.println("|        3. Salir          |");
        System.out.println("============================");
    }

    public void menuSeleccioneDivisa() {
        System.out.println("============================");
        System.out.println("|   SELECCIONE DIVISA      |");
        System.out.println("============================");
        System.out.println("| Opciones:                |");
        System.out.println("|        1. Peso Chileno   |");
        System.out.println("|        2. Dólar          |");
        System.out.println("|        3. Euro           |");
        System.out.println("|        4. Yen            |");
        System.out.println("============================");
    }

    public void menuIngresarSaldoRegistro() {
        System.out.println("============================");
        System.out.println("|    Registro Completado   |");
        System.out.println("|  ¿Desea ingresar saldo?  |");
        System.out.println("|        ( s / n )         |");
        System.out.println("============================");
    }

    public void menuRegistrar() {
        System.out.println("============================");
        System.out.println("|         REGISTRO         |");
        System.out.println("============================");
        System.out.println("|                          |");
        System.out.println("|  Proporcione los datos   |");
        System.out.println("|      solicitados en      |");
        System.out.println("|         consola          |");
        System.out.println("|                          |");
        System.out.println("============================");
    }

    public void menuConsultasUsuario() {
        System.out.println("============================");
        System.out.println("|   CONSULTAS AL BANCO     |");
        System.out.println("============================");
        System.out.println("| Opciones:                |");
        System.out.println("|        1. Ingresar Saldo |");
        System.out.println("|        2. Retirar Saldo  |");
        System.out.println("|        3. Cambio Divisa  |");
        System.out.println("|        4. Ver Saldo      |");
        System.out.println("|        5. Salir          |");
        System.out.println("============================");
    }

    public boolean menuOtraOperacion() {
        Scanner scanner = new Scanner(System.in);
        String salir;
        System.out.println("=========================================");
        System.out.println("| ¿Desea realizar otra operación? (s/n) |");
        System.out.println("=========================================");
        System.out.print("Respuesta: ");
        salir = scanner.nextLine();
        if (salir.equalsIgnoreCase("s")) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            return true;
        } else {
            return false;
        }
    }

    //Mensajes

    public void mensajeRutInvalido() {
        System.out.println("============================");
        System.out.println("|    Ingrese Rut Válido    |");
        System.out.println("============================");
    }

    public void mensajeCreacionExitosa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("============================");
        System.out.println("|  CUENTA CREADA CON ÉXITO |");
        System.out.println("============================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }


    public void mensajeCorreoInvalido() {
        System.out.println("============================");
        System.out.println("|   Ingrese Correo Válido  |");
        System.out.println("============================");
    }

    public void mensajeContraseñaInvalida() {
        System.out.println("=========================================");
        System.out.println("|       Contraseñas no coinciden,       |");
        System.out.println("|           intente nuevamente          |");
        System.out.println("=========================================");
    }

    public void mensajeResponderSN() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("|       Solo puede responder   |");
        System.out.println("|           'S' o 'N'          |");
        System.out.println("================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    public void mensajeIngresoRegistroSaldoInvalido() {
        System.out.println("=========================================");
        System.out.println("|       solo puede ingresar números     |");
        System.out.println("|               del 1 al 4              |");
        System.out.println("=========================================");
    }

    public void mensajeOpcionInvalida() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("|  Opción invalida, intente nuevamente  |");
        System.out.println("=========================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    public void mensajeDespedida() {
        System.out.println("=========================================");
        System.out.println("|   Que tenga un buen día, Hasta Luego  |");
        System.out.println("=========================================");
    }

    public void mensajeSaldoInvalido() {
        System.out.println("=========================================");
        System.out.println("|   Solo se permite ingreso de números  |");
        System.out.println("=========================================");
    }

    public static void mensajeIngresoRegistroSaldoExitoso(int tipoSaldo, double saldo) {
        String formatoSaldo = "";
        String moneda = "";

        switch (tipoSaldo) {
            case 1:
                formatoSaldo = "$%,.0f";
                moneda = "Peso:";
                break;
            case 2:
                formatoSaldo = "$%,.2f";
                moneda = "Dólar:";
                break;
            case 3:
                formatoSaldo = "€%,.2f";
                moneda = "Euro:";
                break;
            case 4:
                formatoSaldo = "¥%,.0f";
                moneda = "Yen:";
                break;
            default:
                System.out.println("Tipo de saldo no válido.");
                return;
        }

        String saldoFormateado = String.format(formatoSaldo, saldo);

        if (saldoFormateado.length() > 27) {
            saldoFormateado = saldoFormateado.substring(0, 27);
        }

        int longitudMoneda = moneda.length();
        int longitudSaldo = saldoFormateado.length();

        int espaciosEntreMonedaYSaldo = 27 - longitudMoneda - longitudSaldo;

        // Imprimir saldo
        System.out.println("=================================");
        System.out.println("|   Saldo ingresado con éxito   |");
        System.out.println("=================================");
        System.out.printf("| %s %-" + espaciosEntreMonedaYSaldo + "s %s |%n", moneda, "", saldoFormateado);
        System.out.println("=================================");
    }
}
