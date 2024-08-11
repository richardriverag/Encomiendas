package encomiendas.model.entity.encomiendas;

public class EnBodegaO implements Estado {

    public void siguiente(Encomienda encomienda) {
        encomienda.setEstado(new Recolectado());
    }

    @Override
    public String ConsultarEstado() {
        return "La encomienda está en la bodega de origen.";
    }

    @Override
    public String nombreEstado() {
        return "En bodega origen";
    }

}
