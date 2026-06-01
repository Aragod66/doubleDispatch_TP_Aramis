package laserX;

import java.util.ArrayList;
import java.util.List;

public abstract class EmpleadoJerarquico implements Empleado {
    private final String nombre;
    private List<Empleado> empleados;
    private float salario;

    public EmpleadoJerarquico(String nombre, float salario){
        this.nombre = nombre;
        this.salario = salario;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        this.puedeEmplear(empleado);
        this.empleados.add(empleado);
    }

    @Override
    public float calcularSalario() {
        float total = this.salario;
        for (Empleado m : empleados) {
            total += m.calcularSalario();
        }
        return total;
    }

}
