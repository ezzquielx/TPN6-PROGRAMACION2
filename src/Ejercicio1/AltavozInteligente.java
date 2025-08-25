import java.util.Random;

public class AltavozInteligente extends DispositivoBase {
    private String[] canciones = {"Jazz", "Rock", "Pop", "Clásica"};
    private Random random = new Random();

    public AltavozInteligente(String id) {
        super(id, "Altavoz");
    }

    @Override
    public void realizarAccionEspecifica() {
        if (!encendido) {
            System.out.println("Altavoz apagado");
            return;
        }
        String cancion = canciones[random.nextInt(canciones.length)];
        HistorialEstados.getInstance().registrar(id, "Reproduciendo: " + cancion);
        System.out.println(id + " - Reproduciendo: " + cancion);
    }
}