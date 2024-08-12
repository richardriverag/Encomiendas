/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.controllers.almacenamiento;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.entidades.Agencia;
import modelo.entidades.Almacen;
import modelo.services.DbAlmacen;
import vista.FRMAlmacen;

/**
 *
 * @author tandr
 */
public class CtrAlmacen implements ActionListener {
    
    private Almacen alm;
    private DbAlmacen dbAlm;
    private FRMAlmacen frmAlm; 

    public CtrAlmacen(Almacen alm, DbAlmacen dbAlm, FRMAlmacen frmAlm) {
        this.alm = alm;
        this.dbAlm = dbAlm;
        this.frmAlm = frmAlm;
        cargarAlmacenes();
        
        this.frmAlm.btnBuscarAlmacen.addActionListener(this);
         this.frmAlm.btnGuardarAlmacen.addActionListener(this);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmAlm.btnBuscarAlmacen) {
            buscarAlmacen();
        }else if (e.getSource() == frmAlm.btnGuardarAlmacen) {
            guardarAlmacen();
        } 
    }
    
    private void buscarAlmacen() {
        alm.setIdAlmacen(Integer.parseInt(frmAlm.txtBuscarAlmacen.getText()));

        if (dbAlm.buscar(alm)) {
            frmAlm.txtCodigoAlmacen.setText(String.valueOf(alm.getIdAlmacen()));
            frmAlm.txtNombreAlmacen.setText(alm.getNombreAlmacen());
            frmAlm.txtCaducidad.setText(String.valueOf(alm.getLimiteSuperiorCaducidad()));
            frmAlm.txtcantidadSecciones.setText(String.valueOf(alm.getAgencia()));
            
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el almacen");
            //limpiar();
        }
    }
    
    private void guardarAlmacen() {
        alm.setIdAlmacen(0);
        alm.setNombreAlmacen(frmAlm.txtNombreAlmacen.getText());
        alm.setLimiteSuperiorCaducidad(Integer.parseInt(frmAlm.txtCaducidad.getText()));
        alm.setNumeroSecciones(Integer.parseInt(frmAlm.txtcantidadSecciones.getText()));
        Agencia agenciaSeleccionada = (Agencia) frmAlm.cbAgencia.getSelectedItem();
        if (agenciaSeleccionada != null) {
            alm.setAgencia(agenciaSeleccionada.getId()); 
        } else {
            // Manejar el caso donde no se ha seleccionado ninguna agencia
            System.out.println("No se ha seleccionado ninguna agencia.");
        }


        if (dbAlm.guardar(alm)) {
            cargarAlmacenes();
            JOptionPane.showMessageDialog(null, "Almacen guardado");
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
          
        }
    }
    
    
    public void cargarAlmacenes() {
    List<Almacen> almacenes = dbAlm.obtenerAlmacenes(); // Obtener la lista de almacenes
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

    
}
