package encomiendas.model.entity.transporte;

import encomiendas.model.entity.usuarios.Agencia;
import java.util.List;

public class Ruta {
    private int id;
    private String descripcion;
    private Agencia agenciaSalida;
    private String paradas;
    private boolean tipo_ruta;

    public Ruta() {
    }

    
    public Ruta(int id,String descripcion, Agencia agenciaSalida, boolean esInterprovincial) {
        this.id = id;
        this.descripcion = descripcion;
        this.agenciaSalida = agenciaSalida;
        this.tipo_ruta = esInterprovincial;
    }
    // Getters y Setters
    
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
        return tipo_ruta;
    }

    // Setter for esInterprovincial
    public void setEsInterprovincial(boolean esInterprovincial) {
        this.tipo_ruta = esInterprovincial;
    }

    public String getParadas() {
        return paradas;
    }

    public void setParadas(String paradas) {
        this.paradas = paradas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
