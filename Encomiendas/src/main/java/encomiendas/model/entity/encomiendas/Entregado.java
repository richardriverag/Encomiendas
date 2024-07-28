package encomiendas.model.entity.encomiendas;

import java.time.LocalDateTime;

public class Entregado implements Estado {

    @Override
    public void siguiente(Encomienda encomienda) {

    }

    @Override
    public String ConsultarEstado() {
        return "La encomienda ha sido entregada";
    }

}
