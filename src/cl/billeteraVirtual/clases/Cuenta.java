package cl.billeteraVirtual.clases;

public abstract class Cuenta {

    // Atributos
    private long idCuenta;
    private Usuario cuentaUsuario;

    // Constructor
    public Cuenta(long idCuenta, Usuario cuentaUsuario) {
        this.idCuenta = idCuenta;
        this.cuentaUsuario = cuentaUsuario;
    }

    public Cuenta() {

    }

    // Accesadores y Mutadores
    public Usuario getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(Usuario cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }

    // Métodos Custom

    public abstract void crearCuenta(Boolean cuentaNueva);


}
