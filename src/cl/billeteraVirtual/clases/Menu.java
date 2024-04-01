package cl.billeteraVirtual.clases;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    //Menus

    /**
     * Muestra el menú de inicio
     */
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

    /**
     * Muestra el menú que pregunta el usuario si quiere ingresar saldo
     * después de haberse registrado.
     */
    public static void menuIngresarSaldoRegistro() {
        System.out.println("=================================");
        System.out.println("|       REGISTRO COMPLETADO     |");
        System.out.println("|     ¿DESEA INGRESAR SALDO?    |");
        System.out.println("|            ( S / N )          |");
        System.out.println("=================================");

    }

    /**
     * Menú que avisa al usuario ingresar los datos proporcionados
     * por consola.
     */
    public static void menuRegistrar() {
        System.out.println("=================================");
        System.out.println("|           REGISTRO            |");
        System.out.println("=================================");
        System.out.println("|     PROPORCIONE LOS DATOS     |");
        System.out.println("|          SOLICITADOS          |");
        System.out.println("=================================");
    }

    /**
     * Menú que muestra las opciones del usuario al ingresar al sistema.
     */
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

    /**
     * Menú que muestra las opciones de cambio de divisa.
     */
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

    /**
     * Mensaje que se muestra cuando el usuario ingresa un rut inválido.
     */
    public static void mensajeRutInvalido() {
        System.out.println("=================================");
        System.out.println("|      INGRESE RUT VALIDO       |");
        System.out.println("=================================");
    }


    /**
     * Mensaje que se muestra cuando una cuenta es creada con éxito.
     */
    public static void mensajeCreacionExitosa(Scanner scanner) {
        System.out.println("=================================");
        System.out.println("|    CUENTA CREADA CON ÉXITO    |");
        System.out.println("=================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    /**
     * Mensaje que se muestra cuando el correo ingresado es inválido.
     */
    public static void mensajeCorreoInvalido() {
        System.out.println("=================================");
        System.out.println("|    INGRESE CORREO VALIDO      |");
        System.out.println("=================================");

    }

    /**
     * Mensaje que se muestra cuando estás registrando un usuario
     * y las contraseñas que ingresaste no coinciden.
     */
    public static void mensajeContrasenaDistinta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("|   CONTRASEÑAS NO COINCIDEN,   |");
        System.out.println("|       INTENTE NUEVAMENTE      |");
        System.out.println("=================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    /**
     * Mensaje de error cuando el usuario debe responder con "S" o "N" y respondió
     * con otra cosa.
     */
    public static void mensajeResponderSN() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("|     DEBE RESPONDER (S/N)     |");
        System.out.println("================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }


    /**
     * Mensaje que se muestra cuando el usuario ingresa una opción inválida.
     */
    public static void mensajeOpcionInvalida() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("|        OPCION INVALIDA       |");
        System.out.println("|      INTENTE NUEVAMENTE      |");
        System.out.println("================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    /**
     * Mensaje que se muestra cuando se cierra el sistema.
     */
    public static void mensajeDespedida() {
        System.out.println("================================");
        System.out.println("|   SISTEMA BANCARIO CERRADO   |");
        System.out.println("|         HASTA LUEGO          |");
        System.out.println("================================");
    }


    /**
     *
     */
    public static void mensajeSaldoInvalido() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("|    SOLO SE PERMITE INGRESO    |");
        System.out.println("|          DE NÚMEROS           |");
        System.out.println("================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();

    }

    /**
     * Mensaje que se muestra cuando el usuario ingresa un nombre válido.
     */
    public static void mensajeConexionExitosa() {
        System.out.println("=================================");
        System.out.println("|       CONEXIÓN ÉXITOSA        |");
        System.out.println("=================================");
    }

    /**
     * Mensaje que se muestra cuando el usuario realiza un retiro o
     * un ingreso de saldo.
     */
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

    /**
     * Mensaje de error cuando un usuario intenta conectarse al sistema
     * y las credenciales son incorrectas.
     */
    public static boolean mensajeConexionFallida(Scanner scanner) {
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

    /**
     * Mensaje que se muestra cuando un usuario intenta ingresar al sistema
     * y no existen usuarios registrados.
     */
    public static void mensajeNoExistenUsuarios() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("|      NO EXISTEN USUARIOS      |");
        System.out.println("|          EN EL BANCO          |");
        System.out.println("=================================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    /**
     * Mensaje que se muestra cuando un usuario intenta retirar saldo y no hay saldo suficiente para su retiro
     */
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
