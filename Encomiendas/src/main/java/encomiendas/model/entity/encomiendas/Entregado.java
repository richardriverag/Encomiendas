package encomiendas.model.entity.encomiendas;

public class Entregado implements Estado {

    @Override
    public void siguiente(Encomienda encomienda) {

    }

    @Override
    public String ConsultarEstado() {
        return "La encomienda ha sido entregada";
    }
    
    @Override
    public String nombreEstado() {
        return "Entregado";
    }


}
