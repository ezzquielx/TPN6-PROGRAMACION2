public interface Dispositivo {
    void encender();
    void apagar();
    String obtenerEstado();
    String getId();
    void realizarAccionEspecifica();
}