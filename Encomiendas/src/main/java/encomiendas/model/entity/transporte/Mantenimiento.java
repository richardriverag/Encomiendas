package encomiendas.model.entity.transporte;

import java.util.Date;

public class Mantenimiento {
    private int id;
    private Date fecha;
    private String descripcion;
    private Transporte transporte;

    public Mantenimiento() {
        this.transporte = new Transporte();
    }

    
    public Mantenimiento(int id, Date fecha, String descripcion, Transporte transporte) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.transporte = transporte;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getTransporteId() {
        if (transporte != null) {
            return transporte.getTransporte_id();
        } else {
            throw new IllegalStateException("El transporte no ha sido asignado.");
        }
    }
        
    public void setTransporteId(int transporteId) {
        if (this.transporte != null) {
            this.transporte.setTransporte_id(transporteId);
        } else {
            // Si el transporte es null, se puede inicializar un nuevo objeto Transporte o lanzar una excepción
            throw new IllegalStateException("El transporte no ha sido asignado.");
        }
}

}
