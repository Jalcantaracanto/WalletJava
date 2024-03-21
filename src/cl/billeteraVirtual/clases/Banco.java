package cl.billeteraVirtual.clases;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Banco {
    private String nombre;
    private List<Usuario> listaUsuarios;


    public Banco() {
    }

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
                    ingresarSaldoInicial(scanner, usuario);
                    break;
            }
            if (opcion == 3) {
                Menu.mensajeDespedida();
                break;
            }
        }
    }

    public void sistemaUsuario(Scanner scanner, Usuario usuario) {
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
    }

    public void sistemaCreacionUsuario() {

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
                //sistemaUsuario();
                encontrado = true;
                continuar = true;
                break;
            }
        }
    }

    public void ingresarSaldoInicial(Scanner scanner, Usuario usuario) {
        String saldoInicial = "";
        do {
            // AJUSTAR PARA HACER SOLO CON IF
            try {
                Menu.menuIngresarSaldoRegistro();
                System.out.print("Respuesta: ");
                saldoInicial = scanner.nextLine();

                if (!saldoInicial.equalsIgnoreCase("n") && !saldoInicial.equalsIgnoreCase("s")) {
                    Menu.mensajeResponderSN();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (!saldoInicial.equalsIgnoreCase("n") && !saldoInicial.equalsIgnoreCase("s"));

        if (saldoInicial.equalsIgnoreCase("s")) {
            int saldo;
            int tipoSaldo = 0;

            UUID uuid = UUID.randomUUID();
            long mostSignificantBits = uuid.getMostSignificantBits();
            long leastSignificantBits = uuid.getLeastSignificantBits();
            long idCuenta = mostSignificantBits ^ leastSignificantBits;
            long nroCuenta = uuid.getMostSignificantBits();

            System.out.println("Ingrese Cantidad: ");
            while (!scanner.hasNextDouble()) {
                Menu.mensajeSaldoInvalido();
                System.out.print("Ingrese Cantidad: \n");
                scanner.nextLine();
                scanner.nextLine();
            }
            saldo = scanner.nextInt();
            Menu.mensajeIngresoRegistroSaldoExitoso(saldo);
            CuentaVista cuentaVista = new CuentaVista(idCuenta, usuario, saldo, nroCuenta);
            scanner.nextLine();
        }
    }
}

