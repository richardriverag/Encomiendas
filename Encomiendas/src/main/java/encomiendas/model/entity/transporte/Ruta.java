package encomiendas.model.entity.transporte;

import encomiendas.model.entity.usuarios.Agencia;

public class Ruta {
    private String id;
    private String descripcion;
    private Agencia agenciaSalida;
    private boolean esInterprovincial;

    public Ruta(String id, String descripcion, Agencia agenciaSalida, boolean esInterprovincial) {
        this.id = id;
        this.descripcion = descripcion;
        this.agenciaSalida = agenciaSalida;
        this.esInterprovincial = esInterprovincial;
    }

    // Getters y Setters
    
    // Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // agenciaSalida
    public Agencia getAgenciaSalida() {
        return agenciaSalida;
    }

    public void setAgenciaSalida(Agencia agenciaSalida) {
        this.agenciaSalida = agenciaSalida;
    }

    // esInterprovincial
    public boolean isEsInterprovincial() {
        return esInterprovincial;
    }

    // Setter for esInterprovincial
    public void setEsInterprovincial(boolean esInterprovincial) {
        this.esInterprovincial = esInterprovincial;
    }
}
