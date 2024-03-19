import cl.billeteraVirtual.clases.Banco;
import cl.billeteraVirtual.clases.Billetera;
import cl.billeteraVirtual.clases.Usuario;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Usuario usuario1 = new Usuario("Javier", "Alcántara", "18.298.640-2", "asd", "12345");
        banco.agregarUsuarioLista(usuario1);
        Billetera billetera1 = new Billetera( "Peso", 10000);
        usuario1.agregarBilletera(billetera1);

        banco.sistemaBanco();
    }
}