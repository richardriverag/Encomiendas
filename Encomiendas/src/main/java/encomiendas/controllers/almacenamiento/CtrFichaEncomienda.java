/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.controllers.almacenamiento;

import encomiendas.model.data.Agencia.AgenciaRepository;
import encomiendas.model.entity.almacenamiento.FichaEncomienda;
import encomiendas.model.entity.almacenamiento.Seccion;
import encomiendas.model.entity.encomiendas.Encomienda;
import encomiendas.model.entity.usuarios.Agencia;
import encomiendas.services.almacen.FichaEncomiendaService;
import encomiendas.services.almacen.SeccionService;
import encomiendas.services.encomiendas.EncomiendaService;
import encomiendas.views.almacenamiento.FRMAlmacen;
import encomiendas.views.almacenamiento.NuevaFicha;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class CtrFichaEncomienda implements ActionListener {
    private FichaEncomienda ficha;
    private FichaEncomiendaService fichaService;
    private SeccionService seccionService;
    private EncomiendaService encomiendaService;
    private NuevaFicha frmFicha;
    private FRMAlmacen frmALM;

    public CtrFichaEncomienda(FichaEncomienda ficha, FichaEncomiendaService dbFicha, NuevaFicha frmFicha,FRMAlmacen frmALM,SeccionService dbSeccion,EncomiendaService encomiendaService) {
        this.ficha = ficha;
        this.fichaService = dbFicha;
        this.frmFicha = frmFicha;
        this.frmALM=  frmALM;
        this.seccionService =  dbSeccion;
        this.encomiendaService = encomiendaService;
        this.frmFicha.btnGuardar.addActionListener(this);
        this.frmALM.btnBuscarFicha.addActionListener(this);
        this.frmALM.btnRetirar.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == frmFicha.btnGuardar) {
          try {
              guardarFicha();
          } catch (SQLException ex) {
              Logger.getLogger(CtrFichaEncomienda.class.getName()).log(Level.SEVERE, null, ex);
          }
        }else if(e.getSource() == frmALM.btnBuscarFicha){
            buscarFicha();
        }else if (e.getSource() == frmALM.btnRetirar) {
          try {
              retirarFicha();
          } catch (SQLException ex) {
              Logger.getLogger(CtrFichaEncomienda.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }
    
    private void buscarFicha() {
        ficha.setIdFichaEncomienda(Integer.parseInt(frmALM.txtBuscarFicha.getText()));
        

        FichaEncomienda fichaBuscada = fichaService.buscarFicha(ficha);
            frmALM.txtCodigoFicha.setText(String.valueOf(fichaBuscada.getIdFichaEncomienda()));
            String nombreSeccion = seccionService.obtenerNombreSeccion(fichaBuscada.getIdSeccion());
            frmALM.txtNombreFichaSeccion.setText(nombreSeccion);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            frmALM.txtFichaFechaEnt.setText(fichaBuscada.getFechaEntrda() != null ? sdf.format(fichaBuscada.getFechaEntrda()) : "");
             frmALM.txtFechaSalida.setText(fichaBuscada.getFechaSalida() != null ? sdf.format(fichaBuscada.getFechaSalida()) : "");
            frmALM.txtEncomiendaId.setText(String.valueOf(fichaBuscada.getEncomienda()));
            
            
            String estadoFicha = ficha.isEstadoFicha()==1 ? "Activa" : "Inactiva";
            frmALM.txtEstado.setText(String.valueOf(estadoFicha));
            
       
    }
    

     private void guardarFicha() throws SQLException {
        String DATE_FORMAT = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String fechaEntradaStr = frmFicha.txtFechaEntrada.getText();
        
        if (!esFechaValida(fechaEntradaStr)) {
            JOptionPane.showMessageDialog(null, "La fecha debe estar en el formato YYYY-MM-DD", "Formato de fecha inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        java.util.Date fechaEntrada = null;
        try {
             fechaEntrada = dateFormat.parse(fechaEntradaStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al analizar la fecha", "Error de fecha", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ficha.setIdFichaEncomienda(0);
        ficha.setFechaEntrda(fechaEntrada);
        ficha.setEstadoFicha(1);
        ficha.setFechaSalida(null);
        Seccion seccionSeleccionada = (Seccion) frmFicha.cbSeccion.getSelectedItem();
        
        if (seccionSeleccionada != null) {
            ficha.setIdSeccion(seccionSeleccionada.getIdSeccion()); 
        } else {
            // Manejar el caso donde no se ha seleccionado ninguna agencia
            System.out.println("No se ha seleccionado ninguna seccion.");
        }
        int capacidadMaxima = seccionSeleccionada.getCapacidad();// se agrego al codigo
        int fichasExistentes = fichaService.contarFichasEnSecciones(seccionSeleccionada.getIdSeccion());
            if (fichasExistentes == capacidadMaxima) {
                JOptionPane.showMessageDialog(null, "La sección seleccionada ya está completa.", "Sección completa", JOptionPane.ERROR_MESSAGE);
                return;
            }
        Encomienda encomiendaSeleccionada = (Encomienda) frmFicha.cbEncomienda.getSelectedItem();
        if (encomiendaSeleccionada != null) {
            ficha.setEncomienda(encomiendaSeleccionada.getIdEncomienda()); 
        } else {
            // Manejar el caso donde no se ha seleccionado ninguna agencia
            System.out.println("No se ha seleccionado ninguna encomienda.");
        }


        fichaService.guardarFicha(ficha);
        
    }
    
     private boolean esFechaValida(String fechaStr) {
        String DATE_FORMAT = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        if (fechaStr == null || fechaStr.isEmpty()) {
            return false;
        }
        try {
            dateFormat.setLenient(false); // Establecer en estricto modo
            dateFormat.parse(fechaStr); // Intentar analizar la fecha
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    private void retirarFicha() throws SQLException {
    // Obtener el ID de la ficha desde el campo de texto de búsqueda
        int idFicha = Integer.parseInt(frmALM.txtBuscarFicha.getText());

        // Crear un objeto Ficha con el ID
        
        ficha.setIdFichaEncomienda(idFicha);

        // Llamar al método para actualizar la ficha en la base de datos
         // Asegúrate de que DbFicha esté disponible aquí
        fichaService.update(0,ficha);
        buscarFicha();

        
    }
    
    public void cargarEncomiendas() throws SQLException {
    List<Encomienda> encomiendas = encomiendaService.getAllEncomiendas(); // Obtener la lista de almacenes
    DefaultComboBoxModel<Encomienda> model = new DefaultComboBoxModel<>();
    for (Encomienda a : encomiendas) {
        model.addElement(a); // Agregar cada almacén al modelo
    }
    frmFicha.cbEncomienda.setModel(model); // Establecer el modelo en el ComboBox
    frmFicha.cbEncomienda.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Encomienda) {
                    Encomienda encomienda = (Encomienda) value;
                    setText(String.valueOf(encomienda.getIdEncomienda())); // Mostrar el nombre del almacén en el ComboBox
                } else {
                    setText(value.toString()); // Para otros casos, como el texto "Seleccionar" si lo tienes
                }
                return this;
            }
        });
    
    }
    
    
    
}
