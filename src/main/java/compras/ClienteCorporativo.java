package compras;

public class ClienteCorporativo extends Cliente{
    public ClienteCorporativo(String nombre) {
        super(nombre);
    }

    @Override
    public float factorEnvioFisico(ProductoFisico productoFisico) {
        return 0.5f;
    }

    @Override
    public float factorImpuestoDigital(ServicioDigital servicioDigital) {
        return 0;
    }
}
