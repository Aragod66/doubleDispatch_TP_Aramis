package compras;

public class ClienteRegular extends Cliente{
    public ClienteRegular(String nombre) {
        super(nombre);
    }

    @Override
    public float factorEnvioFisico(ProductoFisico productoFisico) {
        return 1;
    }

    @Override
    public float factorImpuestoDigital(ServicioDigital servicioDigital) {
        return 0.1f;
    }
}
