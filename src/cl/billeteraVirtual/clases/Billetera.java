package cl.billeteraVirtual.clases;

public class Billetera {
    private String rut, moneda;
    private double saldo;

    public Billetera() {
    }

    public Billetera(String rut, String moneda, double saldo) {
        this.rut = rut;
        this.moneda = moneda;
        this.saldo = saldo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void ingresoSaldo(double ingresoSaldo) {
        this.saldo += ingresoSaldo;
        System.out.println("Sú nuevo saldo en " + getMoneda() + " es " + getSaldo());
    }

    public void retiroSaldo(double retiroSaldo) {
        if (saldo - retiroSaldo >= 0) {
            this.saldo -= retiroSaldo;
            System.out.println("Sú nuevo saldo en " + getMoneda() + " es " + getSaldo());
        } else {
            System.out.println("No tiene saldo suficiente para retirar");
        }
    }
}
