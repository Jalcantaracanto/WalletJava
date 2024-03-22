package cl.billeteraVirtual.clases;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
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

    public static void menuSeleccionarDivisa() {
        System.out.println("=================================");
        System.out.println("|       CONVERSOR DIVISA        |");
        System.out.println("=================================");
        System.out.println("|   Opciones:                   |");
        System.out.println("|          1. Dólar             |");
        System.out.println("|          2. Euro              |");
        System.out.println("=================================");
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("|   CONTRASEÑAS NO COINCIDEN,   |");
        System.out.println("|       INTENTE NUEVAMENTE      |");
        System.out.println("=================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    public static void mensajeResponderSN() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("|     DEBE RESPONDER (S/N)     |");
        System.out.println("================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("|    SOLO SE PERMITE INGRESO    |");
        System.out.println("|          DE NÚMEROS           |");
        System.out.println("================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();

    }


    public static void mensajeConexionExitosa() {
        System.out.println("=================================");
        System.out.println("|       CONEXIÓN ÉXITOSA        |");
        System.out.println("=================================");
    }

    public static void mensajeIngresoRetiroSaldo(double saldo, boolean ingreso) {
        Scanner scanner = new Scanner(System.in);
        String moneda = "Pesos";

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        decimalFormat.applyPattern("#,###.##");
        String saldoFormateado = "$" + decimalFormat.format(saldo);

        if (saldoFormateado.length() > 27) {
            saldoFormateado = saldoFormateado.substring(0, 27);
        }

        int longitudMoneda = moneda.length();
        int longitudSaldo = saldoFormateado.length();

        int espaciosEntreMonedaYSaldo = 27 - longitudMoneda - longitudSaldo;

        // Imprimir saldo
        System.out.println("=================================");
        System.out.println(ingreso ? "|   SALDO INGRESADO CON ÉXITO   |" : "|    RETIRO DE SALDO EXITOSO    |");
        System.out.println("|          SALDO ACTUAL         |");
        System.out.println("=================================");
        System.out.printf("| %s %-" + espaciosEntreMonedaYSaldo + "s %s |%n", moneda, "", saldoFormateado);
        System.out.println("=================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    public static boolean mensajeConexionFallida() {
        Scanner scanner = new Scanner(System.in);
        String salir;
        System.out.println("=================================");
        System.out.println("|     USUARIO Y/O CONTRASEÑA    |");
        System.out.println("|           INVALIDAS           |");
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

    public static void mensajeNoExistenUsuarios() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("|      NO EXISTEN USUARIOS      |");
        System.out.println("|          EN EL BANCO          |");
        System.out.println("=================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    public static void mensajeSaldoInsuficiente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("|      SALDO INSUFICIENTE       |");
        System.out.println("|          PARA RETIRO          |");
        System.out.println("=================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

}
