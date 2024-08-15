/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.controllers.agencias;

import encomiendas.model.data.agencias.DbAgencia;
import encomiendas.model.entity.agencias.Agencia;
import encomiendas.views.agencias.ConsultaAgencia;
import encomiendas.views.agencias.ModificarInformacionAgencia;
import encomiendas.views.agencias.NuevaAgencia;
import encomiendas.views.agencias.VerChoferes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Roberth
 */
public class AgenciaController implements ActionListener{
    private Agencia modAgencia;
    private DbAgencia modDbAgencia;
    private ConsultaAgencia frmConsultaAgencia;
    private NuevaAgencia frmNuevaAgencia;
    private ModificarInformacionAgencia frmModificarInformacionAgencia;
    private VerChoferes frmVerChoferes;
    

    public AgenciaController(Agencia modAgencia, DbAgencia modDbAgencia, ConsultaAgencia frmConsultaAgencia, NuevaAgencia frmNuevaAgencia, ModificarInformacionAgencia frmModificarInformacionAgencia, VerChoferes frmVerChoferes) {
        this.modAgencia = modAgencia;
        this.modDbAgencia = modDbAgencia;
        this.frmConsultaAgencia = frmConsultaAgencia;
        this.frmConsultaAgencia.CBSelecionAgencias.addActionListener(this);
        
        this.frmNuevaAgencia=frmNuevaAgencia;
        this.frmNuevaAgencia.BTNGuardarNuevaAgencia.addActionListener(this);
        this.frmNuevaAgencia.BTNLimpiarNuevaAgencia.addActionListener(this);
        this.frmNuevaAgencia.BTNCancelarNuevaAgencia.addActionListener(this);
        
        this.frmModificarInformacionAgencia=frmModificarInformacionAgencia;
        this.frmModificarInformacionAgencia.CBModificarAgencia.addActionListener(this);
        this.frmModificarInformacionAgencia.btnAceptarModificarAgencia.addActionListener(this);
        this.frmModificarInformacionAgencia.btnCancelarModificarAgencia.addActionListener(this);
        this.frmModificarInformacionAgencia.btnEliminarEnModAgencia.addActionListener(this);
        
        
        this.frmVerChoferes=frmVerChoferes;
        this.frmVerChoferes.cbSeleccionChoferes.addActionListener(this);
        this.frmVerChoferes.btnAceptarChofer.addActionListener(this);
        this.frmVerChoferes.btnCancelarChofer.addActionListener(this);
   
    }
    
