package cl.billeteraVirtual.clases;

public abstract class Cuenta {
    private long idCuenta;
    private Usuario cuentaUsuario;

    public Cuenta(long idCuenta, Usuario cuentaUsuario) {
        this.idCuenta = idCuenta;
        this.cuentaUsuario = cuentaUsuario;
    }

    public long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Usuario getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(Usuario cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }

    // Métodos Custom

    public abstract void crearCuenta();

    public abstract void listarCuenta();

}
