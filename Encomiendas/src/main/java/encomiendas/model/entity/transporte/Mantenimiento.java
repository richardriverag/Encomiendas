package encomiendas.model.entity.transporte;

import java.util.Date;

public class Mantenimiento {
    private int id;
    private Date fecha;
    private String descripcion;

    public Mantenimiento(int id, Date fecha, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
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
}
