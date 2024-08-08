package encomiendas.controllers.encomiendas;

import encomiendas.model.entity.encomiendas.Paquete;
import encomiendas.services.encomiendas.PaqueteService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class PaqueteController {
    
    private JFrame view;
    private PaqueteService paquete;

    public PaqueteController(JFrame view, PaqueteService paquete) {
        this.view = view;
        this.paquete = paquete;
    }
    
    
    public void mostrarPaquetes(DefaultTableModel modeloTablaPaquetes){
    
        try {
            // Obtener la lista de paquetes desde el servicio
            List<Paquete> listaDePaquetes = paquete.getAllPaquetes();
            
            // Limpiar cualquier fila existente en la tabla (opcional)
            modeloTablaPaquetes.setRowCount(0);
            
            // Iterar sobre la lista de paquetes e insertar cada uno en la tabla
            for (Paquete paquete : listaDePaquetes) {
                // Convertir el paquete en un array de objetos para agregarlo como una fila
                Object[] fila = new Object[]{
                    paquete.getIdPaquete(),
                    paquete.getDescripcion(),
                    paquete.getPeso(),
                    paquete.getVolumen(),
                    paquete.getIsFragil(),
                    paquete.getPrecioPaquete(),
                    paquete.getIdEncomienda()
                        // Agrega aquí más atributos del paquete si es necesario
                };
                
                // Agregar la fila al modelo de la tabla
                modeloTablaPaquetes.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
               
    }
    

}
