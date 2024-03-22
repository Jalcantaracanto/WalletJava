package cl.billeteraVirtual.clases;

import java.util.*;

public class Banco {
    private String nombre;
    private List<Usuario> listaUsuarios = new ArrayList<>();


    public Banco() {
        this.listaUsuarios = new ArrayList<>();
    }


    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }


    //Métodos custom
    public void agregarUsuario(Usuario usuario) {
        this.listaUsuarios.add(usuario);
    }

    public void buscarUsuario() {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
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
                    continuar = Menu.mensajeConexionFallida();
                }
            }
        } while (continuar);
    }

}

