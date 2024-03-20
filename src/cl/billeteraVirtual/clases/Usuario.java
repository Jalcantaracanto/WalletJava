package cl.billeteraVirtual.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    // 1 - Atributos
    private long idUsuario;
    private String nombre, apellido, rut, correo, contrasena;
    private List<Cuenta> cuentas;

    public Usuario(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Usuario(long idUsuario, String nombre, String apellido, String rut, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    //Métodos Custom

    public Usuario crearUsuario() {
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
                menu.mensajeCorreoInvalido();
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
                menu.mensajeContrasenaDistinta();
            }
        }

        return new Usuario(nombre, apellido, rut, correo, contrasena);
    }

    public void listarUsuario() {

    }

}
