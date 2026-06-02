package compras;

public class ProductoFisico implements Producto {
    private float precio;
    private float iva;
    private String nombre;
    private int peso;

    public ProductoFisico(String nombre, float precio, int peso) {
        this.precio = precio;
        this.nombre = nombre;
        this.peso = peso;
        this.iva = 0.21f;
    }

    @Override
    public float precio() {
        return precio;
    }

    @Override
    public float costoEnvio(Cliente cliente) {
        var costo = this.precio * peso;
//        if (tipo.equals(TipoCliente.CORPORATIVO)) {
//            return costo - (costo * 0.5f);
//        }
        return costo * cliente.factorEnvioFisico(this);
    }

    @Override
    public float impuesto(Cliente cliente) {
        return this.precio * iva;
    }
}
