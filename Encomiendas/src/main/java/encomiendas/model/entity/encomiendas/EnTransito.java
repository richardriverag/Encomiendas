package encomiendas.model.entity.encomiendas;

public class EnTransito implements Estado{
    @Override
    public void siguiente(Encomienda encomienda) {
        if(encomienda.getTipoEntrega().equals("A")){
            encomienda.setEstado(new EnBodegaD());
        }else {
            encomienda.setEstado(new Entregado());
        }
    }

    @Override
    public String ConsultarEstado() {
        return "La encomienda está en tránsito.";
    }
    
    @Override
    public String nombreEstado() {
        return "En transito";
    }

}
