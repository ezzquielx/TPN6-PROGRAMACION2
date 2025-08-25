class InformeProgreso {
    private static InformeProgreso instancia;
    private String[] tareas = new String[10];
    private String[] progresos = new String[10];
    private int contador = 0;

    private InformeProgreso() {}

    public static InformeProgreso getInstance() {
        if (instancia == null) instancia = new InformeProgreso();
        return instancia;
    }

    public void registrarProgreso(String tareaId, String progreso) {
        for (int i = 0; i < contador; i++) {
            if (tareas[i].equals(tareaId)) {
                progresos[i] = progreso;
                return;
            }
        }
        tareas[contador] = tareaId;
        progresos[contador] = progreso;
        contador++;
    }

    public void generarInforme() {
        System.out.println("\n=== INFORME DE PROGRESO ===");
        for (int i = 0; i < contador; i++) {
            System.out.println(tareas[i] + ": " + progresos[i]);
        }
        System.out.println("===========================");
    }
}

// Clase abstracta
public abstract class TareaBase implements Tarea {
    protected String id, responsable;
    protected int fechaInicio, fechaFin; // Días desde el 1 de enero
    protected boolean iniciada = false, completada = false;
    protected int diaActual = 0;

    public TareaBase(String id, String responsable, int fechaInicio, int fechaFin) {
        this.id = id;
        this.responsable = responsable;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        InformeProgreso.getInstance().registrarProgreso(id, "Asignada a " + responsable);
    }

    @Override
    public void iniciar() {
        if (!iniciada) {
            iniciada = true;
            diaActual = fechaInicio;
            InformeProgreso.getInstance().registrarProgreso(id, "Iniciada el día " + fechaInicio);
            System.out.println("Tarea " + id + " iniciada por " + responsable);
        }
    }

    @Override
    public void completar() {
        if (iniciada && !completada) {
            completada = true;
            diaActual = fechaFin;
            InformeProgreso.getInstance().registrarProgreso(id, "Completada el día " + fechaFin);
            System.out.println("Tarea " + id + " completada");
        }
    }

    @Override
    public long calcularTiempoInvertido() {
        if (!iniciada) return 0;
        int diaFinal = completada ? fechaFin : diaActual;
        return diaFinal - fechaInicio + 1;
    }

    @Override
    public String obtenerEstado() {
        String estado = completada ? "COMPLETADA" : (iniciada ? "EN_PROGRESO" : "PENDIENTE");
        return id + " - " + estado + " (" + responsable + ") - " + calcularTiempoInvertido() + " días";
    }

    @Override
    public String getId() { return id; }

    @Override
    public abstract void actualizarProgreso();
}