    public void iniciar(){
        frmConsultaAgencia.setTitle("agencia");
        frmConsultaAgencia.setLocationRelativeTo(null);
        modDbAgencia.RellenarComboBox("agencia", "nombre_agencia", frmConsultaAgencia.CBSelecionAgencias);
        //frmConsultaAgencia.TFIdAgencia.setVisible(true);
        
        frmNuevaAgencia.setTitle("NuevaAgencia");
        frmNuevaAgencia.setLocationRelativeTo(null);
        
        frmModificarInformacionAgencia.setTitle("Modificar Informacion Agencia");
        frmModificarInformacionAgencia.setLocationRelativeTo(null);
        modDbAgencia.RellenarComboBox("agencia", "id_agencia", frmModificarInformacionAgencia.CBModificarAgencia);
        
        
        frmVerChoferes.setTitle("Ver Choferes");
        frmVerChoferes.setLocationRelativeTo(null);
        modDbAgencia.RellenarComboBox("transporte", "tipo_transporte", frmVerChoferes.cbSeleccionChoferes);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int estado=modAgencia.getIdAgencia();
        //Consultar Agencia
        if(e.getSource()==frmConsultaAgencia.CBSelecionAgencias){
            
            String seleccion = frmConsultaAgencia.CBSelecionAgencias.getSelectedItem().toString();
            modAgencia.setNombreAgencia(seleccion);
            
            if (modDbAgencia.buscar(modAgencia)) {
                frmConsultaAgencia.TFIdAgencia.setText(String.valueOf(modAgencia.getIdAgencia()));
                frmConsultaAgencia.TFNombreAgencia.setText(modAgencia.getNombreAgencia());
                frmConsultaAgencia.TFDireccionAgencia.setText(modAgencia.getUbicacionAgencia());
                frmConsultaAgencia.TFCodigoPostalAgencia.setText(modAgencia.getCodigoPostal());
                frmConsultaAgencia.TFProvinciaAgencia.setText(modAgencia.getProvinciaAgencia());
                frmConsultaAgencia.TFTelefonoAgencia.setText(modAgencia.getTelefonoAgencia());
                frmConsultaAgencia.TFCiudadAgencia.setText(modAgencia.getCiudadAgencia());
                if (estado==1) {
                    frmConsultaAgencia.TFEstadoAgencia.setText("Inactivo");
                }else{
                    frmConsultaAgencia.TFEstadoAgencia.setText("Activo");
                }
                
            } 
        }
        
        //Guardar agencia
        if(e.getSource()==frmNuevaAgencia.BTNGuardarNuevaAgencia){
            modAgencia.setNombreAgencia(frmNuevaAgencia.txtNombreNuevaAgencia.getText());
            modAgencia.setUbicacionAgencia(frmNuevaAgencia.txtUbicacionNuevaAgencia.getText());
            modAgencia.setCodigoPostal(frmNuevaAgencia.txtCodigoPostalNuevaAgencia.getText());
            modAgencia.setProvinciaAgencia(frmNuevaAgencia.txtProvinciaNuevaAgencia.getText());
            modAgencia.setTelefonoAgencia(frmNuevaAgencia.txtTelefonoNuevaAgencia.getText());
            modAgencia.setCiudadAgencia(frmNuevaAgencia.txtCiudadNuevaAgencia.getText());
            modAgencia.setEstadoAgencia(Boolean.parseBoolean(frmNuevaAgencia.txtEstadoNuevaAgencia.getText()));
            if (modDbAgencia.guardar(modAgencia)) {
                JOptionPane.showMessageDialog(null, "Agencia Guardada Exitosamente");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar Agencia");
                limpiar();
            } 
        }
        
        //eliminar Agencia

        if (e.getSource() == frmModificarInformacionAgencia.btnEliminarEnModAgencia) {
            modAgencia.setIdAgencia(Integer.parseInt(frmModificarInformacionAgencia.CBModificarAgencia.getSelectedItem().toString()));

            // Buscar la agencia en la base de datos para obtener su estado actual
            if (modDbAgencia.buscar2(modAgencia)) {
                // Obtenemos el estado utilizando isEstadoAgencia()
                boolean estadoAgencia = modAgencia.isEstadoAgencia();

                if (!estadoAgencia) { // Verificamos si la agencia está inactiva (estado false es inactivo)
                    if (modDbAgencia.eliminar(modAgencia)) {
                        JOptionPane.showMessageDialog(null, "Agencia Eliminada");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Eliminar");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar una agencia activa.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar la agencia.");
            }
        }

       
        //Rellenar Cuadros para modificar
        
        if (e.getSource()==frmModificarInformacionAgencia.CBModificarAgencia) {
            int seleccion = Integer.parseInt(frmModificarInformacionAgencia.CBModificarAgencia.getSelectedItem().toString());
            modAgencia.setIdAgencia(seleccion);
           
            if (modDbAgencia.buscar2(modAgencia)) {
                frmModificarInformacionAgencia.txtModificarNombreAgencia.setText(modAgencia.getNombreAgencia());
                frmModificarInformacionAgencia.txtModificarUbicacionAgencia.setText(modAgencia.getUbicacionAgencia());
                frmModificarInformacionAgencia.txtModificarCodigoPostalAgencia.setText(modAgencia.getCodigoPostal());
                frmModificarInformacionAgencia.txtModificarProvinciaAgencia.setText(modAgencia.getProvinciaAgencia());
                frmModificarInformacionAgencia.txtModificarTelefonoAgencia.setText(modAgencia.getTelefonoAgencia());
                frmModificarInformacionAgencia.txtModificarCiudadAgencia.setText(modAgencia.getCiudadAgencia());
                if (estado==1) {
                    frmModificarInformacionAgencia.txtModificarEstadoAgencia.setText("Inactivo");
                }else{
                    frmModificarInformacionAgencia.txtModificarEstadoAgencia.setText("Activo");
                }
                
            }
        }
        
        //modificar agencia
        if (e.getSource()==frmModificarInformacionAgencia.btnAceptarModificarAgencia) {
            modAgencia.setIdAgencia(Integer.parseInt(frmModificarInformacionAgencia.CBModificarAgencia.getSelectedItem().toString()));
            modAgencia.setNombreAgencia(frmModificarInformacionAgencia.txtModificarNombreAgencia.getText());
            modAgencia.setUbicacionAgencia(frmModificarInformacionAgencia.txtModificarUbicacionAgencia.getText());
            modAgencia.setCodigoPostal(frmModificarInformacionAgencia.txtModificarCodigoPostalAgencia.getText());
            modAgencia.setProvinciaAgencia(frmModificarInformacionAgencia.txtModificarProvinciaAgencia.getText());
            modAgencia.setTelefonoAgencia(frmModificarInformacionAgencia.txtModificarTelefonoAgencia.getText());
            modAgencia.setCiudadAgencia(frmModificarInformacionAgencia.txtModificarCiudadAgencia.getText());
            modAgencia.setEstadoAgencia(Boolean.parseBoolean(frmModificarInformacionAgencia.txtModificarEstadoAgencia.getText()));
            
            if (modDbAgencia.modificar(modAgencia)) {
                JOptionPane.showMessageDialog(null, "Cliente Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar Cliente");
                limpiar();
            } 
        }
        
        //Limpiar textfiels
        if (e.getSource()==frmNuevaAgencia.BTNLimpiarNuevaAgencia) {
            limpiar();
        }
        /*//Limpiar Actualizar Agencia
        if (e.getSource()==frmActualizarAgencia.btnModificarLimpiar) {
            limpiar();
        }
        */
        //Cancelar Nueva Agencia
        if (e.getSource()==frmNuevaAgencia.BTNCancelarNuevaAgencia) {
            cancelarVentana(frmNuevaAgencia);
        }
        //Cancelar ver Choferes
        if (e.getSource()==frmVerChoferes.btnCancelarChofer) {
            cancelarVentana(frmVerChoferes);
        }
        //Cancelar Modificar Agencia
        if (e.getSource()==frmModificarInformacionAgencia.btnCancelarModificarAgencia) {
            cancelarVentana(frmModificarInformacionAgencia);
        }
          
    } 
    //Metodo Cancelar
    public void cancelarVentana(JFrame jFrame){
            jFrame.setVisible(false);   
    }
    //Metodo Limpiar
    public void limpiar(){
        frmNuevaAgencia.txtNombreNuevaAgencia.setText(null);
        frmNuevaAgencia.txtUbicacionNuevaAgencia.setText(null);
        frmNuevaAgencia.txtCodigoPostalNuevaAgencia.setText(null);
        frmNuevaAgencia.txtProvinciaNuevaAgencia.setText(null);
        frmNuevaAgencia.txtTelefonoNuevaAgencia.setText(null);
        frmNuevaAgencia.txtCiudadNuevaAgencia.setText(null);
        frmNuevaAgencia.txtEstadoNuevaAgencia.setText(null);
    }
    
}
