import cl.billeteraVirtual.clases.*;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();

        UUID uuid = UUID.randomUUID();
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long id = mostSignificantBits ^ leastSignificantBits;
        long nroCuenta = uuid.getMostSignificantBits();


        Usuario usuario1 = new Usuario(id, "Javier", "Alcántara", "18.298.640-2", "asd", "12345");
        banco.agregarUsuario(usuario1);
        CuentaVista cuentaVista = new CuentaVista(id, usuario1, 10000, nroCuenta, "Cuenta Vista");
        usuario1.agregarCuenta(cuentaVista);

        SistemaBanco.sistemaBanco(banco);


    }
}
