package compras;

import java.util.List;

public abstract class Cliente {
    private List<Producto> compra;
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProducto(Producto producto) {
        this.compra.add(producto);
    }

    public List<Producto> compra() {
        return List.copyOf(compra);
    }

    public abstract float factorEnvioFisico(ProductoFisico productoFisico);
    public abstract float factorImpuestoDigital(ServicioDigital servicioDigital);


}
