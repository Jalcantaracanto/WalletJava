package cl.billeteraVirtual.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Usuario {
    // 1 - Atributos
    private long idUsuario;
    private String nombre, apellido, rut, correo, contrasena;
    private List<Cuenta> listaCuentas = new ArrayList<Cuenta>();

    public Usuario(long idUsuario, String nombre, String apellido, String rut, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario() {

    }

    public List<Cuenta> getListaCuenta() {
        return listaCuentas;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }


    //Métodos Custom

    public Usuario crearUsuario() {

        UUID uuid = UUID.randomUUID();
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long id = mostSignificantBits ^ leastSignificantBits;


        Scanner scanner = new Scanner(System.in);
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
                Menu.mensajeRutInvalido();
            }
        }

        while (true) {
            System.out.print("Ingrese Correo: ");
            correo = scanner.nextLine();
            if (validarCorreo(correo)) {
                break;
            } else {
                Menu.mensajeCorreoInvalido();
            }
        }

        while (true) {
            System.out.print("Ingrese Contraseña: ");
            contrasena = scanner.nextLine();
            System.out.print("Ingrese Contraseña nuevamente: ");
            vContrasena = scanner.nextLine();
            if (contrasena.equals(vContrasena)) {
                break;
            } else {
                Menu.mensajeContrasenaDistinta();
            }
        }

        return new Usuario(id, nombre, apellido, rut, correo, contrasena);
    }

    public void agregarCuenta(Cuenta cuenta) {
        this.listaCuentas.add(cuenta);
    }

    public boolean validarRut(String rut) {

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
    public String formatearRut(String rut) {
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

    public boolean validarCorreo(String correo) {
        // Expresión regular simple para validar un correo electrónico
        String regex = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
        return correo.matches(regex);
    }

}
