package laserX;

public class MandoMedio extends EmpleadoJerarquico {

    public MandoMedio(String nombre, float salario) {
        super(nombre, salario);
    }

    @Override
    public void puedeEmplear(Empleado empleado) {
        empleado.aceptarComoJefe(this);
    }

    @Override
    public void aceptarComoJefe(Director jefe) {
        //correcto
    }

    @Override
    public void aceptarComoJefe(MandoMedio jefe) {
        throw new RuntimeException(VALIDA_MANDOMEDIO);
    }

    @Override
    public void aceptarComoJefe(EmpleadoRegular jefe) {
        throw new RuntimeException(VALIDA_REGULAR);
    }
}
