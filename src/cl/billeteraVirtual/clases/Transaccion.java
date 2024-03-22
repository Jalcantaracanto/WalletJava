package cl.billeteraVirtual.clases;

public interface Transaccion {
    void ingresarSaldo(double monto);

    void retirarSaldo(double monto);

    void mostrarSaldo();

}
