package cl.billeteraVirtual.clases;

public class CuentaVista extends Cuenta implements Transaccion {
    private int saldo;
    private long nroCuenta;

    public CuentaVista(long idCuenta, Usuario cuentaUsuario) {
        super(idCuenta, cuentaUsuario);
    }

    @Override
    public void crearCuenta() {

    }

    @Override
    public void listarCuenta() {

    }


    @Override
    public void ingresarSaldo(int monto) {

    }

    @Override
    public void retirarSaldo(int monto) {

    }

    @Override
    public void mostrarSaldo() {

    }

    @Override
    public void comprobarSaldo() {

    }
}
