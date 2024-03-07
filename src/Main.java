import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Billetera> listaBilleteras = new ArrayList<>();

        int opcion;

        while (true) {
            MenuInicio();
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    String email, contrasena;
                    MenuConectar();
                    System.out.print("Correo: ");
                    email = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    contrasena = scanner.nextLine();
                    break;
                case 2:
                    MenuRegistrar();

                    Usuario user = RegistroUsuario(scanner);
                    listaUsuarios.add(user);

                    String deseaSaldo;
                    System.out.println("============================");
                    System.out.println("|    Registro Completado   |");
                    System.out.println("|  ¿Desea ingresar saldo?  |");
                    System.out.println("|        ( s / n )         |");
                    System.out.println("============================");

                    String deseoSaldo;

                    System.out.print("Respuesta: ");
                    deseoSaldo = scanner.nextLine();
                    if (deseoSaldo.equalsIgnoreCase("s")) {
                        Billetera billetera = new Billetera();
                        String moneda;
                        double saldo;

                        System.out.println("============================");
                        System.out.println("|   SELECCIONE DIVISA      |");
                        System.out.println("============================");
                        System.out.println("| Opciones:                |");
                        System.out.println("|        1. Peso Chileno   |");
                        System.out.println("|        2. Dolar          |");
                        System.out.println("|        3. Euro           |");
                        System.out.println("|        4. Yen            |");
                        System.out.println("============================");

                        int tipoSaldo = scanner.nextInt();
                        String tipo;
                        switch (tipoSaldo) {
                            case 1:
                                tipo = "Peso";
                                System.out.print("Cantidad: ");
                                saldo = scanner.nextInt();
                                listaBilleteras.add(new Billetera(user.getRut(), tipo, saldo));
                                break;
                            case 2:
                                break;
                        }

                    }


                    System.out.println();
                    System.out.println(listaUsuarios);
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
     * Metodo que realiza la tarea de agregar el usurio, pidiendo al usuario todos los datos necesarios para su creación.
     *
     * @param scanner Se envia la clase Scanner con el fin de poder obtener los datos del usuario.
     * @return Retorna un Usuario creado para poder ser agregado al Array listaUsuarios.
     * @author Javier Alcántara
     */
    private static Usuario RegistroUsuario(Scanner scanner) {
        String nombre, apellido, rut, correo, contrasena, vContrasena;
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
        return new Usuario(nombre, apellido, rut, correo, contrasena);
    }

    private static void MensajeRutInvalido() {
        System.out.println("============================");
        System.out.println("|    Ingrese Rut Válido    |");
        System.out.println("============================");
    }

    // FUNCIONES

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
