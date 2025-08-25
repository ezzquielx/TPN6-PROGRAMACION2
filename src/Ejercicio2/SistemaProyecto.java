import java.util.Scanner;

class SistemaProyecto {
    private Tarea[] tareas = {
            new TareaDesarrollo("DEV-01", "Juan", 1, 30),
            new TareaTesting("TEST-01", "Ana", 15, 45),
            new TareaDocumentacion("DOC-01", "Luis", 5, 35)
    };
    private Scanner sc = new Scanner(System.in);

    public void ejecutar() {
        while (true) {
            System.out.println("\n1. Ver tareas\n2. Iniciar tarea\n3. Completar tarea\n4. Actualizar progreso\n5. Generar informe\n0. Salir");
            System.out.print("Opción: ");

            String opcion = sc.nextLine();
            if (opcion.equals("1")) mostrarTareas();
            else if (opcion.equals("2")) iniciarTarea();
            else if (opcion.equals("3")) completarTarea();
            else if (opcion.equals("4")) actualizarProgreso();
            else if (opcion.equals("5")) InformeProgreso.getInstance().generarInforme();
            else if (opcion.equals("0")) return;
        }
    }

    private void mostrarTareas() {
        System.out.println("\n=== TAREAS DEL PROYECTO ===");
        for (int i = 0; i < tareas.length; i++) {
            System.out.println((i+1) + ". " + tareas[i].obtenerEstado());
        }
    }

    private void iniciarTarea() {
        mostrarTareas();
        System.out.print("Seleccionar tarea (1-3): ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        tareas[idx].iniciar();
    }

    private void completarTarea() {
        mostrarTareas();
        System.out.print("Seleccionar tarea (1-3): ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        tareas[idx].completar();
    }

    private void actualizarProgreso() {
        mostrarTareas();
        System.out.print("Seleccionar tarea (1-3): ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        tareas[idx].actualizarProgreso();
    }

    public static void main(String[] args) {
        new SistemaProyecto().ejecutar();
    }
}