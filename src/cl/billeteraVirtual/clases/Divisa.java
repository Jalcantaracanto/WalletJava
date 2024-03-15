package cl.billeteraVirtual.clases;

import java.util.HashMap;
import java.util.Map;

public class Divisa {
    private Map<String, Double> tasasDeCambio;

    public Divisa() {
        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("Dolar-Peso", 966.0);
        tasasDeCambio.put("Dolar-Euro", 0.92);
        tasasDeCambio.put("Dolar-Yen", 149.0);
        tasasDeCambio.put("Peso-Dolar", 1 / 966.0);
        tasasDeCambio.put("Peso-Euro", 1 / 1060.34);
        tasasDeCambio.put("Peso-Yen", 0.16);
        tasasDeCambio.put("Euro-Dolar", 1.09);
        tasasDeCambio.put("Euro-Peso", 1060.34);
        tasasDeCambio.put("Euro-Yen", 162.32);
        tasasDeCambio.put("Yen-Dolar", 0.0067);
        tasasDeCambio.put("Yen-Peso", 6.33);
        tasasDeCambio.put("Yen-Euro", 0.0062);
    }

    public double cambioDivisa(double monto, String divisaOrigen, String divisaDestino) {
        String clave = divisaOrigen + "-" + divisaDestino;
        Double tasaDeCambio = tasasDeCambio.get(clave);

        double montoConvertido = monto * tasaDeCambio;

        return montoConvertido;
    }
}
