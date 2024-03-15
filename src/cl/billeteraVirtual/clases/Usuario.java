package cl.billeteraVirtual.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    // 1 - Atributos
    private String nombre, apellido, rut, correo, contrasena;
    private List<Billetera> billeteras;


    // 2 - Constructores
    public Usuario() {
        this.billeteras = new ArrayList<>();
    }

    public Usuario(String nombre, String apellido, String rut, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
        this.billeteras = new ArrayList<>();
    }

    // 3 - Métodos de Acceso
    public String getNombre() {
        return nombre;
    }

    public List<Billetera> getBilleteras() {
        return billeteras;
    }

    public void setBilleteras(List<Billetera> billeteras) {
        this.billeteras = billeteras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    // 4 - Métodos de compartimiento
    @Override
    public String toString() {
        return "cl.billeteraVirtual.clases.Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rut='" + rut + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contrasena + '\'' +
                '}';
    }

    // 5 - Métodos Custom

    public void agregarBilletera(Billetera billetera) {
        billeteras.add(billetera);
    }

    public double obtenerSaldo(String moneda) {
        double saldoTotal = 0.0;
        for (Billetera billetera : billeteras) {
            if (billetera.getMoneda().equalsIgnoreCase(moneda)) {
                saldoTotal += billetera.getSaldo();
            }
        }
        return saldoTotal;
    }

    public void verSaldoDisponible() {
        System.out.println("Saldos en cuenta");
        for (Billetera billetera : billeteras) {
            System.out.printf("**** %s ****\n", billetera.getMoneda());
            System.out.printf("Saldo: %f\n", billetera.getSaldo());
            System.out.println("*****************");
        }
    }

    public void ingresarSaldo(String moneda, Scanner scanner) {

        System.out.printf("|    %s     |\n", moneda);
        System.out.println("============================");
        System.out.println("Saldo a ingresar: ");
        double saldo = scanner.nextDouble();
        boolean billeteraEncontrada = false;
        for (Billetera billetera : getBilleteras()) {
            if (billetera.getMoneda().equalsIgnoreCase(moneda)) {
                billetera.ingresoSaldo(saldo);
                billeteraEncontrada = true;
                break;
            }
        }
        if (!billeteraEncontrada) {
            Billetera nuevabilletera = new Billetera(getRut(), moneda, saldo);
            agregarBilletera(nuevabilletera);
        }
    }

    public void retirarSaldo(String moneda, Scanner scanner) {
        System.out.printf("|    %s     |\n", moneda);
        System.out.println("============================");
        System.out.println("Saldo a retirar: ");
        double saldo = scanner.nextDouble();
        boolean billeteraEncontrada = false;
        for (Billetera billetera : getBilleteras()) {
            if (billetera.getMoneda().equalsIgnoreCase(moneda)) {
                billetera.retiroSaldo(saldo);
                billeteraEncontrada = true;
                break;
            }
        }
        if (!billeteraEncontrada) {
            System.out.println("No dispones de este tipo de moneda");
        }
    }
}
