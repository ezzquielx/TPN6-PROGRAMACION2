import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SistemaIoT {
    private List<Dispositivo> dispositivos = Arrays.asList(
            new SensorTemperatura("TEMP-01"),
            new CamaraSeguridad("CAM-01"),
            new AltavozInteligente("SPEAK-01")
    );
    private Scanner sc = new Scanner(System.in);

    public void ejecutar() {
        while (true) {
            System.out.println("\n1. Ver dispositivos\n2. Encender/Apagar\n3. Acción específica\n4. Ver historial\n0. Salir");
            System.out.print("Opción: ");

            switch (sc.nextLine()) {
                case "1": mostrarDispositivos(); break;
                case "2": gestionarDispositivo(); break;
                case "3": ejecutarAccion(); break;
                case "4": HistorialEstados.getInstance().mostrar(); break;
                case "0": return;
            }
        }
    }

    private void mostrarDispositivos() {
        for (int i = 0; i < dispositivos.size(); i++) {
            System.out.printf("%d. %s%n", i+1, dispositivos.get(i).obtenerEstado());
        }
    }

    private void gestionarDispositivo() {
        mostrarDispositivos();
        System.out.print("Dispositivo (1-3): ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        System.out.print("1=Encender 2=Apagar: ");
        if (sc.nextLine().equals("1")) dispositivos.get(idx).encender();
        else dispositivos.get(idx).apagar();
    }

    private void ejecutarAccion() {
        mostrarDispositivos();
        System.out.print("Dispositivo (1-3): ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        dispositivos.get(idx).realizarAccionEspecifica();
    }

    public static void main(String[] args) {
        new SistemaIoT().ejecutar();
    }
}