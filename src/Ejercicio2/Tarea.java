public interface Tarea {
    void iniciar();
    void completar();
    long calcularTiempoInvertido();
    String obtenerEstado();
    String getId();
    void actualizarProgreso();
}