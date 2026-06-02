package scrum;

public class Spike extends Tarea{
    public Spike(int horasEstimadas) {
        super(horasEstimadas);
    }


    @Override
    public void puedeAgregar(ItemDeProyecto item) {
        throw new RuntimeException(VALIDA_AGREGAR_SIMPLE);
    }

    @Override
    public void aceptarAddTarea(TareaEpica tarea) {
        //correcto
    }


    @Override
    public void aceptarAddTarea(HistoriaDeUsuario tarea) {
        throw new RuntimeException(VALIDA_HISTORIA);
    }

}
