package encomiendas.controllers.usuarios;

import encomiendas.model.data.usuarios.DbCliente;
import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.model.entity.usuarios.Cuenta;
import encomiendas.views.usuarios.MenuClientes;
import encomiendas.views.usuarios.PanelPerfilClientes;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class clienteController implements ActionListener {

    private DbCliente modeloDb;
    private MenuClientes frmCliente;
    private PanelPerfilClientes panelCliente;
    private Cliente modCliente;
    private Cuenta modCuenta;

    public clienteController(DbCliente modeloDb, MenuClientes frmCliente, PanelPerfilClientes panelCliente, Cliente modCliente, Cuenta modCuenta) {
        this.modeloDb = modeloDb;
        this.frmCliente = frmCliente;
        this.modCliente = modCliente;
        this.modCuenta = modCuenta;
        this.panelCliente = panelCliente;
        this.frmCliente.btPerfil.addActionListener(this);
    }

    public void iniciar() {
        frmCliente.setLocationRelativeTo(null);
        frmCliente.setVisible(true);
    }
    
    public void cargarDatos(){
        modCliente.setCedula((frmCliente.jTFUsuarioCliente.getText()));
        modCliente.obtenerDatos(modCliente.getCedula());
        panelCliente.jFTNombres.setText(modCliente.getNombres());
        panelCliente.jTFApellido.setText(modCliente.getApellidos());
        panelCliente.jTFCedula.setText(modCliente.getCedula());
        panelCliente.jTFCorreo.setText(modCliente.getCorreo());
        panelCliente.jTFTelefono.setText(modCliente.getTelefono());

        modCuenta.setCedula((frmCliente.jTFUsuarioCliente.getText()));
        modCuenta.obtenerDatosCuenta(modCuenta.getCedula());
        panelCliente.jTFUsuario.setText(modCuenta.getUsername());
        panelCliente.jPFContrasenia.setText(modCuenta.getContrasenia());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Si presiona en el botón Perfil se activa y muestra el panel con la info del Perfil
        if(e.getSource() == frmCliente.btPerfil){
            PanelPerfilClientes panel1 = new PanelPerfilClientes();
            panel1.setSize(690,430);
            panel1.setLocation(0,0);
            
            this.panelCliente = panel1;
            this.panelCliente.jBModificarPerfil.addActionListener(this);
            this.panelCliente.jBVerContrasenia.addActionListener(this);

            frmCliente.jPDefault.removeAll();
            frmCliente.jPDefault.add(panelCliente,BorderLayout.CENTER);
            frmCliente.jPDefault.revalidate();
            frmCliente.jPDefault.repaint();

            cargarDatos();
        }
        
        // Si en el panel del Perfil se presiona el botón Ver contraseña
        if(e.getSource() == panelCliente.jBVerContrasenia){
            if(panelCliente.jBVerContrasenia.getText().equals("Ver contraseña")){
                panelCliente.jPFContrasenia.setEchoChar((char) 0);
                panelCliente.jBVerContrasenia.setText("Ocultar contraseña");
            }else{
                panelCliente.jPFContrasenia.setEchoChar('•');
                panelCliente.jBVerContrasenia.setText("Ver contraseña");
            }
        }
        
        // Si en el panel del Perfil se presiona el botón Modificar perfil
        if(e.getSource() == panelCliente.jBModificarPerfil){
            if(panelCliente.jBModificarPerfil.getText().equals("Modificar perfil")){
                panelCliente.jTFCorreo.setEditable(true);
                panelCliente.jTFTelefono.setEditable(true);
                panelCliente.jPFContrasenia.setEditable(true);
                panelCliente.jBModificarPerfil.setText("Guardar cambios");
            }else{
                int op = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios realizados al Perfil?");
                
                if(op == JOptionPane.OK_OPTION) {
                    if(modeloDb.modificarCliente(panelCliente.jTFCorreo.getText(),
                                                 panelCliente.jTFTelefono.getText(),
                                                 String.valueOf(panelCliente.jPFContrasenia.getPassword()),
                                                 panelCliente.jTFCedula.getText()))
                        JOptionPane.showMessageDialog(null, "Cambios guardados con éxito.");
                }
                
                panelCliente.jTFCorreo.setEditable(false);
                panelCliente.jTFTelefono.setEditable(false);
                panelCliente.jPFContrasenia.setEditable(false);
                panelCliente.jBModificarPerfil.setText("Modificar perfil");
                cargarDatos();
            }
        }
        
    }
}