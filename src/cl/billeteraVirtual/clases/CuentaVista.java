package cl.billeteraVirtual.clases;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

public class CuentaVista extends Cuenta implements Transaccion {

    // Atributos
    private double saldo;
    private long nroCuenta;
    private String tipoCuenta;

    // Constructor
    public CuentaVista(long idCuenta, Usuario cuentaUsuario, int saldo, long nroCuenta, String tipoCuenta) {
        super(idCuenta, cuentaUsuario);
        this.saldo = saldo;
        this.nroCuenta = nroCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    public CuentaVista() {
        super();
    }

    // Accesadores y mutadores
    public double getSaldo() {
        return saldo;
    }


    // Métodos

    /**
     * Método que permite crear una cuenta vista, para ello se solicita el saldo inicial
     * y se crea un objeto de tipo CuentaVista, el cual se agrega a la lista de cuentas del usuario
     * A demás verifica si el usuario desea ingresar un saldo inicial a la cuenta.
     *
     * @param nuevoSaldo Indica si desea ingresar un saldo inicial o no.
     */
    @Override
    public void crearCuenta(Boolean nuevoSaldo) {

        Scanner scanner = new Scanner(System.in);

        UUID uuid = UUID.randomUUID();
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long idCuenta = mostSignificantBits ^ leastSignificantBits;
        long nroCuenta = uuid.getMostSignificantBits();

        if (nuevoSaldo) {
            System.out.print("Ingrese saldo: ");
            int saldoInicial = scanner.nextInt();
            scanner.nextLine();
            CuentaVista nuevaCuenta = new CuentaVista(idCuenta, getCuentaUsuario(), saldoInicial, nroCuenta, tipoCuenta);
            getCuentaUsuario().agregarCuenta(nuevaCuenta);
            Menu.mensajeCreacionExitosa();
        } else {
            CuentaVista nuevaCuenta = new CuentaVista(idCuenta, getCuentaUsuario(), 0, nroCuenta, tipoCuenta);
            getCuentaUsuario().agregarCuenta(nuevaCuenta);
            Menu.mensajeCreacionExitosa();
        }

    }


    /**
     * Método que permite ingresar saldo a la cuenta vista, para ello se solicita el monto a ingresar
     * y se actualiza el saldo de la cuenta.
     *
     * @param monto Monto a ingresar a la cuenta.
     */
    @Override
    public void ingresarSaldo(double monto) {
        this.saldo += monto;
        Menu.mensajeIngresoRetiroSaldo(this.saldo, true);
    }

    /**
     * Método que permite retirar saldo de la cuenta vista, para ello se solicita el monto a retirar
     * y se actualiza el saldo de la cuenta. A demás verifica que no se pueda retirar un monto mayor al saldo disponible.
     *
     * @param monto Monto a retirar de la cuenta.
     */
    @Override
    public void retirarSaldo(double monto) {
        double nuevoSaldo = this.saldo - monto;

        if (nuevoSaldo < 0) {
            Menu.mensajeSaldoInsuficiente();
        } else {
            this.saldo = nuevoSaldo;
            Menu.mensajeIngresoRetiroSaldo(this.saldo, false);
        }
    }

    /**
     * Método que muestra el saldo disponible en la cuenta vista.
     */
    @Override
    public void mostrarSaldo() {
        Scanner scanner = new Scanner(System.in);
        String moneda = "Pesos";

        System.out.println("=================================");
        System.out.println("|       SALDO DISPONIBLE         |");
        System.out.println("=================================");

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        decimalFormat.applyPattern("#,###.##");
        String saldoFormateado = "$" + decimalFormat.format(getSaldo());


        if (saldoFormateado.length() > 27) {
            saldoFormateado = saldoFormateado.substring(0, 27);
        }

        int longitudMoneda = moneda.length();
        int longitudSaldo = saldoFormateado.length();

        int espaciosEntreMonedaYSaldo = 27 - longitudMoneda - longitudSaldo;
        System.out.printf("| %s %-" + espaciosEntreMonedaYSaldo + "s %s |%n", moneda, "", saldoFormateado);

        System.out.println("=================================");
        System.out.println("Presione ENTER para continuar...");
        scanner.nextLine();
    }


}
