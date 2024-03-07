package Otros;

public class Test {
    public static void main(String[] args) {
        // RUT almacenado en una variable
        String rut = "12.345.678-9";

        // Creamos un objeto StringBuilder
        StringBuilder sb = new StringBuilder();

        // Paso 1: Eliminamos los puntos y el guion del RUT original
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");

        // Imprimimos el RUT sin puntos ni guiones
        System.out.println("Paso 1 - RUT sin puntos ni guiones: " + rut);

        // Paso 2: Construimos el RUT formateado
        sb.append("-").append(rut.substring(rut.length() - 1)); // Agregamos el último dígito con un guion al principio

        int cont = 0;
        for (int i = rut.length() - 2; i >= 0; i--) {
            sb.insert(0, rut.charAt(i)); // Insertamos los dígitos del RUT uno por uno al principio
            cont++;
            System.out.println(sb);
            if (cont == 3 && i != 0) {
                sb.insert(0, "."); // Insertamos un punto cada tres dígitos, excepto al inicio
                cont = 0; // Reiniciamos el contador
            }
        }

        // Imprimimos el RUT formateado
        System.out.println("Paso 2 - RUT formateado: " + sb);
    }
}

