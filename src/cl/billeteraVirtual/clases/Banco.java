package cl.billeteraVirtual.clases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Banco {

    // 1 - Variables
    private String nombre = "Wallet Bank";
    private List<Usuario> listaUsuarios = new ArrayList<>();

    // 2 - Constructores
    public Banco() {
    }

    public Banco(String nombre, List<Usuario> listaUsuarios) {
        this.nombre = nombre;
        this.listaUsuarios = listaUsuarios;
    }

    // 3 - Métodos de Acceso
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


    // 5 - Métodos adicionales
    public void sistemaBanco() {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        int opcion;
        while (true) {
            menu.menuInicio();
            System.out.print("Respuesta: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    for (Usuario usuario : getListaUsuarios()) {
                        System.out.println(usuario);
                    }

                    String correoIngreso, contrasena;
                    System.out.print("Ingrese Correo: ");
                    correoIngreso = scanner.nextLine();
                    System.out.print("Ingrese Contraseña: ");
                    contrasena = scanner.nextLine();

                    boolean encontrado = false;

                    for (Usuario usuario : getListaUsuarios()) {
                        if (usuario.getCorreo().equalsIgnoreCase(correoIngreso) && usuario.getContrasena().equals(contrasena)) {
                            System.out.println("Conexión Éxitosa");
                            encontrado = true;
                            sistemaUsuario(usuario, menu, scanner);
                        }
                    }
                    break;
                case 2:
                    menu.menuRegistrar();
                    Usuario usuario = registroUsuario();
                    agregarUsuarioLista(usuario);
                    scanner.nextLine();
                    sistemaIngresarSaldoRegistro(scanner, usuario, menu);
                    break;
                default:
                    scanner.close();
                    break;
            }
            if (opcion == 3) {
                menu.mensajeDespedida();
                break;
            }
            if (!menu.menuOtraOperacion()) {
                break;
            }
        }
    }

    public void sistemaUsuario(Usuario usuario, Menu menu, Scanner scanner) {
        int opcion;

        while (true) {
            menu.menuConsultasUsuario();
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            int tipoDivisa;
            String moneda = "";

            switch (opcion) {
                case 1:
                    menu.menuSeleccioneDivisa();
                    while (true) {
                        try {
                            System.out.print("Respuesta: ");
                            if (!scanner.hasNextInt()) {
                                System.out.println("Por favor, ingrese un número entero");
                                scanner.nextLine();
                                scanner.nextLine();
                                continue;
                            }
                            tipoDivisa = scanner.nextInt();
                            scanner.nextLine();
                            if (tipoDivisa < 1 || tipoDivisa > 5) {
                                System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 4");
                                continue;
                            }
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    switch (tipoDivisa) {
                        case 1:
                            moneda = "Peso";
                            usuario.ingresarSaldo(moneda, scanner);
                            break;
                        case 2:
                            moneda = "Dólar";
                            usuario.ingresarSaldo(moneda, scanner);
                            break;
                        case 3:
                            moneda = "Euro";
                            usuario.ingresarSaldo(moneda, scanner);
                            break;
                        case 4:
                            moneda = "Yen";
                            usuario.ingresarSaldo(moneda, scanner);
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }

                    break;
                case 2:
                    menu.menuSeleccioneDivisa();
                    while (true) {
                        try {
                            System.out.print("Respuesta: ");

                            if (!scanner.hasNextInt()) {
                                System.out.println("Por favor, ingrese un número entero.");
                                scanner.nextLine();
                                continue;
                            }
                            tipoDivisa = scanner.nextInt();
                            if (tipoDivisa < 1 || tipoDivisa > 5) {
                                System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 4.");
                                continue;
                            }
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    switch (tipoDivisa) {
                        case 1:
                            moneda = "Peso";
                            usuario.retirarSaldo(moneda, scanner);
                            break;
                        case 2:
                            moneda = "Dólar";
                            usuario.retirarSaldo(moneda, scanner);
                            break;
                        case 3:
                            moneda = "Euro";
                            usuario.retirarSaldo(moneda, scanner);
                            break;
                        case 4:
                            moneda = "Yen";
                            usuario.retirarSaldo(moneda, scanner);
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                    break;
                case 3:
                    menu.menuSeleccioneDivisa();
                    System.out.print("Ingrese opción:");
                    int tipoSaldo = scanner.nextInt();
                    scanner.nextLine();

                    String monedaOrigen = "";
                    switch (tipoSaldo) {
                        case 1:
                            monedaOrigen = "Peso";
                            break;
                        case 2:
                            monedaOrigen = "Dolar";
                            break;
                        case 3:
                            monedaOrigen = "Euro";
                            break;
                        case 4:
                            monedaOrigen = "Yen";
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
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

                        Divisa divisa = new Divisa();
                        double montoConvertido = divisa.cambioDivisa(cantidadACambiar, monedaOrigen, monedaDestino);

                        if (montoConvertido > 0) {
                            for (Billetera billetera : usuario.getBilleteras()) {
                                if (billetera.getMoneda().equalsIgnoreCase(monedaOrigen)) {
                                    billetera.retiroSaldo(cantidadACambiar);
                                    break;
                                }
                            }

                            boolean billeteraEncontrada = false;
                            for (Billetera billetera : usuario.getBilleteras()) {
                                if (billetera.getMoneda().equalsIgnoreCase(monedaDestino)) {
                                    billetera.ingresoSaldo(montoConvertido);
                                    billeteraEncontrada = true;
                                    break;
                                }
                            }
                            if (!billeteraEncontrada) {
                                Billetera nuevaBilletera = new Billetera(usuario.getRut(), monedaDestino, montoConvertido);
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
                    scanner.close();
                    break;
            }
            if (opcion == 5) {
                menu.mensajeDespedida();
                break;
            }
        }
    }

//    public void sistemaRetirarSaldo(Usuario usuario, String moneda, Scanner scanner) {
//        System.out.printf("|    %s     |\n", moneda);
//        System.out.println("============================");
//        System.out.println("Saldo a ingresar: ");
//        double saldo = scanner.nextDouble();
//        boolean billeteraEncontrada = false;
//        for (Billetera billetera : usuario.getBilleteras()) {
//            if (billetera.getMoneda().equalsIgnoreCase(moneda)) {
//                billetera.retiroSaldo(saldo);
//            }
//        }
//        if (!billeteraEncontrada) {
//            System.out.println("No dispones de este tipo de moneda");
//        }
//    }

//    public void sistemaIngresarSaldo(Usuario usuario, String moneda, Scanner scanner) {
//
//        System.out.printf("|    %s     |\n", moneda);
//        System.out.println("============================");
//        System.out.println("Saldo a ingresar: ");
//        double saldo = scanner.nextDouble();
//        boolean billeteraEncontrada = false;
//        for (Billetera billetera : usuario.getBilleteras()) {
//            if (billetera.getMoneda().equalsIgnoreCase(moneda)) {
//                billetera.ingresoSaldo(saldo);
//            }
//        }
//        if (!billeteraEncontrada) {
//            Billetera nuevabilletera = new Billetera(usuario.getRut(), moneda, saldo);
//            usuario.agregarBilletera(nuevabilletera);
//        }
//    }

    public void sistemaIngresarSaldoRegistro(Scanner scanner, Usuario usuario, Menu menu) {
        String saldoInicial = "";
        do {
            // REVISAR SI REALMENTE NECESITO EL TRY CATCH
            try {
                menu.menuIngresarSaldoRegistro();
                System.out.print("Respuesta: ");
                saldoInicial = scanner.nextLine();

                if (!saldoInicial.equalsIgnoreCase("n") && !saldoInicial.equalsIgnoreCase("s")) {
                    menu.mensajeResponderSN();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (!saldoInicial.equalsIgnoreCase("n") && !saldoInicial.equalsIgnoreCase("s"));

        if (saldoInicial.equalsIgnoreCase("s")) {
            double saldo;
            int tipoSaldo = 0;
            String tipo;

            while (true) {

                do {
                    // REVISAR SI REALMENTE NECESITO EL TRY CATCH
                    try {
                        menu.menuSeleccioneDivisa();
                        System.out.print("Respuesta: ");
                        while (!scanner.hasNextLine()) {
                            menu.mensajeIngresoRegistroSaldoInvalido();
                            System.out.print("Respuesta: ");
                            scanner.nextLine();
                        }
                        tipoSaldo = scanner.nextInt();

                        if (tipoSaldo < 1 || tipoSaldo > 4) {
                            menu.mensajeIngresoRegistroSaldoInvalido();
                            System.out.print("Respuesta: ");
                        }

                    } catch (InputMismatchException e) {
                        menu.mensajeIngresoRegistroSaldoInvalido();
                        scanner.nextLine();
                    }

                } while (tipoSaldo < 1 || tipoSaldo > 4);

                switch (tipoSaldo) {
                    case 1:
                        tipo = "Peso";
                        break;
                    case 2:
                        tipo = "Dolar";
                        break;
                    case 3:
                        tipo = "Euro";
                        break;
                    case 4:
                        tipo = "Yen";
                        break;
                    default:
                        menu.mensajeOpcionInvalida();
                        continue;
                }
                System.out.println("Ingrese Cantidad: ");
                while (!scanner.hasNextDouble()) {
                    menu.mensajeSaldoInvalido();
                    System.out.print("Ingrese Cantidad: \n");
                    scanner.nextLine();
                    scanner.nextLine();
                }
                saldo = scanner.nextDouble();
                menu.mensajeIngresoRegistroSaldoExitoso(tipoSaldo, saldo);

                Billetera billetera = new Billetera(usuario.getRut(), tipo, saldo);
                usuario.agregarBilletera(billetera);
                scanner.nextLine();
                break;
            }
        }
    }

//    public void sistemaAgregarUsuario() {
//
//    }

    public void agregarUsuarioLista(Usuario usuario) {

        listaUsuarios.add(usuario);
    }

    public Usuario registroUsuario() {

        Scanner scanner = new Scanner(System.in);

        String nombre, apellido, rut, correo, contrasena, vContrasena;
        Menu menu = new Menu();


        System.out.print("Ingrese Nombre: ");
        nombre = scanner.nextLine();
        System.out.print("Ingrese Apellido: ");
        apellido = scanner.nextLine();

        while (true) {
            System.out.print("Ingrese Rut: ");
            rut = scanner.nextLine();
            if (validarRut(rut)) {
                rut = formatearRut(rut);
                break;
            } else {
                menu.mensajeRutInvalido();
            }
        }

        while (true) {
            System.out.print("Ingrese Correo: ");
            correo = scanner.nextLine();
            if (validarCorreo(correo)) {
                break;
            } else {
                menu.mensajeCorreoInvalido();
            }
        }

        while (true) {
            System.out.print("Ingrese Contraseña: ");
            contrasena = scanner.nextLine();
            System.out.print("Ingrese Contraseña nuevamente: ");
            vContrasena = scanner.nextLine();
            if (contrasena.equals(vContrasena)) {
                break;
            } else {
                menu.mensajeContraseñaInvalida();
            }
        }


        return new Usuario(nombre, apellido, rut, correo, contrasena);
    }

    public boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return validacion;
    }

    /**
     * @param rut Se rescata el Rut ingresado por el usuario.
     * @return rut completo formateado con puntos y guíon.
     */
    public String formatearRut(String rut) {
        int cont = 0;
        StringBuilder format;
        if (rut.isEmpty()) {
            return "";
        } else {
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            format = new StringBuilder(("-" + rut.substring(rut.length() - 1)));
            for (int i = rut.length() - 2; i >= 0; i--) {
                format.insert(0, rut.charAt(i));
                cont++;
                if (cont == 3 && i != 0) {
                    format.insert(0, ".");
                    cont = 0;
                }
            }
            return format.toString();
        }
    }

    public boolean validarCorreo(String correo) {
        // Expresión regular simple para validar un correo electrónico
        String regex = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
        return correo.matches(regex);
    }
}
