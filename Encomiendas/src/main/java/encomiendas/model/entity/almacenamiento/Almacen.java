/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.almacenamiento;

/**
 *
 * @author tandr
 */
public class Almacen {
    private int idAlmacen;
    private String nombreAlmacen;
    private int limiteSuperiorCaducidad;
    private int agencia;
    private int numeroSecciones; 

    public Almacen() {
    }

    public Almacen(int idAlmacen, String nombreAlmacen, int limiteSuperiorCaducidad, int agencia, int numeroSecciones) {
        this.idAlmacen = idAlmacen;
        this.nombreAlmacen = nombreAlmacen;
        this.limiteSuperiorCaducidad = limiteSuperiorCaducidad;
        this.agencia = agencia;
        this.numeroSecciones = numeroSecciones;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    public int getLimiteSuperiorCaducidad() {
        return limiteSuperiorCaducidad;
    }

    public void setLimiteSuperiorCaducidad(int limiteSuperiorCaducidad) {
        this.limiteSuperiorCaducidad = limiteSuperiorCaducidad;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    public int getNumeroSecciones() {
        return numeroSecciones;
    }

    public void setNumeroSecciones(int numeroSecciones) {
        this.numeroSecciones = numeroSecciones;
    }
    
    
    
}
