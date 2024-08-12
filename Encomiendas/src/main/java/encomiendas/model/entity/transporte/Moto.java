package encomiendas.model.entity.transporte;

public class Moto extends Transporte {
    public Moto(int id, double capacidadCarga, String modelo, int anoFabricacion, double kilometraje, String tipo, ESTADO_TRANSPORTE estadoTransporte) {
        super(id, capacidadCarga, modelo, anoFabricacion, kilometraje, tipo, estadoTransporte);
    }
}
