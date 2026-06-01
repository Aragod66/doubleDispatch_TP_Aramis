package scrum;

public abstract class Tarea implements ItemDeProyecto {
    private int horasEstimadas;

    public Tarea(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;

    }

    @Override
    public int horasTotales() {
        return this.horasEstimadas;
    }

}
