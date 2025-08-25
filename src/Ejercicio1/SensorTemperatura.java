import java.util.Random;

public class SensorTemperatura extends DispositivoBase {
    private Random random = new Random();

    public SensorTemperatura(String id) {
        super(id, "Sensor");
    }

    @Override
    public void realizarAccionEspecifica() {
        if (!encendido) {
            System.out.println("Sensor apagado");
            return;
        }
        double temp = 15 + random.nextDouble() * 25;
        HistorialEstados.getInstance().registrar(id, "Temperatura: " + String.format("%.1f°C", temp));
        System.out.printf("%s - %.1f°C%n", id, temp);
    }
}