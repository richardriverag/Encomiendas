/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.almacenamiento;

/**
 *
 * @author tandr
 */
public class Seccion {
    private int idSeccion;
    private String nombreSeccion;
    private int capacidad;
    private int idAlmacen;

    public Seccion() {
    }

    public Seccion(int idSeccion, String nombreSeccion, int capacidad, int idAlmacen) {
        this.idSeccion = idSeccion;
        this.nombreSeccion = nombreSeccion;
        this.capacidad = capacidad;
        this.idAlmacen = idAlmacen;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }
    
    
    
}
