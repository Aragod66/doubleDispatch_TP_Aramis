package laserX;

public interface Empleado {
    public static final String VALIDA_REGULAR = "Los empleados regulares no pueden tener empleados";
    public void puedeEmplear(Empleado empleado);
    public void aceptarComoJefe(EmpleadoJerarquico jefe);
    public void aceptarComoJefe(EmpleadoRegular jefe);
    float calcularSalario();

    Cargo cargo();
}
