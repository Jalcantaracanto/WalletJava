package cl.billeteraVirtual.clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CuentaVistaTest extends Cuenta {

    private CuentaVista cuentaVistaTest;
    private Usuario usuarioTest;

    @BeforeEach
    void setUp() {
        usuarioTest = new Usuario(01, "Javier", "Alcántara", "18.298.640-2", "javier.alcantara.canto@gmail.com", "12345");
        cuentaVistaTest = new CuentaVista(01, usuarioTest);

    }



    @Test
    void testCrearCuentaConNuevoSaldo() {
        int saldo = 10000;
        String input = saldo + "\n\n";

        Usuario userTest = new Usuario(123213, "UserTest", "ApellidoTest", "12345678-9", "test@gmail.com", "12345");
        CuentaVista cuentaVistaTest = new CuentaVista(0123, userTest, saldo, 01345, "Cuenta Vista");

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cuentaVistaTest.crearCuenta(true);
        userTest.agregarCuenta(cuentaVistaTest);

        assertEquals(10000, cuentaVistaTest.getSaldo());

    }

    @Test
    void testCrearCuentaSinNuevoSaldo() {
        Usuario userTest = new Usuario(123213, "UserTest", "ApellidoTest", "12345678-9", "test@gmail.com", "12345");
        CuentaVista cuentaVistaTest = new CuentaVista(0123, userTest, 0, 01345, "Cuenta Vista");

        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cuentaVistaTest.crearCuenta(false);
        userTest.agregarCuenta(cuentaVistaTest);

        assertEquals(0, cuentaVistaTest.getSaldo());

    }

    @Override
    public void crearCuenta(Boolean nuevoSaldo) {
        // You can leave this method empty if you don't want to implement any functionality
        // Or you can add your own implementation here
    }

}