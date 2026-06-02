package compras;

public interface Producto {

    float precio();

    float costoEnvio(Cliente cliente);

    float impuesto(Cliente cliente);
}
