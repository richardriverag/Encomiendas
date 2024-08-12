/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.controllers.almacenamiento;

import encomiendas.model.entity.almacenamiento.Almacen;
import encomiendas.model.entity.almacenamiento.Seccion;
import encomiendas.services.almacenamiento.DbSeccion;
import encomiendas.views.almacenamiento.FRMAlmacen;
import encomiendas.views.almacenamiento.NuevaFicha;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author tandr
 */
public class CtrSeccion implements ActionListener {

    private Seccion Sec;
    private DbSeccion dbSec;
    private FRMAlmacen frmAlm; 
    private NuevaFicha frmFicha;

    public CtrSeccion(Seccion Sec, DbSeccion dbSec, FRMAlmacen frmAlm, NuevaFicha frmFicha) {
        this.Sec = Sec;
        this.dbSec = dbSec;
        this.frmAlm = frmAlm;
        this.frmFicha = frmFicha;
        frmAlm.cbAlmacen.addActionListener(this);
        frmAlm.btnActualizarSeccion.addActionListener(this);
        cargarSecciones();
        addTableMouseListener(); 
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == frmAlm.cbAlmacen) {
           almacenConSecciones();
       }else if(e.getSource() == frmAlm.btnActualizarSeccion){
           actualizarSeccion();
       }
       
    }
    private void almacenConSecciones() {
         Almacen seleccionado = (Almacen) frmAlm.cbAlmacen.getSelectedItem();
            if (seleccionado != null) {
                int idAlmacen = seleccionado.getIdAlmacen();
                // Cargar las secciones correspondientes a ese almacén
                cargarSecciones(idAlmacen);
            }
    }
    private void cargarSecciones(int idAlmacen) {
        // Obtener las secciones desde la base de datos
        List<Seccion> secciones = dbSec.obtenerSecciones(idAlmacen);
        
        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Sección");
        model.addColumn("Nombre");
        model.addColumn("Capacidad");

        // Agregar filas al modelo
        for (Seccion s : secciones) {
            model.addRow(new Object[]{s.getIdSeccion(), s.getNombreSeccion(), s.getCapacidad()});
        }

        // Establecer el modelo en la tabla
        frmAlm.jTableSecciones.setModel(model);
    }
    private void addTableMouseListener() {
        frmAlm.jTableSecciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarDatosSeccion(e);
            }
        });
    }

    // Método para manejar la carga de datos en los campos de texto
    private void cargarDatosSeccion(MouseEvent e) {
        int row = frmAlm.jTableSecciones.rowAtPoint(e.getPoint());
        if (row >= 0) {
            // Obtener los valores de la fila seleccionada
            int idSeccion = (int) frmAlm.jTableSecciones.getValueAt(row, 0);
            String nombre = (String) frmAlm.jTableSecciones.getValueAt(row, 1);
            int capacidad = (int) frmAlm.jTableSecciones.getValueAt(row, 2);

            // Actualizar los campos de texto
            frmAlm.txtCodigoSeccion.setText(String.valueOf(idSeccion));
            frmAlm.txtNombreSeccion.setText(nombre);
            frmAlm.txtCapacidadSeccion.setText(String.valueOf(capacidad));
        }
    }
    
    
   private void actualizarSeccion() {
    try {
        int idSeccion = Integer.parseInt(frmAlm.txtCodigoSeccion.getText());
        String nombre = frmAlm.txtNombreSeccion.getText();
        int capacidad = Integer.parseInt(frmAlm.txtCapacidadSeccion.getText());

        // Obtener el almacén seleccionado del JComboBox
        Almacen almacenSeleccionado = (Almacen) frmAlm.cbAlmacen.getSelectedItem();
        int idAlmacen = almacenSeleccionado != null ? almacenSeleccionado.getIdAlmacen() : 0;

        // Crear el objeto Seccion con el idAlmacen correcto
        Seccion seccion = new Seccion(idSeccion, nombre, capacidad, idAlmacen);
        if (dbSec.actualizar(seccion)) {
            System.out.println("Sección actualizada con éxito.");
            // Opcional: Mostrar un mensaje de éxito al usuario
            // JOptionPane.showMessageDialog(frmAlm, "Sección actualizada con éxito");
            
            // Volver a cargar las secciones para reflejar los cambios
            almacenConSecciones();
        } else {
            System.err.println("Error al actualizar la sección.");
            // Opcional: Mostrar un mensaje de error al usuario
            // JOptionPane.showMessageDialog(frmAlm, "Error al actualizar la sección");
        }
    } catch (NumberFormatException ex) {
        System.err.println("Error al parsear los valores: " + ex.getMessage());
        // Opcional: Mostrar un mensaje de error al usuario
        // JOptionPane.showMessageDialog(frmAlm, "Error en los datos ingresados");
    }
}
   
   public void cargarSecciones() {   
    List<Seccion> secciones = dbSec.obtenerTodas(); // Obtener la lista de secciones
       DefaultComboBoxModel<Seccion> model = new DefaultComboBoxModel<>();
    for (Seccion s : secciones) {
        model.addElement(s); // Agregar cada sección al modelo
    }
    frmFicha.cbSeccion.setModel(model); // Establecer el modelo en el ComboBox
    
    // Configurar el renderizador para mostrar el nombre de la sección
    frmFicha.cbSeccion.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Seccion) {
                Seccion seccion = (Seccion) value;
                setText(seccion.getNombreSeccion()); // Mostrar el nombre de la sección en el ComboBox
            } else {
                setText(value.toString()); // Para otros casos, como el texto "Seleccionar" si lo tienes
            }
            return this;
        }
    });
}


    
    
}
