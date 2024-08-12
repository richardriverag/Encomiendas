package encomiendas.controllers.usuarios;

import encomiendas.model.data.usuarios.DbEmpleado;
import encomiendas.model.entity.usuarios.Cuenta;
import encomiendas.model.entity.usuarios.Empleado;
import encomiendas.views.usuarios.MenuEmpleado;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Atik
 */
public class empleadoController implements ActionListener {

    private DbEmpleado modEmpleadoDb;
    private Empleado modEmp;
    private Cuenta modCuenta;
    private MenuEmpleado frmEmpMenu;

    public empleadoController(DbEmpleado modEmpleadoDb, Empleado modEmp, Cuenta modCuenta, MenuEmpleado frmEmpMenu) {
        this.modEmpleadoDb = modEmpleadoDb;
        this.modEmp = modEmp;
        this.modCuenta = modCuenta;
        this.frmEmpMenu = frmEmpMenu;

        this.frmEmpMenu.btEPerfil.addActionListener(this);
        this.frmEmpMenu.btEClientes.addActionListener(this);
        this.frmEmpMenu.btEConductores.addActionListener(this);
        this.frmEmpMenu.btECredencial.addActionListener(this);
    }

    public void cargarDatos() {
        ImageIcon imagen;
        if (modEmp.getFotoPerfil() == null) {
            imagen = new ImageIcon(new ImageIcon("src/main/resources/fotoPerfilDefault.jpg").getImage().getScaledInstance(157, 157, Image.SCALE_DEFAULT));
            frmEmpMenu.jLFotoPerfilE.setIcon(imagen);
        } else {
            ImageIcon img = new ImageIcon(modEmp.getFotoPerfil());
            imagen = new ImageIcon(img.getImage().getScaledInstance(157, 157, Image.SCALE_DEFAULT));
            frmEmpMenu.jLFotoPerfilE.setIcon(imagen);
        }
    }

    public void iniciar() {
        frmEmpMenu.setLocationRelativeTo(null);
        frmEmpMenu.setVisible(true);
        cargarDatos();
    }

    @Override
    public void actionPerformed(ActionEvent c) {
        if (c.getSource() == frmEmpMenu.btEPerfil) {
            modEmp.setCedula((frmEmpMenu.jTFUsuarioEmpleado.getText()));
            modEmp.obtenerDatos(modEmp.getCedula());
            frmEmpMenu.jFTNombresE.setText(modEmp.getNombres());
            frmEmpMenu.jTFApellidoE.setText(modEmp.getApellidos());
            frmEmpMenu.jTFCedulaE.setText(modEmp.getCedula());
            frmEmpMenu.jTFCorreoE.setText(modEmp.getCorreo());
            frmEmpMenu.jTFTelefonoE.setText(modEmp.getTelefono());
        }

        if (c.getSource() == frmEmpMenu.btECredencial) {
            modCuenta.setCedula((frmEmpMenu.jTFUsuarioEmpleado.getText()));
            modCuenta.obtenerDatosCuenta(modCuenta.getCedula());
            frmEmpMenu.jTFUsuarioE.setText(modCuenta.getUsername());
            frmEmpMenu.jTFContrasenia.setText(modCuenta.getContrasenia());
        }

        if (c.getSource() == frmEmpMenu.btEClientes) {

            //Cargar los datos 
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Cédula");
            model.addColumn("Nombres");
            model.addColumn("Apellidos");
            model.addColumn("Correo");
            model.addColumn("Teléfono");
            model.addColumn("Rol");
            model.addColumn("Dirección");
            model.addColumn("Ciudad");
            model.addColumn("Teléfono Adicional");
            model.addColumn("Estado");
            model.addColumn("IdAgencia");

            List<Object[]> empleados = modEmpleadoDb.ListaEmpleados();

            for (Object[] empleado : empleados) {
                model.addRow(empleado);
            }

            frmEmpMenu.jTbEClientes.setModel(model);
        }

        if (c.getSource() == frmEmpMenu.btEConductores) {
            //Cargar los datos 
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Cédula");
            model.addColumn("Nombres");
            model.addColumn("Apellidos");
            model.addColumn("Correo");
            model.addColumn("Teléfono");
            model.addColumn("Rol");
            model.addColumn("Dirección");
            model.addColumn("Ciudad");
            model.addColumn("Teléfono Adicional");
            model.addColumn("Estado");
            model.addColumn("IdAgencia");

            List<Object[]> empleados = modEmpleadoDb.ListaConductores();

            for (Object[] empleado : empleados) {
                model.addRow(empleado);
            }

            frmEmpMenu.jTbConductores.setModel(model);
        }

        // Si en el panel del Perfil se presiona el botón Cambiar foto
        if (c.getSource() == frmEmpMenu.jBCambiarFoto) {
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

                    if (modEmpleadoDb.cambiarImagenPerfil(bytesImagen, modEmp.getCedula())) {
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
