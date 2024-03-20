package cl.billeteraVirtual.clases;

import java.util.List;

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

    }

    public void sistemaUsuario() {

    }

    public void sistemaCreacionUsuario() {

    }

    public void sistemaConectarUsuario() {

    }

    public void agregarUsuario() {

    }
}
