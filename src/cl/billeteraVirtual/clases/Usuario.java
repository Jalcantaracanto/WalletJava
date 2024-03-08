package cl.billeteraVirtual.clases;

public class Usuario {

    // 1 - Atributos
    //public / private / protected -> Modificadores de Acceso
    public String nombre, apellido, rut, correo, contrasena;

    //Constructores
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String rut, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    //Métodos de Acceso
    public String getNombre() {
        return nombre;
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
}
