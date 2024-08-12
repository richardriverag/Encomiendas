/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.transporte;

/**
 *
 * @author hp
 */
public class Camion extends Transporte{
    public Camion(int id, double capacidadCarga, String modelo, int anoFabricacion, double kilometraje,String tipo ,ESTADO_TRANSPORTE estadoTransporte) {
        super(id, capacidadCarga, modelo, anoFabricacion, kilometraje,tipo ,estadoTransporte);
    }
}
