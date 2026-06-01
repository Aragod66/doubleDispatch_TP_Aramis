package scrum;

public interface ItemDeProyecto {
    public static final String VALIDA_AGREGAR_SIMPLE = "No se pueden agregar items a una tarea simple";
    public static final String VALIDA_HISTORIA = "Solo tareas de desarrollo se permiten en una historia de usuario";
    public static final String VALIDA_EPICA = "Solo spikes se permiten en una epica";


    int horasTotales();
    public void puedeAgregar(ItemDeProyecto item);
    public void aceptarAddTarea(TareaEpica tarea);
    public void aceptarAddTarea(TareaDesarrollo tarea);
    public void aceptarAddTarea(HistoriaDeUsuario tarea);
    public void aceptarAddTarea(Spike tarea);

}
