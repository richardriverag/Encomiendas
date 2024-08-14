/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.transporte;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class HistorialMantenimiento {
     private List<Mantenimiento> mantenimientos;
     
     public HistorialMantenimiento() {
        this.mantenimientos = new ArrayList<>();
    }
     
     public void agregarMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimientos.add(mantenimiento);
    }
     
    public List<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }
}
