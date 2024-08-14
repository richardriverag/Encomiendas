/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.almacenamiento;

import java.util.Date;

/**
 *
 * @author tandr
 */
public class FichaEncomienda {
    private int idFichaEncomienda;
    private Date fechaEntrda;
    private Date fechaSalida;
    private int estadoFicha;
    private int idSeccion;
    private int encomienda;

    public FichaEncomienda() {
    }

    public FichaEncomienda(int idFichaEncomienda, Date fechaEntrda, Date fechaSalida, int estadoFicha, int idSeccion, int encomienda) {
        this.idFichaEncomienda = idFichaEncomienda;
        this.fechaEntrda = fechaEntrda;
        this.fechaSalida = fechaSalida;
        this.estadoFicha = estadoFicha;
        this.idSeccion = idSeccion;
        this.encomienda = encomienda;
    }

    public int getIdFichaEncomienda() {
        return idFichaEncomienda;
    }

    public void setIdFichaEncomienda(int idFichaEncomienda) {
        this.idFichaEncomienda = idFichaEncomienda;
    }

    public Date getFechaEntrda() {
        return fechaEntrda;
    }

    public void setFechaEntrda(Date fechaEntrda) {
        this.fechaEntrda = fechaEntrda;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int isEstadoFicha() {
        return estadoFicha;
    }

    public void setEstadoFicha(int estadoFicha) {
        this.estadoFicha = estadoFicha;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public int getEncomienda() {
        return encomienda;
    }

    public void setEncomienda(int encomienda) {
        this.encomienda = encomienda;
    }
    
}
