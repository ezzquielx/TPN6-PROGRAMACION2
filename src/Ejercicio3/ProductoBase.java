public abstract class ProductoBase implements Producto {
    protected String nombre;
    protected double precio;

    public ProductoBase(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public double calcularPrecio() {
        return precio;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        mostrarCaracteristicasEspecificas();
    }

    protected abstract void mostrarCaracteristicasEspecificas();
}