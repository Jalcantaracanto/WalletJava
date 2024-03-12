import cl.billeteraVirtual.clases.Banco;
import cl.billeteraVirtual.clases.Billetera;
import cl.billeteraVirtual.clases.Menu;
import cl.billeteraVirtual.clases.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        Menu menu = new Menu();
        Usuario usuario = new Usuario("Javier", "Alcántara", "18.298.640-2", "javier.alcantara.canto@gmail.com", "12345");
        Usuario usuario2 = new Usuario("Nicole", "Chavez", "18.298.640-2", "asd", "12345");


//        int opcion;
//        SistemaBanco(menu, scanner, banco);

        banco.agregarUsuario(usuario);
        banco.agregarUsuario(usuario2);

        for (Usuario user : banco.getListaUsuarios()) {
            System.out.println(user);
        }

        String email, pass;
        System.out.print("Ingrese Correo: ");
        email = scanner.nextLine();
        System.out.print("Ingrese Contraseña: ");
        pass = scanner.nextLine();
        boolean encontrado = false;

        for (Usuario user : banco.getListaUsuarios()) {
            if (user.getCorreo().equals(email) && user.getContrasena().equals(pass)) {
                System.out.println("Has podido conectar");
                encontrado = true;
                SistemaUsuario(scanner, menu, user);
            }
        }

        if (!encontrado) {
            System.out.println("No encontrado");
        }
    }

    private static void SistemaBanco(Menu menu, Scanner scanner, Banco banco) {
        int opcion;
        while (true) {
            menu.MenuInicio();
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    //Construcción
                case 2:
                    MenuRegistrar();
                    Usuario user = RegistroUsuario(scanner);
                    banco.agregarUsuario(user);
                    IngresarSaldoRegistro(scanner, user);
                    MenuCreacionExitosa(scanner);
                    System.out.println(user);
                    System.out.println(user.getBilleteras());
                    System.out.println(banco.getListaUsuarios());

                    break;
                default:
                    scanner.close();
                    break;
            }
            if (opcion == 3) {
                MenuDespedida();
                break;
            }
            if (!preguntaOtraOperacion(scanner)) {
                break;
            }
        }
    }

    private static void SistemaUsuario(Scanner scanner, Menu menu, Usuario usuario) {
        int opcion;
        while (true) {
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
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            int tipoDivisa;
            String moneda;

            switch (opcion) {
                case 1:
                    menu.SeleccioneDivisa();
                    while (true) {
                        try {
                            System.out.print("Respuesta: ");

                            if (!scanner.hasNextInt()) {
                                System.out.println("Por favor, ingrese un número entero.");
                                scanner.nextLine();
                                continue;
                            }
                            tipoDivisa = scanner.nextInt();
                            if (tipoDivisa < 1 || tipoDivisa > 5) {
                                System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 4.");
                                continue;
                            }
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    switch (tipoDivisa) {
                        case 1:
                            moneda = "Peso";
                            IngresarSaldo(usuario, moneda, scanner);
                            System.out.println(usuario.getBilleteras());
                            break;
                        case 2:
                            moneda = "Dólar";
                            IngresarSaldo(usuario, moneda, scanner);
                            break;
                        case 3:
                            moneda = "Euro";
                            IngresarSaldo(usuario, moneda, scanner);
                            break;
                        case 4:
                            moneda = "Yen";
                            IngresarSaldo(usuario, moneda, scanner);
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }

                    break;
                case 2:


                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    scanner.close();
                    break;
            }
            if (opcion == 5) {
                MenuDespedida();
                break;
            }
            if (!preguntaOtraOperacion(scanner)) {
                break;
            }
        }
    }

    private static void IngresarSaldo(Usuario usuario, String moneda, Scanner scanner) {

        System.out.printf("|    %s     |\n", moneda);
        System.out.println("============================");
        System.out.println("Saldo a ingresar: ");
        double saldo = scanner.nextDouble();
        boolean billeteraEncontrada = false;
        for (Billetera billetera : usuario.getBilleteras()) {
            if (billetera.getMoneda().equalsIgnoreCase("Peso")) {
                billetera.ingresoSaldo(saldo);
            }
        }
        if (!billeteraEncontrada) {
            Billetera nuevabilletera = new Billetera(usuario.getRut(), moneda, saldo);
            usuario.agregarBilletera(nuevabilletera);
        }
    }

    private static void MenuCreacionExitosa(Scanner scanner) {
        System.out.println("============================");
        System.out.println("|  CUENTA CREADA CON ÉXITO |");
        System.out.println("============================");
        System.out.println("Presione enter para continuar...");
        scanner.nextLine();
    }

    // FUNCIONES / MÉTODOS

    /**
     * Método para ingresar saldo luego del registro, con validadores para los Menu y formateo de Rut.
     *
     * @param scanner Se envía la clase Scanner con el fin de poder obtener respuesta.
     * @param user    Se envía el usuario, de aquí rescatamos el rut para ingresarlo a la billetera con su respectivo saldo.
     * @author Javier Alcántara
     */
    private static void IngresarSaldoRegistro(Scanner scanner, Usuario user) {
        String deseoSaldo = "";
        do {
            try {
                System.out.println("============================");
                System.out.println("|    Registro Completado   |");
                System.out.println("|  ¿Desea ingresar saldo?  |");
                System.out.println("|        ( s / n )         |");
                System.out.println("============================");
                System.out.print("Respuesta: ");

                deseoSaldo = scanner.nextLine();

                if (!deseoSaldo.equalsIgnoreCase("n") && !deseoSaldo.equalsIgnoreCase("s")) {
                    System.out.println("Solo puede responder 'S' o 'N'");
                    System.out.println("Presione enter para continuar...");
                    scanner.nextLine();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (!deseoSaldo.equalsIgnoreCase("n") && !deseoSaldo.equalsIgnoreCase("s"));

        if (deseoSaldo.equalsIgnoreCase("s")) {
            double saldo;
            int tipoSaldo = 0;
            String tipo;

            while (true) {

                do {
                    try {
                        SeleccioneDivisa();
                        System.out.print("Respuesta: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Por favor, ingrese un número entero.");
                            System.out.print("Respuesta: ");
                            scanner.nextLine();
                        }
                        tipoSaldo = scanner.nextInt();

                        if (tipoSaldo < 1 || tipoSaldo > 4) {
                            System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 4.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } while (tipoSaldo < 1 || tipoSaldo > 4);

                switch (tipoSaldo) {
                    case 1:
                        tipo = "Peso";
                        break;
                    case 2:
                        tipo = "Dólar";
                        break;
                    case 3:
                        tipo = "Euro";
                        break;
                    case 4:
                        tipo = "Yen";
                        break;
                    default:
                        System.out.println("=========================================");
                        System.out.println("|  Opción invalida, intente nuevamente  |");
                        System.out.println("=========================================");
                        continue;
                }
                System.out.print("Cantidad: ");
                saldo = scanner.nextDouble();

                Billetera billetera = new Billetera(user.getRut(), tipo, saldo);
                user.agregarBilletera(billetera);
                scanner.nextLine();
                break;
            }
        }
    }

    /**
     * Menu para seleccionar el tipo de divisa que uno quiere utilizar.
     */
    private static void SeleccioneDivisa() {
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

    /**
     * Pregunta si desea realizar otra acción dentro del sistema para poder reingresar al menu anterior.
     *
     * @param scanner Se envía la clase Scanner con el fin de poder obtener respuesta.
     * @return Retorna verdadero si se desea continuar con una operación, de lo contrario retorna falso para salir del sistema.
     * @author Javier Alcántara
     */
    private static boolean preguntaOtraOperacion(Scanner scanner) {
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

    /**
     * Método que realiza la tarea de agregar el usuario, pidiendo al usuario todos los datos necesarios para su creación.
     *
     * @param scanner Se envía la clase Scanner con el fin de poder obtener los datos del usuario.
     * @return Retorna un Usuario (cl.billeteraVirtual.clases.Usuario) creado para poder ser agregado al Array listaUsuarios.
     * @author Javier Alcántara
     */
    private static Usuario RegistroUsuario(Scanner scanner) {
        String nombre, apellido, rut, correo, contrasena, vContrasena;
        Usuario usuario = new Usuario();
        System.out.print("Ingrese Nombre: ");
        nombre = scanner.nextLine();
        System.out.print("Ingrese Apellido: ");
        apellido = scanner.nextLine();
        while (true) {
            System.out.print("Ingrese Rut: ");
            rut = scanner.nextLine();
            if (validarRut(rut)) {
                rut = formatearRut(rut);
                break;
            } else {
                MensajeRutInvalido();
            }
        }
        System.out.print("Ingrese Correo: ");
        correo = scanner.nextLine();

        while (true) {
            System.out.print("Ingrese Contraseña: ");
            contrasena = scanner.nextLine();
            System.out.print("Ingrese Contraseña nuevamente: ");
            vContrasena = scanner.nextLine();
            if (contrasena.equals(vContrasena)) {
                break;
            } else {
                System.out.println("=========================================");
                System.out.println("|       Contraseñas no coinciden,       |");
                System.out.println("|           intente nuevamente          |");
                System.out.println("=========================================");

            }
        }
        return usuario = new Usuario(nombre, apellido, rut, correo, contrasena);
    }

    private static void MensajeRutInvalido() {
        System.out.println("============================");
        System.out.println("|    Ingrese Rut Válido    |");
        System.out.println("============================");
    }

    /**
     * Menu de bienvenida inicial al ejecutar aplicación.
     */
    public static void MenuInicio() {
        System.out.println("============================");
        System.out.println("|   BIENVENIDO A WALLET    |");
        System.out.println("============================");
        System.out.println("| Opciones:                |");
        System.out.println("|        1. Conectar       |");
        System.out.println("|        2. Registrar      |");
        System.out.println("|        3. Salir          |");
        System.out.println("============================");
    }

    /**
     * Pantalla de opción 1 (Conectar).
     */
    public static void MenuConectar() {
        System.out.println("============================");
        System.out.println("|         CONECTAR         |");
        System.out.println("============================");
        System.out.println("|                          |");
        System.out.println("|    Ingrese su correo     |");
        System.out.println("|             y            |");
        System.out.println("|        contraseña        |");
        System.out.println("|                          |");
        System.out.println("============================");
    }

    /**
     * Pantalla de opción 2 (Registrar).
     */
    public static void MenuRegistrar() {
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

    /**
     * Pantalla de despedida, para cerrar al cerrar programa con opción 3 (Salir).
     */
    public static void MenuDespedida() {
        System.out.println("=========================================");
        System.out.println("|   Que tenga un buen día, Hasta Luego  |");
        System.out.println("=========================================");
    }

    /**
     * Método que válida si el rut ingresado es válido.
     *
     * @param rut Se rescata el rut ingresado
     * @return verdadero o falso, si de cumple condición
     */
    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return validacion;
    }

    /**
     * @param rut Se rescata el Rut ingresado por el usuario.
     * @return rut completo formateado con puntos y guíon.
     */
    public static String formatearRut(String rut) {
        int cont = 0;
        StringBuilder format;
        if (rut.isEmpty()) {
            return "";
        } else {
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            format = new StringBuilder(("-" + rut.substring(rut.length() - 1)));
            for (int i = rut.length() - 2; i >= 0; i--) {
                format.insert(0, rut.charAt(i));
                cont++;
                if (cont == 3 && i != 0) {
                    format.insert(0, ".");
                    cont = 0;
                }
            }
            return format.toString();
        }
    }
}
