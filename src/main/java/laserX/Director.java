package laserX;

public class Director extends EmpleadoJerarquico{
    public Director(String nombre, float salario) {
        super(nombre, salario);
    }

    @Override
    public void puedeEmplear(Empleado empleado) {
        empleado.aceptarComoJefe(this);
    }

    @Override
    public void aceptarComoJefe(Director jefe) {
        throw new RuntimeException(VALIDA_DIRECTOR);
    }

    @Override
    public void aceptarComoJefe(MandoMedio jefe) {
        throw new RuntimeException(VALIDA_MANDOMEDIO);
    }


}
