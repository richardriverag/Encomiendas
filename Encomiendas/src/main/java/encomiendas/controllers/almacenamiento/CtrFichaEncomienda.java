/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.controllers.almacenamiento;

import encomiendas.model.entity.almacenamiento.Encomienda;
import encomiendas.model.entity.almacenamiento.FichaEncomienda;
import encomiendas.model.entity.almacenamiento.Seccion;
import encomiendas.services.almacenamiento.DbFichaEncomienda;
import encomiendas.services.almacenamiento.DbSeccion;
import encomiendas.views.almacenamiento.FRMAlmacen;
import encomiendas.views.almacenamiento.NuevaFicha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author tandr
 */
public class CtrFichaEncomienda implements ActionListener {
    private FichaEncomienda ficha;
    private DbFichaEncomienda dbFicha;
    private DbSeccion dbSeccion;
    private NuevaFicha frmFicha;
    private FRMAlmacen frmALM;

    public CtrFichaEncomienda(FichaEncomienda ficha, DbFichaEncomienda dbFicha, NuevaFicha frmFicha,FRMAlmacen frmALM,DbSeccion dbSeccion) {
        this.ficha = ficha;
        this.dbFicha = dbFicha;
        this.frmFicha = frmFicha;
        this.frmALM=  frmALM;
        this.dbSeccion =  dbSeccion;
        this.frmFicha.btnGuardar.addActionListener(this);
        this.frmALM.btnBuscarFicha.addActionListener(this);
        this.frmALM.btnRetirar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == frmFicha.btnGuardar) {
            guardarFicha();
        }else if(e.getSource() == frmALM.btnBuscarFicha){
            buscarFicha();
        }else if (e.getSource() == frmALM.btnRetirar) {
            retirarFicha();
        }
    }
    
    private void buscarFicha() {
        ficha.setIdFichaEncomienda(Integer.parseInt(frmALM.txtBuscarFicha.getText()));
        

        if (dbFicha.buscar(ficha)) {
            frmALM.txtCodigoFicha.setText(String.valueOf(ficha.getIdFichaEncomienda()));
            String nombreSeccion = dbSeccion.obtenerNombreSeccion(ficha.getIdSeccion());
            frmALM.txtNombreFichaSeccion.setText(nombreSeccion);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            frmALM.txtFichaFechaEnt.setText(ficha.getFechaEntrda() != null ? sdf.format(ficha.getFechaEntrda()) : "");
             frmALM.txtFechaSalida.setText(ficha.getFechaSalida() != null ? sdf.format(ficha.getFechaSalida()) : "");
            frmALM.txtEncomiendaId.setText(String.valueOf(ficha.getEncomienda()));
            
            
            String estadoFicha = ficha.isEstadoFicha()==1 ? "Activa" : "Inactiva";
            frmALM.txtEstado.setText(String.valueOf(estadoFicha));
            
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el almacen");
            //limpiar();
        }
    }
    

    
     private void guardarFicha() {
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
        Encomienda encomiendaSeleccionada = (Encomienda) frmFicha.cbEncomienda.getSelectedItem();
        if (encomiendaSeleccionada != null) {
            ficha.setEncomienda(encomiendaSeleccionada.getIdEncomienda()); 
        } else {
            // Manejar el caso donde no se ha seleccionado ninguna agencia
            System.out.println("No se ha seleccionado ninguna encomienda.");
        }


        if (dbFicha.guardar(ficha)) {
            
            JOptionPane.showMessageDialog(null, "Ficha guardada");
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
          
        }
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
    
    private void retirarFicha() {
    // Obtener el ID de la ficha desde el campo de texto de búsqueda
        int idFicha = Integer.parseInt(frmALM.txtBuscarFicha.getText());

        // Crear un objeto Ficha con el ID
        
        ficha.setIdFichaEncomienda(idFicha);

        // Llamar al método para actualizar la ficha en la base de datos
         // Asegúrate de que DbFicha esté disponible aquí
        boolean actualizado = dbFicha.actualizarFicha(ficha);

        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Ficha retirada exitosamente");

            // Actualizar la vista con la información actualizada
            buscarFicha(); // Llama al método buscarFicha para actualizar los campos en la vista
        } else {
            JOptionPane.showMessageDialog(null, "Error al retirar la ficha");
        }
    }
}
