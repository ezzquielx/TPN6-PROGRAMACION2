import java.util.Random;

public class CamaraSeguridad extends DispositivoBase {
    private Random random = new Random();

    public CamaraSeguridad(String id) {
        super(id, "Cámara");
    }

    @Override
    public void realizarAccionEspecifica() {
        if (!encendido) {
            System.out.println("Cámara apagada");
            return;
        }
        if (random.nextBoolean()) {
            HistorialEstados.getInstance().registrar(id, "Movimiento detectado");
            System.out.println(id + " - ¡Movimiento detectado!");
        } else {
            HistorialEstados.getInstance().registrar(id, "Monitoreando");
            System.out.println(id + " - Monitoreando");
        }
    }
}