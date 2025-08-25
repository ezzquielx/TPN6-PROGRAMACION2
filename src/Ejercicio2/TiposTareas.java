 class TareaDesarrollo extends TareaBase {

    public TareaDesarrollo(String id, String responsable, int fechaInicio, int fechaFin) {
        super(id, responsable, fechaInicio, fechaFin);
    }

    @Override
    public void actualizarProgreso() {
        if (!iniciada) {
            System.out.println("Tarea no iniciada");
            return;
        }
        diaActual++;
        long tiempoInvertido = calcularTiempoInvertido();
        InformeProgreso.getInstance().registrarProgreso(id, "Desarrollando - " + tiempoInvertido + " días trabajados");
        System.out.println(id + " - Progreso de desarrollo: " + tiempoInvertido + " días");
    }
}

class TareaTesting extends TareaBase {

    public TareaTesting(String id, String responsable, int fechaInicio, int fechaFin) {
        super(id, responsable, fechaInicio, fechaFin);
    }

    @Override
    public void actualizarProgreso() {
        if (!iniciada) {
            System.out.println("Tarea no iniciada");
            return;
        }
        diaActual++;
        long tiempoInvertido = calcularTiempoInvertido();
        InformeProgreso.getInstance().registrarProgreso(id, "Testing - " + tiempoInvertido + " días trabajados");
        System.out.println(id + " - Progreso de testing: " + tiempoInvertido + " días");
    }
}

class TareaDocumentacion extends TareaBase {

    public TareaDocumentacion(String id, String responsable, int fechaInicio, int fechaFin) {
        super(id, responsable, fechaInicio, fechaFin);
    }

    @Override
    public void actualizarProgreso() {
        if (!iniciada) {
            System.out.println("Tarea no iniciada");
            return;
        }
        diaActual++;
        long tiempoInvertido = calcularTiempoInvertido();
        InformeProgreso.getInstance().registrarProgreso(id, "Documentando - " + tiempoInvertido + " días trabajados");
        System.out.println(id + " - Progreso de documentación: " + tiempoInvertido + " días");
    }
}