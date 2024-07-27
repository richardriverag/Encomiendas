package encomiendas.model.entity.encomiendas;

public class EnBodegaD implements Estado{
    public void siguiente(Encomienda encomienda) {
        encomienda.setEstado(new EnTransito());
    }

    @Override
    public String ConsultarEstado() {
        return "La encomienda está en la bodega del destino.";
    }
}
