/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.transporte;

import java.util.Date;

/**
 *
 * @author hp
 */
public class Mantenimiento {
    private int id;
    private Date fecha;
    private String descripcion;
    
    public Mantenimiento(int id, Date fecha, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
    
}
