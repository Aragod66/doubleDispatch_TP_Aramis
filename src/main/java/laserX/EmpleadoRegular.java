package laserX;

public class EmpleadoRegular implements Empleado {
    private final String nombre;
    private float salario;

    public EmpleadoRegular(String nombre, float salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public float salario() {
        return this.salario;
    }

    @Override
    public void puedeEmplear(Empleado empleado) {
        throw new RuntimeException(VALIDA_REGULAR);
    }

    @Override
    public void aceptarComoJefe(Director jefe) {
        throw new RuntimeException(VALIDA_DIRECTOR);
    }

    @Override
    public void aceptarComoJefe(MandoMedio jefe) {
        //correcto
    }


    @Override
    public float calcularSalario() {
        return this.salario;
    }

}
