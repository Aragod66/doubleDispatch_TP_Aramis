package laserX;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoJerarquico implements Empleado {
    public static final String VALIDA_MANDOMEDIO = "Como mando medio solo juniors pueden estar a mi cargo";
    public static final String VALIDA_EMPLADO_JERARQUICO = "Solo directores o mandos medios son empleados jerarquicos";
    private final String nombre;
    private List<Empleado> empleados;
    private float salario;
    private Cargo cargo;

    public EmpleadoJerarquico(String nombre, float salario, Cargo cargo) {
        if (!cargo.equals(Cargo.DIRECTOR) && !cargo.equals(Cargo.MANDOMEDIO)) {
            throw new RuntimeException(VALIDA_EMPLADO_JERARQUICO);
        }
        this.nombre = nombre;
        this.salario = salario;
        this.cargo = cargo;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
//        if (this.puedeEmplear(empleado)) {
//            throw new RuntimeException(VALIDA_DIRECTOR);
//        }
//        if (cargo.equals(Cargo.MANDOMEDIO) && !empleado.cargo().equals(Cargo.JUNIOR)) {
//            throw new RuntimeException(VALIDA_MANDOMEDIO);
//        }
        this.puedeEmplear(empleado);
        this.empleados.add(empleado);
    }

    @Override
    public void puedeEmplear(Empleado empleado) {
        empleado.aceptarComoJefe(this);
    }

    @Override
    public void aceptarComoJefe(EmpleadoJerarquico empleador) {
        if(empleador.cargo().equals(Cargo.MANDOMEDIO)){
            throw new RuntimeException(VALIDA_MANDOMEDIO);
        };
    }

    @Override
    public void aceptarComoJefe(EmpleadoRegular empleadoRegular) {
        throw new RuntimeException(VALIDA_REGULAR);
    }

    @Override
    public float calcularSalario() {
        float total = this.salario;
        for (Empleado m : empleados) {
            total += m.calcularSalario();
        }
        return total;
    }

    @Override
    public Cargo cargo() {
        return this.cargo;
    }
}
