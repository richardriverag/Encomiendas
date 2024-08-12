/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.controllers.almacenamiento;

import encomiendas.model.data.Agencia.AgenciaRepository;
import encomiendas.model.entity.almacenamiento.Almacen;
import encomiendas.model.entity.usuarios.Agencia;
import encomiendas.services.almacen.AlmacenService;
import encomiendas.views.almacenamiento.FRMAlmacen;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;



/**
 *
 * @author tandr
 */
public class CtrAlmacen implements ActionListener {
    
    private Almacen alm;
    private FRMAlmacen frmAlm; 
    private AlmacenService almacen;
    private AgenciaRepository repoAgencia;

     public CtrAlmacen(FRMAlmacen frmAlm, AlmacenService almacenService, AgenciaRepository repoAgencia) throws SQLException {
        this.frmAlm = frmAlm;
        this.almacen = almacenService;
        this.repoAgencia = repoAgencia;
        this.frmAlm.btnBuscarAlmacen.addActionListener(this);
        this.frmAlm.btnGuardarAlmacen.addActionListener(this);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmAlm.btnBuscarAlmacen) {
            buscarAlmacen();
        }else if (e.getSource() == frmAlm.btnGuardarAlmacen) {
            try {
                guardarAlmacen();
            } catch (SQLException ex) {
                Logger.getLogger(AlmacenService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
   private void buscarAlmacen() {
    try {
        // Crear una instancia de Almacen y establecer el ID
        Almacen almacenBusqueda = new Almacen();
        almacenBusqueda.setIdAlmacen(Integer.parseInt(frmAlm.txtBuscarAlmacen.getText()));

        // Llamar al servicio para buscar el almacén con el objeto
        alm = almacen.buscar(almacenBusqueda);

        if (alm != null) {
            // Rellenar los campos de la interfaz con los datos del almacén encontrado
            frmAlm.txtCodigoAlmacen.setText(String.valueOf(alm.getIdAlmacen()));
            frmAlm.txtNombreAlmacen.setText(alm.getNombreAlmacen());
            frmAlm.txtCaducidad.setText(String.valueOf(alm.getLimiteSuperiorCaducidad()));
            frmAlm.txtcantidadSecciones.setText(String.valueOf(alm.getNumeroSecciones()));
            
            // Asignar la agencia seleccionada en el ComboBox
            frmAlm.cbAgencia.setSelectedItem(alm.getAgencia());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el almacén");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Por favor, ingresa un ID de almacén válido.");
    }
}
    
   private void guardarAlmacen() throws SQLException {
        try {
            alm = new Almacen();
            alm.setNombreAlmacen(frmAlm.txtNombreAlmacen.getText());
            alm.setLimiteSuperiorCaducidad(Integer.parseInt(frmAlm.txtCaducidad.getText()));
            alm.setNumeroSecciones(Integer.parseInt(frmAlm.txtcantidadSecciones.getText()));
            
            Agencia agenciaSeleccionada = (Agencia) frmAlm.cbAgencia.getSelectedItem();
            if (agenciaSeleccionada != null) {
                alm.setAgencia(agenciaSeleccionada.getIdAgencia());
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una agencia.");
                return;
            }
            
            almacen.guardar(alm);
            cargarAlmacenes();
            JOptionPane.showMessageDialog(null, "Almacén guardado con éxito");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa valores válidos en los campos.");
        }
    }
    
    
    public void cargarAlmacenes() throws SQLException {
    List<Almacen> almacenes = almacen.getAllAlmacenes(); // Obtener la lista de almacenes
    DefaultComboBoxModel<Almacen> model = new DefaultComboBoxModel<>();
    for (Almacen a : almacenes) {
        model.addElement(a); // Agregar cada almacén al modelo
    }
    frmAlm.cbAlmacen.setModel(model); // Establecer el modelo en el ComboBox
    frmAlm.cbAlmacen.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Almacen) {
                Almacen almacen = (Almacen) value;
                setText(almacen.getNombreAlmacen()); // Mostrar el nombre del almacén en el ComboBox
            } else {
                setText(value.toString()); // Para otros casos, como el texto "Seleccionar" si lo tienes
            }
            return this;
        }
    });
}
    public void cargarAgencias() throws SQLException {
        List<Agencia> agencias = repoAgencia.findAll();
        DefaultComboBoxModel<Agencia> model = new DefaultComboBoxModel<>();
        for (Agencia a : agencias) {
            model.addElement(a);
        }
       frmAlm.cbAgencia.setModel(model);
       frmAlm.cbAgencia.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Agencia) {
                Agencia agencia = (Agencia) value;
                setText(agencia.getNombreAgencia()); // Mostrar el nombre en el ComboBox
            } else {
                setText(value.toString()); // Para otros casos, como el texto "Seleccionar" si lo tienes
            }
            return this;
        }
    });
    }

    
}
