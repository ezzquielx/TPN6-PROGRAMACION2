import java.util.Scanner;

public class SistemaAlmacen {
    private Producto[] productos;
    private Scanner sc = new Scanner(System.in);

    public SistemaAlmacen() {
        productos = new Producto[] {
                // Alimenticios (nombre, precio, días para vencer)
                new ProductoAlimenticio("Leche", 2500, 2),
                new ProductoAlimenticio("Pan", 1200, 1),
                new ProductoAlimenticio("Yogur", 3000, 5),
                new ProductoAlimenticio("Queso", 4500, 8),

                // Electrónicos (nombre, precio, marca)
                new ProductoElectronico("Celular S24 Ultra", 200000, "Samsung"),
                new ProductoElectronico("Ipad I6", 150000, "Apple"),
                new ProductoElectronico("Audífonos", 50000, "Sony"),
                new ProductoElectronico("Laptop", 8000000, "HP"),

                // Ropa (nombre, precio, marca)
                new ProductoRopa("Camiseta", 15000, "Nike"),
                new ProductoRopa("Jeans", 45000, "Levi's"),
                new ProductoRopa("Zapatos", 75000, "Adidas"),
                new ProductoRopa("Camisa", 35000, "Polo"),
        };
    }

    public void ejecutar() {
        System.out.println("=== SISTEMA DE GESTIÓN DE ALMACÉN ===");

        while (true) {
            System.out.println("\n1. Ver productos");
            System.out.println("2. Mostrar detalles");
            System.out.println("3. Verificar vencimientos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            String opcion = sc.nextLine();
            if (opcion.equals("1")) mostrarProductos();
            else if (opcion.equals("2")) mostrarDetalles();
            else if (opcion.equals("3")) verificarVencimientos();
            else if (opcion.equals("0")) return;
        }
    }

    private void mostrarProductos() {
        System.out.println("\n=== PRODUCTOS EN ALMACÉN ===");
        for (int i = 0; i < productos.length; i++) {
            System.out.printf("%d. %s - $%.2f%n", i+1, productos[i].getNombre(), productos[i].calcularPrecio());
        }
    }

    private void mostrarDetalles() {
        mostrarProductos();
        System.out.print("Producto (1-" + productos.length + "): ");
        int indice = Integer.parseInt(sc.nextLine()) - 1;
        if (indice >= 0 && indice < productos.length) {
            System.out.println();
            productos[indice].mostrarDetalles();
        } else {
            System.out.println("Producto no válido");
        }
    }

    private void verificarVencimientos() {
        System.out.println("\n=== VERIFICACIÓN DE VENCIMIENTOS ===");
        boolean hayAlimenticios = false;

        for (Producto producto : productos) {
            if (producto instanceof ProductoAlimenticio) {
                ProductoAlimenticio alimenticio = (ProductoAlimenticio) producto;
                alimenticio.verificarProximoVencimiento();
                hayAlimenticios = true;
            }
        }

        if (!hayAlimenticios) {
            System.out.println("No hay productos alimenticios en el almacén");
        }
    }

    public static void main(String[] args) {
        new SistemaAlmacen().ejecutar();
    }
}