package cl.billeteraVirtual.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Banco {

    //Atributos
    private String nombre;


    //Constructores
    public Banco(String nombre) {
        this.nombre = nombre;
    }

    //Accesadores y mutadores
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public Banco() {
        this.listaUsuarios = new ArrayList<>();
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    //Métodos custom

    /**
     * Método que agrega un usuario a la lista de usuarios del banco.
     *
     * @param usuario Usuario entrante a agregar a la lista de usuarios
     * @author Javier Alcántara
     */
    public void agregarUsuario(Usuario usuario) {
        this.listaUsuarios.add(usuario);
    }

    /**
     * Método que busca un usuario en la lista de usuarios del banco
     * Solicita correo y contraseña para buscar al usuario
     * para así poder acceder al sistemaUsuario
     */
    public void buscarUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = false;
        boolean encontrado = false;
        do {
            String correoIngreso, contrasena;
            System.out.print("Ingrese Correo: ");
            correoIngreso = scanner.nextLine();
            System.out.print("Ingrese Contraseña: ");
            contrasena = scanner.nextLine();

            if (getListaUsuarios().size() == 0) {
                Menu.mensajeNoExistenUsuarios();
            } else {
                for (Usuario usuario : getListaUsuarios()) {
                    if (usuario.getCorreo().equalsIgnoreCase(correoIngreso) && usuario.getContrasena().equals(contrasena)) {
                        Menu.mensajeConexionExitosa();
                        SistemaBanco.sistemaUsuario(scanner, usuario);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    continuar = Menu.mensajeConexionFallida(scanner);
                }
            }
        } while (continuar);
    }

}

