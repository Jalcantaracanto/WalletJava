package cl.billeteraVirtual.clases;

public abstract class Cuenta {
    private long idCuenta;
    private Usuario cuentaUsuario;

    public Cuenta(long idCuenta, Usuario cuentaUsuario) {
        this.idCuenta = idCuenta;
        this.cuentaUsuario = cuentaUsuario;
    }

    public Cuenta() {

    }


    public Usuario getCuentaUsuario() {
        return cuentaUsuario;
    }


    // Métodos Custom

    public abstract void crearCuenta(Boolean cuentaNueva);


}
