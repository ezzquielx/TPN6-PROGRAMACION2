public abstract class DispositivoBase implements Dispositivo {
    protected String id, tipo;
    protected boolean encendido = false;

    public DispositivoBase(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        HistorialEstados.getInstance().registrar(id, "APAGADO");
    }

    @Override
    public void encender() {
        encendido = true;
        HistorialEstados.getInstance().registrar(id, "ENCENDIDO");
        System.out.println(tipo + " " + id + " encendido");
    }

    @Override
    public void apagar() {
        encendido = false;
        HistorialEstados.getInstance().registrar(id, "APAGADO");
        System.out.println(tipo + " " + id + " apagado");
    }

    @Override
    public String obtenerEstado() {
        return tipo + " [" + id + "] - " + (encendido ? "ON" : "OFF");
    }

    @Override
    public String getId() { return id; }

    @Override
    public abstract void realizarAccionEspecifica();
}