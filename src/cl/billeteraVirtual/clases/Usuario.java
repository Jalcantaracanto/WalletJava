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
        Scanner scanner = new Scanner(System.in);
        String formatoSaldo = "";
        String moneda = "";

        System.out.println("=================================");
        System.out.println("|       SALDOS DISPONIBLES      |");
        System.out.println("=================================");

        for (Billetera billetera : billeteras) {
            String tipoSaldo = billetera.getMoneda();
            switch (tipoSaldo) {
                case "Peso":
                    formatoSaldo = "$%,.0f";
                    moneda = "Peso:";
                    break;
                case "Dolar":
                    formatoSaldo = "$%,.2f";
                    moneda = "Dólar:";
                    break;
                case "Euro":
                    formatoSaldo = "€%,.2f";
                    moneda = "Euro:";
                    break;
                case "Yen":
                    formatoSaldo = "¥%,.0f";
                    moneda = "Yen:";
                    break;
                default:
                    System.out.println("Tipo de saldo no válido.");
                    return;
            }

            String saldoFormateado = String.format(formatoSaldo, billetera.getSaldo());

            if (saldoFormateado.length() > 27) {
                saldoFormateado = saldoFormateado.substring(0, 27);
            }

            int longitudMoneda = moneda.length();
            int longitudSaldo = saldoFormateado.length();

            int espaciosEntreMonedaYSaldo = 27 - longitudMoneda - longitudSaldo;
            System.out.printf("| %s %-" + espaciosEntreMonedaYSaldo + "s %s |%n", moneda, "", saldoFormateado);
        }

        System.out.println("=================================");
        System.out.println("Presione ENTER para continuar...");
        scanner.nextLine();
    }

    public void operacionSumaRestaSaldo(String moneda, Scanner scanner, boolean ingreso) {
        String operacion = ingreso ? "ingresar" : "retirar";
        System.out.printf("|    %s     |\n", moneda);
        System.out.println("============================");
        System.out.println("Saldo a " + operacion + ": ");
        double saldo = scanner.nextDouble();
        boolean billeteraEncontrada = false;
        for (Billetera billetera : getBilleteras()) {
            if (billetera.getMoneda().equalsIgnoreCase(moneda)) {
                if (ingreso) {
                    billetera.sumarSaldo(saldo);
                } else {
                    billetera.restarSaldo(saldo);
                }
                billeteraEncontrada = true;
                break;
            }
        }
        if (!billeteraEncontrada && !ingreso) {
            System.out.println("No dispones de este tipo de moneda");
        } else if (!billeteraEncontrada) {
            Billetera nuevabilletera = new Billetera(moneda, saldo);
            agregarBilletera(nuevabilletera);
        }
    }
}
