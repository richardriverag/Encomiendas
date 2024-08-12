/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.transporte;
 import lombok.*;

@Getter @Setter @NoArgsConstructor
public abstract class Transporte {
    private int transporte_id;
    private double capacidad_carga;
    private String modelo;
    private int anio_fabricacion;
    private double kilometraje;
    private String tipo_transporte;
    private ESTADO_TRANSPORTE estado;
    private HistorialMantenimiento historial;

    public Transporte(int transporte_id, double capacidad_carga, String modelo, int anio_fabricacion, double kilometraje, String tipo_transporte, ESTADO_TRANSPORTE estado) {
        this.transporte_id = transporte_id;
        this.capacidad_carga = capacidad_carga;
        this.modelo = modelo;
        this.anio_fabricacion = anio_fabricacion;
        this.kilometraje = kilometraje;
        this.tipo_transporte = tipo_transporte;
        this.estado = estado;
        this.historial = new HistorialMantenimiento();
    }
    
    
}
