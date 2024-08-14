package encomiendas.model.entity.transporte;

public class Camion extends Transporte {
    public Camion(int id, double capacidadCarga, String modelo, int anoFabricacion, double kilometraje, String tipo, ESTADO_TRANSPORTE estadoTransporte) {
        super(id, capacidadCarga, modelo, anoFabricacion, kilometraje, tipo, estadoTransporte);
    }
}
