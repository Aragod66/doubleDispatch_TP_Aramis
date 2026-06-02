package compras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarritoComprasTest {

    @Test
    public void testClienteRegular() {
        var cliente = new ClienteRegular("Jose");
        var producto1 = new ServicioDigital("Hosting", 100, 0.10f);
        var producto2 = new ProductoFisico("Libro", 100, 15);
        var carrito = new CarritoCompras(cliente);
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        assertEquals(1731.0F, carrito.calcularPrecio());
    }

    @Test
    public void testClienteCorportivo() {
        var cliente = new ClienteCorporativo("Jose");
        var producto1 = new ServicioDigital("Hosting", 100, 0.10f);
        var producto2 = new ProductoFisico("Libro", 100, 15);
        var carrito = new CarritoCompras(cliente);
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        assertEquals(971.0F, carrito.calcularPrecio());
    }
}
