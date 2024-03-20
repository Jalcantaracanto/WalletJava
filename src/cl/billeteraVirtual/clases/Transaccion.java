package cl.billeteraVirtual.clases;

public interface Transaccion {
    void ingresarSaldo(int monto);

    void retirarSaldo(int monto);

    void mostrarSaldo();

    void comprobarSaldo();
}
