package cl.billeteraVirtual.clases;

public class Menu {

    public void MenuInicio() {
        System.out.println("============================");
        System.out.println("|   BIENVENIDO A WALLET    |");
        System.out.println("============================");
        System.out.println("| Opciones:                |");
        System.out.println("|        1. Conectar       |");
        System.out.println("|        2. Registrar      |");
        System.out.println("|        3. Salir          |");
        System.out.println("============================");
    }

    public void SeleccioneDivisa() {
        System.out.println("============================");
        System.out.println("|   SELECCIONE DIVISA      |");
        System.out.println("============================");
        System.out.println("| Opciones:                |");
        System.out.println("|        1. Peso Chileno   |");
        System.out.println("|        2. Dólar          |");
        System.out.println("|        3. Euro           |");
        System.out.println("|        4. Yen            |");
        System.out.println("============================");
    }

    public void MensajeRutInvalido() {
        System.out.println("============================");
        System.out.println("|    Ingrese Rut Válido    |");
        System.out.println("============================");
    }
}
