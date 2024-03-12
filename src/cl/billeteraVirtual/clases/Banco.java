package cl.billeteraVirtual.clases;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre = "Wallet Bank";
    private List<Usuario> listaUsuarios = new ArrayList<>();

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

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", Lista Usuarios=" + listaUsuarios +
                '}';
    }

    //Métodos adicionales

    /**
     * Método para ingresar usuario a Banco
     *
     * @param usuario
     */
    public void agregarUsuario(Usuario usuario) {

        listaUsuarios.add(usuario);
    }

    /**
     * Método para eliminar usuario de Banco
     *
     * @param usuario
     */
    public void eliminarUsuario(Usuario usuario) {

        listaUsuarios.remove(usuario);
    }

}
