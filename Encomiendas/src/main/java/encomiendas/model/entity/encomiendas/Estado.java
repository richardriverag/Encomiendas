package encomiendas.model.entity.encomiendas;

import java.time.LocalDateTime;

public interface Estado {
    void siguiente(Encomienda encomienda);
    String ConsultarEstado();
}
