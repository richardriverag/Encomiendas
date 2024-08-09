package encomiendas.controllers.encomiendas;

import encomiendas.model.entity.encomiendas.Paquete;
import encomiendas.services.encomiendas.PaqueteService;
import encomiendas.views.encomiendas.JFPaquetes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PaqueteController implements ActionListener {

    private JFrame view;
    private PaqueteService paquete;
    //OJO
    private JFPaquetes viewPaquetes;

    public PaqueteController(JFrame view, PaqueteService paquete) {
        this.view = view;
        this.paquete = paquete;
    }

    public PaqueteController( JFPaquetes viewPaquetes, PaqueteService paquete) {
        this.paquete = paquete;
        this.viewPaquetes = viewPaquetes;
        this.viewPaquetes.btnAddPaquete.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewPaquetes.btnAddPaquete) {
            try {
                Paquete nuevoPaquete = new Paquete();
                nuevoPaquete.setDescripcion(viewPaquetes.txtDescripPaquete.getText());
                nuevoPaquete.setPeso(Double.parseDouble(viewPaquetes.txtPesoPaquete.getText()));
                nuevoPaquete.setVolumen(Double.parseDouble(viewPaquetes.txtVolPaquete.getText()));
                nuevoPaquete.setIsFragil(viewPaquetes.jCBIsFragil.isSelected());
                nuevoPaquete.setPrecioPaquete(Double.parseDouble(viewPaquetes.txtPrecioPaquete.getText()));
                //nuevoPaquete.setIdEncomienda(Integer.parseInt(viewPaquetes.txtIdEncomienda.getText()));
                nuevoPaquete.setIdEncomienda(1);
                
                
                paquete.savePaquete(nuevoPaquete);
                
                viewPaquetes.limpiar(); 
                
                JOptionPane.showMessageDialog(null, "El paquete se inserto con éxito.");
                
            } catch (SQLException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Existio un error al insertar el paquete");
            }

        }

    }

    public void mostrarPaquetes(DefaultTableModel modeloTablaPaquetes) {

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
