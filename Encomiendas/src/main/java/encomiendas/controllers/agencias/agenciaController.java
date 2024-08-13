/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.controllers.agencias;

import encomiendas.model.data.agencias.DbAgencia;
import encomiendas.model.entity.agencias.Agencia;
import encomiendas.views.agencia.ConsultaAgencia;
import encomiendas.views.agencia.ModificarInformacionAgencia;
import encomiendas.views.agencia.NuevaAgencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Roberth
 */
public class agenciaController implements ActionListener{
    private Agencia modAgencia;
    private DbAgencia modDbAgencia;
    private ConsultaAgencia frmConsultaAgencia;
    private NuevaAgencia frmNuevaAgencia;
    private ModificarInformacionAgencia frmModificarInformacionAgencia;
    

    public agenciaController(Agencia modAgencia, DbAgencia modDbAgencia, ConsultaAgencia frmConsultaAgencia, NuevaAgencia frmNuevaAgencia, ModificarInformacionAgencia frmModificarInformacionAgencia) {
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
        
        //eliminar
        if(e.getSource()==frmModificarInformacionAgencia.btnEliminarEnModAgencia){
            modAgencia.setIdAgencia(Integer.parseInt(frmModificarInformacionAgencia.CBModificarAgencia.getSelectedItem().toString()));
            if (modDbAgencia.eliminar(modAgencia)) {
                JOptionPane.showMessageDialog(null, "Agencia Eliminada");
                
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                
            } 
        }
        
        //Limpiar textfiels
        if (e.getSource()==frmNuevaAgencia.BTNLimpiarNuevaAgencia) {
            limpiar();
        }
        
        if (e.getSource()==frmNuevaAgencia.BTNCancelarNuevaAgencia || e.getSource()==frmModificarInformacionAgencia.btnCancelarModificarAgencia) {
            //frmNuevaAgencia.setVisible(false);
            System.exit(0);
        }
        
        
    } 
    
    
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
