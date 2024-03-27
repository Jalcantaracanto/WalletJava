package cl.billeteraVirtual.clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class UsuarioTest {

    private CuentaVista cuentaVista, cuentaVista2;
    private Usuario usuarioTest, usuarioTest2;

    @BeforeEach
    void setUp() {
        usuarioTest = new Usuario(01, "Javier", "Alcántara", "18.298.640-2", "javier.alcantara.canto@gmail.com", "12345");
        cuentaVista = new CuentaVista(01, usuarioTest, 1000, 01, "Cuenta Vista");
        usuarioTest.agregarCuenta(cuentaVista);
    }


    @Test
    void getListaCuenta() {
        assertEquals(1, usuarioTest.getListaCuenta().size());
    }

    @Test
    void getCorreo() {
        assertEquals("javier.alcantara.canto@gmail.com", usuarioTest.getCorreo());
    }

    @Test
    void getContrasena() {
        assertEquals("12345", usuarioTest.getContrasena());
    }

    @Test
    void crearUsuario() {
        String input = "javier\nAlcántara\n18298640-2\njavier@gmail.com\n12345\n12345\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Usuario usuariotesting = usuarioTest.crearUsuario();
        assertNotNull(usuariotesting);
    }

    @Test
    void agregarCuenta() {
        usuarioTest2 = new Usuario(01, "Javier", "Alcántara", "18.298.640-2", "javier.alcantara.canto@gmail.com", "12345");
        cuentaVista2 = new CuentaVista(01, usuarioTest, 1000, 01, "Cuenta Vista");
        usuarioTest2.agregarCuenta(cuentaVista2);

        assertEquals(1, usuarioTest2.getListaCuenta().size());
    }

    @Test
    void validarRut() {
        boolean isValid = usuarioTest.validarRut("18.298.640-2");
        assertEquals(true, isValid);
    }

    @Test
    void validarRut_RutInvalido() {
        boolean isValid = usuarioTest.validarRut("62178");
        assertEquals(false, isValid);
    }


    @Test
    void formatearRut_CasoBase() {
        // Arrange
        String rutSinFormato = "123456789";

        // Act
        String rutFormateado = usuarioTest.formatearRut(rutSinFormato);

        // Assert
        assertEquals("12.345.678-9", rutFormateado);
    }

    @Test
    void formatearRut_RutConFormato() {
        // Arrange
        String rutSinFormato = "12.345.678-9";

        // Act
        String rutFormateado = usuarioTest.formatearRut(rutSinFormato);

        // Assert
        assertEquals("12.345.678-9", rutFormateado);
    }

    @Test
    void validarCorreo() {

        boolean isValid = usuarioTest.validarCorreo("javier.alcantara.canto@gmail.com");
        assertEquals(true, isValid);
    }

    @Test
    void validarCorreo_CorreoInvalido() {
        boolean isValid = usuarioTest.validarCorreo("javier.alcantara.canto@gmail");
        assertEquals(false, isValid);
    }
}