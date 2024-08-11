package encomiendas.model.entity.encomiendas;

public class Recolectado implements Estado {

    @Override
    public void siguiente(Encomienda encomienda) {

    }

    @Override
    public String ConsultarEstado() {
        return "La encomienda ha sido recolectada.";
    }

    @Override
    public String nombreEstado() {
        return "Recolectado";
    }

    
}
