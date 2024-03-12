package cl.billeteraVirtual.clases;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    // 1 - Atributos

    //public / private / protected -> Modificadores de Acceso
    private String nombre, apellido, rut, correo, contrasena;
    private List<Billetera> billeteras;

    //Constructores-
    public Usuario() {
        this.billeteras = new ArrayList<>();
    }

    public Usuario(String nombre, String apellido, String rut, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
        this.billeteras = new ArrayList<>();
    }

    //Métodos de Acceso
    public String getNombre() {
        return nombre;
    }

    public List<Billetera> getBilleteras() {
        return billeteras;
    }

    public void setBilleteras(List<Billetera> billeteras) {
        this.billeteras = billeteras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    //    Métodos de compartimiento
    @Override
    public String toString() {
        return "cl.billeteraVirtual.clases.Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rut='" + rut + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contrasena + '\'' +
                '}';
    }

    // Métodos adicionales
    public void agregarBilletera(Billetera billetera) {
        billeteras.add(billetera);
    }

    public void eliminarBilletera(Billetera billetera) {
        billeteras.remove(billetera);
    }
}
