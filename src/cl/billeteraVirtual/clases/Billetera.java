package cl.billeteraVirtual.clases;

public class Billetera {
    public String rut, moneda;
    public double saldo;

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

    @Override
    public String toString() {
        return "cl.billeteraVirtual.clases.Billetera{" +
                "rut='" + rut + '\'' +
                ", moneda='" + moneda + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
