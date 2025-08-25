import java.util.HashMap;
import java.util.Map;

public class HistorialEstados {
    private static HistorialEstados instancia;
    private Map<String, String> estados = new HashMap<>();

    private HistorialEstados() {}

    public static HistorialEstados getInstance() {
        if (instancia == null) instancia = new HistorialEstados();
        return instancia;
    }

    public void registrar(String id, String estado) {
        estados.put(id, estado);
    }

    public void mostrar() {
        System.out.println("\n=== HISTORIAL ===");
        estados.forEach((id, estado) -> System.out.println(id + ": " + estado));
    }
}