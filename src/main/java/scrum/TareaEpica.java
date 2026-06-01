package scrum;

public class TareaEpica extends TareaCompleja{
    public TareaEpica(int horasEstimadas) {
        super(horasEstimadas);
    }


    @Override
    public void puedeAgregar(ItemDeProyecto item) {
        item.aceptarAddTarea(this);
    }

    @Override
    public void aceptarAddTarea(TareaEpica tarea) {
        throw new RuntimeException(VALIDA_EPICA);
    }

    @Override
    public void aceptarAddTarea(TareaDesarrollo tarea) {
        throw new RuntimeException(VALIDA_AGREGAR_SIMPLE);
    }

    @Override
    public void aceptarAddTarea(HistoriaDeUsuario tarea) {
        throw new RuntimeException(VALIDA_HISTORIA);
    }

    @Override
    public void aceptarAddTarea(Spike tarea) {
        throw new RuntimeException(VALIDA_AGREGAR_SIMPLE);
    }
}
