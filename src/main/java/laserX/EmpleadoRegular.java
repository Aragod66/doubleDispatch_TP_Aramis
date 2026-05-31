package laserX;

public class EmpleadoRegular implements Empleado {
    public static final String VALIDA_DIRECTOR = "Como director solo mandos medios pueden estar a mi cargo";
    private final String nombre;
    private float salario;
    private Cargo cargo;

    public EmpleadoRegular(String nombre, float salario) {
        this.nombre = nombre;
        this.salario = salario;
        this.cargo = Cargo.JUNIOR;
    }

    public float salario() {
        return this.salario;
    }

    @Override
    public void puedeEmplear(Empleado empleado) {
        throw new RuntimeException(VALIDA_REGULAR);
    }

    @Override
    public void aceptarComoJefe(EmpleadoJerarquico jefe) {
        if(jefe.cargo().equals(Cargo.DIRECTOR)){
            throw new RuntimeException(VALIDA_DIRECTOR);
        };
    }

    @Override
    public void aceptarComoJefe(EmpleadoRegular jefe) {
        throw new RuntimeException(VALIDA_REGULAR);
    }

    @Override
    public float calcularSalario() {
        return this.salario;
    }

    @Override
    public Cargo cargo() {
        return this.cargo;
    }
}
