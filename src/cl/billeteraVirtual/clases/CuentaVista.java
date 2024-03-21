package cl.billeteraVirtual.clases;

import java.util.Scanner;
import java.util.UUID;

public class CuentaVista extends Cuenta implements Transaccion {
    private int saldo;
    private long nroCuenta;
    private String tipoCuenta;

    public CuentaVista(long idCuenta, Usuario cuentaUsuario) {
        super(idCuenta, cuentaUsuario);
    }

    public CuentaVista(long idCuenta, Usuario cuentaUsuario, int saldo, long nroCuenta, String tipoCuenta) {
        super(idCuenta, cuentaUsuario);
        this.saldo = saldo;
        this.nroCuenta = nroCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    public CuentaVista() {
        super();
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public long getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(long nroCuenta) {
        this.nroCuenta = nroCuenta;
    }


    @Override
    public void crearCuenta(Boolean cuentaNueva) {

        Scanner scanner = new Scanner(System.in);

        UUID uuid = UUID.randomUUID();
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long idCuenta = mostSignificantBits ^ leastSignificantBits;
        long nroCuenta = uuid.getMostSignificantBits();

        if (cuentaNueva) {
            System.out.print("Ingrese saldo: ");
            int saldoInicial = scanner.nextInt();
            CuentaVista nuevaCuenta = new CuentaVista(idCuenta, getCuentaUsuario(), saldoInicial, nroCuenta, tipoCuenta);
            getCuentaUsuario().agregarCuenta(nuevaCuenta);
            System.out.println("Cuenta creada exitosamente.");
        } else {
            CuentaVista nuevaCuenta = new CuentaVista(idCuenta, getCuentaUsuario(), 0, nroCuenta, tipoCuenta);
            getCuentaUsuario().agregarCuenta(nuevaCuenta);
            System.out.println("Cuenta creada exitosamente.");
        }

    }


    @Override
    public void ingresarSaldo(int monto) {
        this.saldo += monto;
        System.out.printf("Sú nuevo saldo es: %d\n", this.saldo);
    }

    @Override
    public void retirarSaldo(int monto) {
        this.saldo -= monto;
        System.out.printf("Sú nuevo saldo es: %d\n", this.saldo);
    }

    @Override
    public void mostrarSaldo() {
        Scanner scanner = new Scanner(System.in);
        String moneda = "Pesos";

        System.out.println("=================================");
        System.out.println("|       SALDO DISPONIBLE         |");
        System.out.println("=================================");

        // Formatear el saldo correctamente
        String saldoFormateado = String.format("%d", getSaldo());

        // Recortar la longitud del saldo si es necesario
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
