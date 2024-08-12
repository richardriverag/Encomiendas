/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.transporte;

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

    public int getTransporte_id() {
        return transporte_id;
    }

    public void setTransporte_id(int transporte_id) {
        this.transporte_id = transporte_id;
    }

    public double getCapacidad_carga() {
        return capacidad_carga;
    }

    public void setCapacidad_carga(double capacidad_carga) {
        this.capacidad_carga = capacidad_carga;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio_fabricacion() {
        return anio_fabricacion;
    }

    public void setAnio_fabricacion(int anio_fabricacion) {
        this.anio_fabricacion = anio_fabricacion;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getTipo_transporte() {
        return tipo_transporte;
    }

    public void setTipo_transporte(String tipo_transporte) {
        this.tipo_transporte = tipo_transporte;
    }

    public ESTADO_TRANSPORTE getEstado() {
        return estado;
    }

    public void setEstado(ESTADO_TRANSPORTE estado) {
        this.estado = estado;
    }

    public HistorialMantenimiento getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialMantenimiento historial) {
        this.historial = historial;
    }
    
    
}
