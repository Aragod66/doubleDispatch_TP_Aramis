package laserX;

public interface Empleado {
    public static final String VALIDA_DIRECTOR = "Como director solo mandos medios pueden estar a mi cargo";
    public static final String VALIDA_MANDOMEDIO = "Como mando medio solo juniors pueden estar a mi cargo";
    public static final String VALIDA_REGULAR = "Los empleados regulares no pueden tener empleados";
    public void puedeEmplear(Empleado empleado);
    public void aceptarComoJefe(Director jefe);
    public void aceptarComoJefe(MandoMedio jefe);
    float calcularSalario();

}
