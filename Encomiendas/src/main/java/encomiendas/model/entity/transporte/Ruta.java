/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.transporte;

import encomiendas.model.entity.usuarios.Agencia;

/**
 *
 * @author hp
 */
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
    
     public boolean isEsInterprovincial() {
        return esInterprovincial;
    }
}
