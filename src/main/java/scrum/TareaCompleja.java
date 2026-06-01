package scrum;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaCompleja implements ItemDeProyecto {
    private List<ItemDeProyecto> items;
    private int horasEstimadas;


    public TareaCompleja(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemDeProyecto item) {
        //Una historia de usuario solo puede tener tareas de desarrollo
        //Una Epica solo puede tener Spikes
//        if (this.tipoTarea.equals(TipoTarea.HISTORIA_USUARIO)
//                && !item.tipoTarea().equals(TipoTarea.TAREA_DESARROLLO)) {
//            throw new RuntimeException(VALIDA_HISTORIA);
//        }
//        if (this.tipoTarea.equals(TipoTarea.EPICA)
//                && !item.tipoTarea().equals(TipoTarea.SPIKE)) {
//            throw new RuntimeException(VALIDA_EPICA);
//        }
        this.puedeAgregar(item);
        this.items.add(item);
    }


    @Override
    public int horasTotales() {
        int horasTotales = this.horasEstimadas;
        for (ItemDeProyecto item : items) {
            horasTotales += item.horasTotales();
        }
        return horasTotales;
    }


}
