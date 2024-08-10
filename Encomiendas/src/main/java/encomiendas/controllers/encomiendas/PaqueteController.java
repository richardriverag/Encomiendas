package encomiendas.controllers.encomiendas;

import encomiendas.model.entity.encomiendas.Paquete;
import encomiendas.services.encomiendas.PaqueteService;
import encomiendas.views.encomiendas.JFEncomiendas;
import encomiendas.views.encomiendas.JFPaquetes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PaqueteController implements ActionListener {

    private PaqueteService paquete;
    private JFrame viewListaPaquetes;
    //OJO
    private JFPaquetes viewPaquetes;
    private JFEncomiendas viewEncomiendas;

    public List<Paquete> listaPaqueteFramePaquete;

    public PaqueteController(JFrame viewListaPaquetes, PaqueteService paquete) {
        this.paquete = paquete;
        this.viewListaPaquetes = viewListaPaquetes;
    }

    public PaqueteController(JFEncomiendas viewEncomiendas, PaqueteService paquete) {
        this.paquete = paquete;
        this.viewEncomiendas = viewEncomiendas;
        this.listaPaqueteFramePaquete = new ArrayList<>();
    }

    public PaqueteController(JFPaquetes viewPaquetes, PaqueteService paquete) {
        this.paquete = paquete;
        this.viewPaquetes = viewPaquetes;
        this.listaPaqueteFramePaquete = new ArrayList<>();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewPaquetes.btnAddPaquete) {
            Paquete nuevoPaquete = new Paquete();
            nuevoPaquete.setDescripcion(viewPaquetes.txtDescripPaquete.getText());
            nuevoPaquete.setPeso(Double.parseDouble(viewPaquetes.txtPesoPaquete.getText()));
            nuevoPaquete.setVolumen(Double.parseDouble(viewPaquetes.txtVolPaquete.getText()));
            nuevoPaquete.setIsFragil(viewPaquetes.jCBIsFragil.isSelected());
            nuevoPaquete.setPrecioPaquete(Double.parseDouble(viewPaquetes.txtPrecioPaquete.getText()));
            //nuevoPaquete.setIdEncomienda(Integer.parseInt(viewPaquetes.txtIdEncomienda.getText()));
            //nuevoPaquete.setIdEncomienda(1);

            listaPaqueteFramePaquete.add(nuevoPaquete);
            System.out.println("DENTRO DEL BOTON ADD");
            System.out.println(listaPaqueteFramePaquete.toString());
            System.out.println("");
            //paquete.savePaquete(nuevoPaquete);

            viewPaquetes.limpiar2();
            JOptionPane.showMessageDialog(null, "El paquete se insertó con éxito.");
            // Mostrar diálogo de confirmación
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea agregar otro paquete a la encomienda?",
                    "Agregar otro paquete",
                    JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                // Si el usuario desea agregar otro paquete, simplemente continuar
                viewPaquetes.limpiar2(); // Limpiar los campos para el nuevo paquete
            } 
        }
        System.out.println("ANTES DEL BOTON VOLVER");
        System.out.println(listaPaqueteFramePaquete.toString());
        System.out.println("----------------------");
        if (e.getSource() == viewPaquetes.btnVolver) {
            System.out.println(listaPaqueteFramePaquete.toString());
            viewEncomiendas.listaPaquete = listaPaqueteFramePaquete;
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
