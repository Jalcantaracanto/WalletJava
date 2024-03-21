package cl.billeteraVirtual.clases;

import java.util.Scanner;
import java.util.UUID;

public class SistemaBanco {

    public static void sistemaBanco(Banco banco) {
//        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (true) {
            while (true) {
                Menu.menuInicio();
                System.out.print("Respuesta: ");
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    break;
                } else {
                    Menu.mensajeOpcionInvalida();
                    scanner.nextLine();
                }
            }
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    banco.buscarUsuario();
                    break;
                case 2:
                    Menu.menuRegistrar();
                    Usuario usuario = new Usuario();
                    usuario = usuario.crearUsuario();
                    banco.agregarUsuario(usuario);
                    sistemaIngresarSaldoInicial(scanner, usuario);
                    break;
            }
            if (opcion == 3) {
                Menu.mensajeDespedida();
                break;
            }
        }
    }


    public static void sistemaUsuario(Scanner scanner, Usuario usuario) {
        int opcion;

        while (true) {
            Menu.menuConsultasUsuario();
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            int monto;
            CuentaVista cuentaVista = null;

            for (Cuenta cuenta : usuario.getListaCuenta()) {
                if (cuenta instanceof CuentaVista) {
                    cuentaVista = (CuentaVista) cuenta;
                    break;
                }
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese Cantidad: ");
                    monto = scanner.nextInt();
                    cuentaVista.ingresarSaldo(monto);
                    break;
                case 2:
                    System.out.print("Ingrese Cantidad: ");
                    monto = scanner.nextInt();
                    cuentaVista.retirarSaldo(monto);
                    break;
                case 3:
                    Menu.menuSeleccionarDivisa();
                    System.out.print("Respuesta: ");
                    int tipoConversor = scanner.nextInt();
                    int saldo;

                    switch (tipoConversor) {
                        case 1:
                            Dolar dolar = new Dolar();
                            dolar.convertirSaldo(cuentaVista.getSaldo());
                            break;
                        case 2:
                            Euro euro = new Euro();
                            euro.convertirSaldo(cuentaVista.getSaldo());
                            break;
                    }
                    break;
                case 4:
                    cuentaVista.mostrarSaldo();
                    break;
                default:
                    break;
            }
        }
    }


    public static void sistemaIngresarSaldoInicial(Scanner scanner, Usuario usuario) {
        String saldoInicial = "";
        boolean entradaValida = true;
        CuentaVista cuentaVista = new CuentaVista();
        cuentaVista.setCuentaUsuario(usuario);
        do {
            Menu.menuIngresarSaldoRegistro();
            System.out.print("Respuesta: ");
            saldoInicial = scanner.nextLine();
            if (saldoInicial.equalsIgnoreCase("s") || saldoInicial.equalsIgnoreCase("n")) {
                entradaValida = true;
            } else {
                Menu.mensajeResponderSN();
            }

        } while (!entradaValida);

        if (saldoInicial.equalsIgnoreCase("s")) {
            cuentaVista.crearCuenta(true);
        } else {
            cuentaVista.crearCuenta(false);
        }
    }
}
