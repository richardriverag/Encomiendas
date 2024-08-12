/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.controllers.almacenamiento;

import encomiendas.model.entity.almacenamiento.Agencia;
import encomiendas.services.almacenamiento.DbAgencia;
import encomiendas.views.almacenamiento.FRMAlmacen;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author tandr
 */
public class CtrAgencia implements ActionListener {
    private Agencia agen;
    private DbAgencia dbAgen;
    private FRMAlmacen frmAlm; 

    public CtrAgencia(Agencia agen, DbAgencia dbAgen, FRMAlmacen frmAlm) {
        this.agen = agen;
        this.dbAgen = dbAgen;
        this.frmAlm = frmAlm;
        cargarAgencias(); 
        
    }

    public void cargarAgencias() {
        List<Agencia> agencias = dbAgen.obtenerAgencias();
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
                setText(agencia.getNombre()); // Mostrar el nombre en el ComboBox
            } else {
                setText(value.toString()); // Para otros casos, como el texto "Seleccionar" si lo tienes
            }
            return this;
        }
    });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
