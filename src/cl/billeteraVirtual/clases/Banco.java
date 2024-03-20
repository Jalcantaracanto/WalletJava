package cl.billeteraVirtual.clases;

import java.util.List;
import java.util.Scanner;

public class Banco {
    private String nombre;
    private List<Usuario> listaUsuarios;


    public Banco(String nombre, List<Usuario> listaUsuarios) {
        this.nombre = nombre;
        this.listaUsuarios = listaUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    //Métodos custom

    public void sistemaBanco() {
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
                    buscarUsuario(scanner);
                    break;
                case 2:
                    Menu.menuRegistrar();
                    Usuario usuario = new Usuario();
                    usuario = usuario.crearUsuario();
                    sistemaIngresarSaldoRegistro(scanner, usuario, menu);
                    break;
            }
            if (opcion == 3) {
                Menu.mensajeDespedida();
                break;
            }
        }
    }

    public void sistemaUsuario() {
        int opcion;

        while (true) {
            Menu.menuConsultasUsuario();
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            int tipoDivisa = 0;
            String moneda = "";
            boolean ingreso = true;

            switch (opcion) {
                case 1:
                    Menu.menuSeleccioneDivisa();
                    operacionSaldoAUsuario(menu, scanner, moneda, tipoDivisa, usuario, true);
                    break;
                case 2:
                    Menu.menuSeleccioneDivisa();
                    ingreso = false;
                    operacionSaldoAUsuario(menu, scanner, moneda, tipoDivisa, usuario, false);
                    break;
                case 3:
                    Menu.menuSeleccioneDivisa();
                    System.out.print("Ingrese opción:");
                    int tipoSaldo = scanner.nextInt();
                    scanner.nextLine();


                    if (!monedaOrigen.isEmpty()) {
                        System.out.println("Seleccione moneda a cambiar");
                        menu.menuSeleccioneDivisa();

                        int tipoDivisaDestino;
                        do {
                            System.out.print("Respuesta: ");
                            while (!scanner.hasNextInt()) {
                                System.out.println("Por favor, ingrese un número entero.");
                                System.out.print("Respuesta: ");
                                scanner.nextLine();
                            }
                            tipoDivisaDestino = scanner.nextInt();
                            scanner.nextLine();

                            if (tipoDivisaDestino < 1 || tipoDivisaDestino > 4) {
                                System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 4.");
                            }
                        } while (tipoDivisaDestino < 1 || tipoDivisaDestino > 4);

                        String monedaDestino = "";
                        switch (tipoDivisaDestino) {
                            case 1:
                                monedaDestino = "Peso";
                                break;
                            case 2:
                                monedaDestino = "Dolar";
                                break;
                            case 3:
                                monedaDestino = "Euro";
                                break;
                            case 4:
                                monedaDestino = "Yen";
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }

                        double cantidadACambiar;
                        System.out.print("Ingrese la cantidad a cambiar: ");
                        cantidadACambiar = scanner.nextDouble();
                        scanner.nextLine();

                        double montoConvertido = divisa.cambioDivisa(cantidadACambiar, monedaOrigen, monedaDestino);

                        if (montoConvertido > 0) {
                            for (Billetera billetera : usuario.getBilleteras()) {
                                if (billetera.getMoneda().equalsIgnoreCase(monedaOrigen)) {
                                    billetera.restarSaldo(cantidadACambiar);
                                    break;
                                }
                            }

                            boolean billeteraEncontrada = false;
                            for (Billetera billetera : usuario.getBilleteras()) {
                                if (billetera.getMoneda().equalsIgnoreCase(monedaDestino)) {
                                    billetera.sumarSaldo(montoConvertido);
                                    billeteraEncontrada = true;
                                    break;
                                }
                            }
                            if (!billeteraEncontrada) {
                                Billetera nuevaBilletera = new Billetera(monedaDestino, montoConvertido);
                                usuario.agregarBilletera(nuevaBilletera);
                            }

                            System.out.println("Se ha realizado el cambio de divisa exitosamente.");
                            System.out.println("Monto cambiado: " + cantidadACambiar + " " + monedaOrigen);
                            System.out.println("Monto convertido: " + montoConvertido + " " + monedaDestino);
                        } else {
                            System.out.println("No se puede realizar el cambio de divisa debido a una tasa de cambio no válida.");
                        }

                        System.out.println("Se ha realizado el cambio de divisa exitosamente.");
                        System.out.println("Saldo actual en " + monedaOrigen + ": " + usuario.obtenerSaldo(monedaOrigen));
                        System.out.println("Saldo actual en " + monedaDestino + ": " + usuario.obtenerSaldo(monedaDestino));
                    }
                    break;
                case 4:
                    usuario.verSaldoDisponible();
                    break;
                default:
                    break;
            }
            if (opcion == 5) {
                break;
            }
        }
    }

    public void sistemaCreacionUsuario() {

    }

    public void sistemaConectarUsuario() {

    }

    public void agregarUsuario(Usuario usuario) {
        this.listaUsuarios.add(usuario);
    }

    private void buscarUsuario(Scanner scanner) {
        boolean encontrado = false;
        boolean continuar = false;

        String correoIngreso, contrasena;
        System.out.print("Ingrese Correo: ");
        correoIngreso = scanner.nextLine();
        System.out.print("Ingrese Contraseña: ");
        contrasena = scanner.nextLine();

        for (Usuario usuario : getListaUsuarios()) {
            if (usuario.getCorreo().equalsIgnoreCase(correoIngreso) && usuario.getContrasena().equals(contrasena)) {
                Menu.mensajeConexionExitosa();
                sistemaUsuario();
                encontrado = true;
                continuar = true;
                break;
            }
        }
    }

}
