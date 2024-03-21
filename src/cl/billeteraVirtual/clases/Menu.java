package cl.billeteraVirtual.clases;

import java.util.Scanner;

public class Menu {
    //Menus

    public static void menuInicio() {
        System.out.println("=================================");
        System.out.println("|   BIENVENIDO A WALLET BANK    |");
        System.out.println("=================================");
        System.out.println("|   Opciones:                   |");
        System.out.println("|          1. Conectar          |");
        System.out.println("|          2. Registrar         |");
        System.out.println("|          3. Salir             |");
        System.out.println("=================================");
    }

    public static void menuSeleccioneDivisa() {
        System.out.println("=================================");
        System.out.println("|       SELECCIONE DIVISA       |");
        System.out.println("=================================");
        System.out.println("|   Opciones:                   |");
        System.out.println("|          1. Peso Chileno      |");
        System.out.println("|          2. Dólar             |");
        System.out.println("|          3. Euro              |");
        System.out.println("|          4. Yen               |");
        System.out.println("=================================");
    }

    public static void menuIngresarSaldoRegistro() {
        System.out.println("=================================");
        System.out.println("|       REGISTRO COMPLETADO     |");
        System.out.println("|     ¿DESEA INGRESAR SALDO?    |");
        System.out.println("|            ( S / N )          |");
        System.out.println("=================================");

    }

    public static void menuRegistrar() {
        System.out.println("=================================");
        System.out.println("|           REGISTRO            |");
        System.out.println("=================================");
        System.out.println("|     PROPORCIONE LOS DATOS     |");
        System.out.println("|          SOLICITADOS          |");
        System.out.println("=================================");
    }

    public static void menuConsultasUsuario() {
        System.out.println("=================================");
        System.out.println("|      CONSULTAS AL BANCO       |");
        System.out.println("=================================");
        System.out.println("|   Opciones:                   |");
        System.out.println("|          1. Ingresar Saldo    |");
        System.out.println("|          2. Retirar Saldo     |");
        System.out.println("|          3. Cambio Divisa     |");
        System.out.println("|          4. Ver Saldo         |");
        System.out.println("|          5. Salir             |");
        System.out.println("=================================");

    }

    public static boolean menuOtraOperacion() {
        Scanner scanner = new Scanner(System.in);
        String salir;
        System.out.println("=================================");
        System.out.println("|¿DESEA REALIZAR OTRA OPERACIÓN?|");
        System.out.println("|             (S/N)             |");
        System.out.println("=================================");
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

    public static void mensajeRutInvalido() {
        System.out.println("=================================");
        System.out.println("|      INGRESE RUT VÁLIDO       |");
        System.out.println("=================================");
    }

    public static void mensajeCreacionExitosa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("|    CUENTA CREADA CON ÉXITO    |");
        System.out.println("=================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }


    public static void mensajeCorreoInvalido() {
        System.out.println("=================================");
        System.out.println("|    INGRESE CORREO VÁLIDO      |");
        System.out.println("=================================");

    }

    public static void mensajeContrasenaDistinta() {
        System.out.println("=================================");
        System.out.println("|   CONTRASEÑAS NO COINCIDEN,   |");
        System.out.println("|       INTENTE NUEVAMENTE      |");
        System.out.println("=================================");
    }

    public static void mensajeResponderSN() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("|     DEBE RESPONDER (S/N)     |");
        System.out.println("================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    public static void mensajeIngresoRegistroSaldoInvalido() {
        System.out.println("================================");
        System.out.println("| SOLO PUEDE INGRESAR NÚMEROS  |");
        System.out.println("|            1 AL 4            |");
        System.out.println("================================");
    }

    public static void mensajeOpcionInvalida() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("|        OPCIÓN INVÁLIDA       |");
        System.out.println("|      INTENTE NUEVAMENTE      |");
        System.out.println("================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    public static void mensajeDespedida() {
        System.out.println("================================");
        System.out.println("|    QUE TENGA UN BUEN DÍA,    |");
        System.out.println("|         HASTA LUEGO          |");
        System.out.println("================================");
    }

    public static void mensajeSaldoInvalido() {
        System.out.println("================================");
        System.out.println("|    SOLO SE PERMITE INGRESO    |");
        System.out.println("|          DE NÚMEROS           |");
        System.out.println("================================");
    }


    public static void mensajeConexionExitosa() {
        System.out.println("=================================");
        System.out.println("|       CONEXIÓN ÉXITOSA        |");
        System.out.println("=================================");
    }

    public static void mensajeIngresoRegistroSaldoExitoso(int saldo) {
        String moneda = "Pesos";
        String formatoSaldo = "$%d";


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

    public static boolean mensajeConexionFallida() {
        Scanner scanner = new Scanner(System.in);
        String salir;
        System.out.println("=================================");
        System.out.println("|     USUARIO Y/O CONTRASEÑA    |");
        System.out.println("|          NO ENCONTRADO        |");
        System.out.println("|  ¿DESEA INTENTAR NUEVAMENTE?  |");
        System.out.println("|             (S/N)             |");
        System.out.println("=================================");
        System.out.print("Respuesta: ");
        salir = scanner.nextLine();
        if (salir.equalsIgnoreCase("s")) {
            System.out.println("");
            return true;
        } else {
            return false;
        }
    }
}
