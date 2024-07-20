package encomiendas.model.entity.encomiendas;

public enum ESTADOS_ENCOMIENDA {
    EN_BODEGA,
    EN_TRANSITO,
    RECOLECTADO,
    ENTREGADO;

    public ESTADOS_ENCOMIENDA siguienteEstadoD() {
        switch (this) {
            case EN_BODEGA:
                return EN_TRANSITO;
            case EN_TRANSITO:
                return RECOLECTADO;
            case RECOLECTADO:
                return ENTREGADO;
            default:
                throw new IllegalStateException("No hay estado siguiente para: " + this);
        }
    }
    public ESTADOS_ENCOMIENDA siguienteEstadoA() {
        switch (this) {
            case EN_BODEGA:
                return EN_TRANSITO;
            case EN_TRANSITO:
                return RECOLECTADO;
            default:
                throw new IllegalStateException("No hay estado siguiente para: " + this);
        }
    }
}
