package scrum;

public class TareaDesarrollo extends Tarea{
    public TareaDesarrollo(int horasEstimadas) {
        super(horasEstimadas);
    }


    @Override
    public void puedeAgregar(ItemDeProyecto item) {
        throw new RuntimeException(VALIDA_AGREGAR_SIMPLE);
    }

    @Override
    public void aceptarAddTarea(TareaEpica tarea) {
            throw new RuntimeException(VALIDA_EPICA);
    }


    @Override
    public void aceptarAddTarea(HistoriaDeUsuario tarea) {
        //correcto
    }


}
