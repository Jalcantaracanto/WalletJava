package cl.billeteraVirtual.clases;

public class Divisa {
    private double dolarAPesoChileno = 966;
    private double euroAPesoChileno = 1060.34;
    private double yenAPesoChileno = 7;

    public Divisa() {
    }

    // Método para realizar el cambio de divisa
    public double cambioDivisa(double monto, String divisaOrigen, String divisaDestino) {
        double montoConvertido = 0.0;
        if (divisaOrigen.equals("Dólar")) {
            if (divisaDestino.equals("Peso")) {
                montoConvertido = monto * dolarAPesoChileno;
            } else if (divisaDestino.equals("Euro")) {
                montoConvertido = monto * (euroAPesoChileno / dolarAPesoChileno);
            } else if (divisaDestino.equals("Yen")) {
                montoConvertido = monto * (yenAPesoChileno / dolarAPesoChileno);
            }
        } else if (divisaOrigen.equals("Peso")) {
            if (divisaDestino.equals("Dólar")) {
                montoConvertido = monto / dolarAPesoChileno;
            } else if (divisaDestino.equals("Euro")) {
                montoConvertido = monto / (euroAPesoChileno / dolarAPesoChileno);
            } else if (divisaDestino.equals("Yen")) {
                montoConvertido = monto / (yenAPesoChileno / dolarAPesoChileno);
            }
        } else if (divisaOrigen.equals("Euro")) {
            if (divisaDestino.equals("Dólar")) {
                montoConvertido = monto * (dolarAPesoChileno / euroAPesoChileno);
            } else if (divisaDestino.equals("Peso Chileno")) {
                montoConvertido = monto * (euroAPesoChileno / dolarAPesoChileno);
            } else if (divisaDestino.equals("Yen")) {
                montoConvertido = monto * ((yenAPesoChileno / dolarAPesoChileno) / (euroAPesoChileno / dolarAPesoChileno));
            }
        } else if (divisaOrigen.equals("Yen")) {
            if (divisaDestino.equals("Dólar")) {
                montoConvertido = monto * (dolarAPesoChileno / yenAPesoChileno);
            } else if (divisaDestino.equals("Peso Chileno")) {
                montoConvertido = monto * (yenAPesoChileno / dolarAPesoChileno);
            } else if (divisaDestino.equals("Euro")) {
                montoConvertido = monto * ((euroAPesoChileno / dolarAPesoChileno) / (yenAPesoChileno / dolarAPesoChileno));
            }
        }
        return montoConvertido;
    }

}
