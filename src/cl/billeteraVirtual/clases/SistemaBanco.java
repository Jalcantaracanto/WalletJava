package cl.billeteraVirtual.clases;

import java.util.InputMismatchException;
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
                System.out.print("Opción: ");
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion == 3) {
                        break;
                    }
                    if (opcion >= 1 && opcion <= 2) {
                        break;
                    } else {
                        Menu.mensajeOpcionInvalida();
                    }
                } else {
                    Menu.mensajeOpcionInvalida();
                    scanner.nextLine();
                }
            }

            if (opcion == 3) {
                Menu.mensajeDespedida();
                break;
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
                default:
                    Menu.mensajeOpcionInvalida();
                    break;
            }
        }
    }


    public static void sistemaUsuario(Scanner scanner, Usuario usuario) {
        int opcion;

        while (true) {
            CuentaVista cuentaVista = null;

            while (true) {
                Menu.menuConsultasUsuario();
                System.out.print("Opción: ");
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion == 5) {
                        break;
                    }
                    if (opcion >= 1 && opcion <= 4) {
                        break;
                    } else {
                        Menu.mensajeOpcionInvalida();
                    }
                } else {
                    Menu.mensajeOpcionInvalida();
                    scanner.nextLine();
                }
            }

            if (opcion == 5) {
                break;
            }

            for (Cuenta cuenta : usuario.getListaCuenta()) {
                if (cuenta instanceof CuentaVista) {
                    cuentaVista = (CuentaVista) cuenta;
                    break;
                }
            }

            switch (opcion) {
                case 1:
                    cuentaVista.ingresarSaldo(validarIntSaldo(true));
                    break;
                case 2:
                    cuentaVista.retirarSaldo(validarIntSaldo(false));
                    break;
                case 3:
                    int tipoConversor = 0;
                    int saldo;
                    while (tipoConversor != 1 && tipoConversor != 2) {
                        try {
                            Menu.menuSeleccionarDivisa();
                            System.out.print("Opción: ");
                            tipoConversor = scanner.nextInt();

                            if (tipoConversor != 1 && tipoConversor != 2) {
                                Menu.mensajeOpcionInvalida();
                            }
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            Menu.mensajeOpcionInvalida();
                        }
                    }

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

    private static int validarIntSaldo(boolean ingreso) {
        Scanner scanner = new Scanner(System.in);
        int monto;

        while (true) {
            System.out.print(ingreso ? "Ingrese Cantidad a Retirar: " : "Ingrese Cantidad a Ingresar: ");
            if (scanner.hasNextInt()) {
                monto = scanner.nextInt();
                return monto;
            } else {
                Menu.mensajeSaldoInvalido();
                scanner.nextLine();
            }
        }
    }
}
