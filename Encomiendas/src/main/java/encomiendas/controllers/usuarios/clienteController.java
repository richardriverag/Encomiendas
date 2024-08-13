package encomiendas.controllers.usuarios;

import encomiendas.model.data.usuarios.DbCliente;
import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.model.entity.usuarios.Cuenta;
import encomiendas.views.usuarios.MenuClientes;
import encomiendas.views.usuarios.PanelPerfilClientes;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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

    public void cargarDatos() {
        modCliente.setCedula((frmCliente.jTFUsuarioCliente.getText()));
        modCliente.obtenerDatos(modCliente.getCedula());
        panelCliente.jFTNombres.setText(modCliente.getNombres());
        panelCliente.jTFApellido.setText(modCliente.getApellidos());
        panelCliente.jTFCedula.setText(modCliente.getCedula());
        panelCliente.jTFCorreo.setText(modCliente.getCorreo());
        panelCliente.jTFTelefono.setText(modCliente.getTelefono());
        ImageIcon imagen;
        if (modCliente.getFotoPerfil() == null) {
            imagen = new ImageIcon(new ImageIcon("src/main/resources/fotoPerfilDefault.jpg").getImage().getScaledInstance(157, 157, Image.SCALE_DEFAULT));
            panelCliente.jLFotoPerfil.setIcon(imagen);
        } else {
            ImageIcon img = new ImageIcon(modCliente.getFotoPerfil());
            imagen = new ImageIcon(img.getImage().getScaledInstance(157, 157, Image.SCALE_DEFAULT));
            panelCliente.jLFotoPerfil.setIcon(imagen);
        }

        modCuenta.setCedula((frmCliente.jTFUsuarioCliente.getText()));
        modCuenta.obtenerDatosCuenta(modCuenta.getCedula());
        panelCliente.jTFUsuario.setText(modCuenta.getUsername());
        panelCliente.jPFContrasenia.setText(modCuenta.getContrasenia());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Si presiona en el botón Perfil se activa y muestra el panel con la info del Perfil
        if (e.getSource() == frmCliente.btPerfil) {
            PanelPerfilClientes panel1 = new PanelPerfilClientes();
            panel1.setSize(690, 430);
            panel1.setLocation(0, 0);

            this.panelCliente = panel1;
            this.panelCliente.jBModificarPerfil.addActionListener(this);
            this.panelCliente.jBVerContrasenia.addActionListener(this);
            this.panelCliente.jBCambiarFoto.addActionListener(this);

            frmCliente.jPDefault.removeAll();
            frmCliente.jPDefault.add(panelCliente, BorderLayout.CENTER);
            frmCliente.jPDefault.revalidate();
            frmCliente.jPDefault.repaint();

            cargarDatos();
        }

        // Si en el panel del Perfil se presiona el botón Ver contraseña
        if (e.getSource() == panelCliente.jBVerContrasenia) {
            if (panelCliente.jBVerContrasenia.getText().equals("Ver contraseña")) {
                panelCliente.jPFContrasenia.setEchoChar((char) 0);
                panelCliente.jBVerContrasenia.setText("Ocultar contraseña");
            } else {
                panelCliente.jPFContrasenia.setEchoChar('•');
                panelCliente.jBVerContrasenia.setText("Ver contraseña");
            }
        }

        // Si en el panel del Perfil se presiona el botón Modificar perfil
        if (e.getSource() == panelCliente.jBModificarPerfil) {
            if (panelCliente.jBModificarPerfil.getText().equals("Modificar perfil")) {
                panelCliente.jTFCorreo.setEditable(true);
                panelCliente.jTFTelefono.setEditable(true);
                panelCliente.jPFContrasenia.setEditable(true);
                panelCliente.jBModificarPerfil.setText("Guardar cambios");
            } else {
                int op = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios realizados al Perfil?");

                if (op == JOptionPane.OK_OPTION) {
                    if (modeloDb.modificarCliente(panelCliente.jTFCorreo.getText(),
                            panelCliente.jTFTelefono.getText(),
                            String.valueOf(panelCliente.jPFContrasenia.getPassword()),
                            panelCliente.jTFCedula.getText())) {
                        JOptionPane.showMessageDialog(null, "Cambios guardados con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                panelCliente.jTFCorreo.setEditable(false);
                panelCliente.jTFTelefono.setEditable(false);
                panelCliente.jPFContrasenia.setEditable(false);
                panelCliente.jBModificarPerfil.setText("Modificar perfil");
                cargarDatos();
            }
        }

        // Si en el panel del Perfil se presiona el botón Cambiar foto
        if (e.getSource() == panelCliente.jBCambiarFoto) {
            JFileChooser seleccion = new JFileChooser();
            seleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
            seleccion.setAcceptAllFileFilterUsed(false);
            seleccion.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes (*.jpg; *.png)", "jpg", "png"));
            int op = seleccion.showOpenDialog(null);
            if (op == JFileChooser.APPROVE_OPTION) {
                FileInputStream fis = null;
                try {
                    File imagen = seleccion.getSelectedFile();
                    byte[] bytesImagen = new byte[(int) imagen.length()];
                    fis = new FileInputStream(imagen);
                    fis.read(bytesImagen);
                    fis.close();

                    if (modeloDb.cambiarImagenPerfil(bytesImagen, modCliente.getCedula())) {
                        JOptionPane.showMessageDialog(null, "Foto de perfil cambiada con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al cargar la foto de perfil.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    cargarDatos();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(clienteController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(clienteController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(clienteController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }

    }
}
