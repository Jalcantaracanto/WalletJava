package cl.billeteraVirtual.clases;


import java.util.HashMap;
import java.util.Map;

public class Divisa {
    private Map<String, Double> tasasDeCambio;

    public Divisa() {
        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("Dolar-Peso", 966.0);
        tasasDeCambio.put("Dolar-Euro", 1060.34);
        tasasDeCambio.put("Dolar-Yen", 7.0);
        tasasDeCambio.put("Peso-Dolar", 1 / 966.0);
        tasasDeCambio.put("Peso-Euro", 1 / (1060.34 / 966.0));
        tasasDeCambio.put("Peso-Yen", 1 / (7.0 / 966.0));
        tasasDeCambio.put("Euro-Dolar", 1 / 1060.34);
        tasasDeCambio.put("Euro-Peso", 1060.34 / 966.0);
        tasasDeCambio.put("Euro-Yen", (7.0 / 966.0) / (1060.34 / 966.0));
        tasasDeCambio.put("Yen-Dolar", 1 / 7.0);
        tasasDeCambio.put("Yen-Peso", 7.0 / 966.0);
        tasasDeCambio.put("Yen-Euro", (1060.34 / 966.0) / (7.0 / 966.0));
    }


    public double cambioDivisa(double monto, String divisaOrigen, String divisaDestino) {
        String clave = divisaOrigen + "-" + divisaDestino;
        Double tasaDeCambio = tasasDeCambio.get(clave);

        return monto * tasaDeCambio;
    }
}
