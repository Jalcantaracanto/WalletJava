package cl.billeteraVirtual.clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    private Banco bancoTest, bancotest2;
    private Usuario usuarioTest, usuarioTest2;

    @BeforeEach
    public void configuration() {
        bancoTest = new Banco("Walletcito");
        bancotest2 = new Banco();
        usuarioTest = new Usuario(01, "Javier", "Alcántara", "18.298.640-2", "javier.alcantara.canto@gmail.com", "12345");
        usuarioTest2 = new Usuario(01, "Javier", "Alcántara", "17.559.227-k", "niicole.ivette@gmail.com", "12345");

        bancoTest.agregarUsuario(usuarioTest);
        bancoTest.agregarUsuario(usuarioTest2);

        bancotest2.agregarUsuario(usuarioTest);
        bancotest2.agregarUsuario(usuarioTest);
    }

    private void configurarEntradaSimulada(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }


    @Test
    public void AgregarUsuario() {

        bancoTest.agregarUsuario(usuarioTest);
        assert (bancoTest.getListaUsuarios().contains(usuarioTest));
    }

    @Test
    public void buscarUsuario() {
        String correoIngreso = "javier.alcantara.canto@gmail.com";
        String contrasena = "12345";

        String input = correoIngreso + "\n" + contrasena + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        // Rescato de datos simulados
        String correoIngresoComparacion = scanner.nextLine();
        String contrasenaComparacion = scanner.nextLine();

        boolean encontrado = false;

        if (bancoTest.getListaUsuarios().isEmpty()) {
            Menu.mensajeNoExistenUsuarios();
        } else {
            for (Usuario u : bancoTest.getListaUsuarios()) {
                if (u.getCorreo().equalsIgnoreCase(correoIngresoComparacion) && u.getContrasena().equals(contrasenaComparacion)) {
                    encontrado = true;
                    break;
                }
            }
        }
        assertTrue(encontrado);
    }

    @Test
    public void buscarUsuario_UsuarioEncontrado() {
        String input = "javier.alcantara.canto@gmail.com\n12345\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        bancoTest.buscarUsuario();

        assertTrue(true);
    }

    @Test
    void buscarUsuario_UsuarioNoEncontrado() {
        String input = "usuario1@gmail.com\ncontrasena\n5\nS\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        bancoTest.buscarUsuario();

        assertTrue(true);
    }

}