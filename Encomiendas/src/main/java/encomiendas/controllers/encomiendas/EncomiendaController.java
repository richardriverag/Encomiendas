package encomiendas.controllers.encomiendas;


import encomiendas.model.entity.encomiendas.Encomienda;
import encomiendas.model.entity.encomiendas.Paquete;
import encomiendas.services.encomiendas.EncomiendaService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class EncomiendaController  {
    private JFrame view;
    private EncomiendaService encomienda; 

    public EncomiendaController(JFrame view, EncomiendaService encomienda) {
        this.view = view;
        this.encomienda = encomienda;
    }
    
    public void mostrarEncomienda(DefaultTableModel modeloTablaEncomienda){
         try {
            // Obtener la lista de paquetes desde el servicio
            List<Encomienda> listaEncomienda = encomienda.getAllEncomiendas();
            
            // Limpiar cualquier fila existente en la tabla (opcional)
            modeloTablaEncomienda.setRowCount(0);
            
            // Iterar sobre la lista de paquetes e insertar cada uno en la tabla
            for (Encomienda encomienda : listaEncomienda) {
                // Convertir el paquete en un array de objetos para agregarlo como una fila
                Object[] fila = new Object[]{
                    encomienda.getIdEncomienda(),
                    encomienda.getEmisor(),
                    encomienda.getReceptor(),
                    encomienda.getAgenciaOrigen(),
                    encomienda.getAgenciaDestino()
                        
                };
                
                // Agregar la fila al modelo de la tabla
                modeloTablaEncomienda.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
}
