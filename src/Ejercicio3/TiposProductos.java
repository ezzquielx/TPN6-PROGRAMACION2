class ProductoAlimenticio extends ProductoBase {
    private int diasParaVencer;

    public ProductoAlimenticio(String nombre, double precio, int diasParaVencer) {
        super(nombre, precio);
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    protected void mostrarCaracteristicasEspecificas() {
        System.out.println("Tipo: Producto Alimenticio");
        System.out.println("Días para vencer: " + diasParaVencer);
    }

    public void verificarProximoVencimiento() {
        if (diasParaVencer <= 5) {
            System.out.println("Cuidado!️ " + nombre + " está próximo a vencer!");
        } else {
            System.out.println("Ok! 3" + nombre + " no está próximo a vencer");
        }
    }
}

class ProductoElectronico extends ProductoBase {
    private String marca;

    public ProductoElectronico(String nombre, double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }

    @Override
    protected void mostrarCaracteristicasEspecificas() {
        System.out.println("Tipo: Producto Electrónico");
        System.out.println("Marca: " + marca);
    }
}

class ProductoRopa extends ProductoBase {
    private String marca;

    public ProductoRopa(String nombre, double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }

    @Override
    protected void mostrarCaracteristicasEspecificas() {
        System.out.println("Tipo: Producto de Ropa");
        System.out.println("Marca: " + marca);
    }
}