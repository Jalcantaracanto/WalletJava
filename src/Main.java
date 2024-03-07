import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Billetera> listaBilleteras = new ArrayList<>();

        int opcion;
        String salir;


        while (true) {
            // Menu Bienvenido
            System.out.println("============================");
            System.out.println("|   BIENVENIDO A WALLET    |");
            System.out.println("============================");
            System.out.println("| Opciones:                |");
            System.out.println("|        1. Conectar       |");
            System.out.println("|        2. Registrar      |");
            System.out.println("|        3. Salir          |");
            System.out.println("============================");
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    String email, pass;
                    System.out.println("============================");
                    System.out.println("|         CONECTAR         |");
                    System.out.println("============================");
                    System.out.println("|                          |");
                    System.out.println("|    Ingrese su correo     |");
                    System.out.println("|             y            |");
                    System.out.println("|        contraseña        |");
                    System.out.println("|                          |");
                    System.out.println("============================");
                    System.out.print("Correo: ");
                    email = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    pass = scanner.nextLine();
                    break;
                case 2:
                    String nombre, apellido, rut, correo, contrasena, vContrasena;
                    System.out.println("============================");
                    System.out.println("|         REGISTRO         |");
                    System.out.println("============================");
                    System.out.println("|                          |");
                    System.out.println("|  Proporcione los datos   |");
                    System.out.println("|      solicitados en      |");
                    System.out.println("|         consola          |");
                    System.out.println("|                          |");
                    System.out.println("============================");
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
                            System.out.println("============================");
                            System.out.println("|    Ingrese Rut Válido    |");
                            System.out.println("============================");
                        }
                    }
                    System.out.print("Ingrese Correo: ");
                    correo = scanner.nextLine();
                    System.out.print("Ingrese Contraseña: ");
                    contrasena = scanner.nextLine();
//                System.out.println("Ingrese Contraseña nuevamente: ");
                    Usuario usuario = new Usuario(nombre, apellido, rut, correo, contrasena);
                    listaUsuarios.add(usuario);
                    System.out.println(listaUsuarios);
                    break;
                default:
                    System.out.println("Hasta nunca más");
                    break;
            }
            System.out.println("=========================================");
            System.out.println("| ¿Desea realizar otra operación? (s/n) |");
            System.out.println("=========================================");
            System.out.print("Respuesta: ");
            salir = scanner.nextLine();
            if (salir.equalsIgnoreCase("s")) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            } else {
                break;
            }

        }

    }


    /**
     * Metodo que valida si el rut ingresado es valido.
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

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    /**
     * @param rut Se rescata el rut ingresado por el usario.
     * @return rut completo formateado con los . y -
     * @author Javier Alcántara
     */
    public static String formatearRut(String rut) {
        int cont = 0;
        String format;
        if (rut.length() == 0) {
            return "";
        } else {
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            format = "-" + rut.substring(rut.length() - 1);
            for (int i = rut.length() - 2; i >= 0; i--) {
                format = rut.substring(i, i + 1) + format;
                cont++;
                if (cont == 3 && i != 0) {
                    format = "." + format;
                    cont = 0;
                }
            }
            return format;
        }
    }


}
