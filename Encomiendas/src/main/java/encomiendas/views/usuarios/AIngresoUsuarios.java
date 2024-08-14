/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package encomiendas.views.usuarios;

import encomiendas.controllers.usuarios.AdministradorController;
import encomiendas.database.Conexion;
import encomiendas.model.data.usuarios.UsuarioRepository;
import encomiendas.model.entity.usuarios.Administrador;
import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.model.entity.usuarios.Conductor;
import encomiendas.model.entity.usuarios.Empleado;
import encomiendas.model.entity.usuarios.Usuario;
import encomiendas.services.usuarios.UsuarioService;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kedos
 */
public class AIngresoUsuarios extends javax.swing.JFrame {

    Conexion con = new Conexion();

    UsuarioRepository usuarioRepository;
    UsuarioService usuarioService;

    AdministradorController administradorController;

    public AIngresoUsuarios() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Ingreso de usuarios");

        //instancia del controlador
        usuarioRepository = new UsuarioRepository(con.getInstance());
        usuarioService = new UsuarioService(usuarioRepository);

        administradorController = new AdministradorController(this, usuarioService);

        // Bloquear campos al iniciar la ventana
        bloquearCampos();

    }

    private void resetearCampos() {
        jTFCédula.setText("");
        jTFNombres.setText("");
        jTFApellidos.setText("");
        jTFCorreo.setText("");
        jTFTeléfono.setText("");
        jTFTeléfonoAdicional.setText("");
        jTFCiudad.setText("");
        jTFAgencia.setText("");

        jCBRol.setSelectedIndex(0); // Selecciona el primer elemento del ComboBox
        jCBTipoLicencia.setSelectedIndex(0); // Selecciona el primer elemento del ComboBox
        jCBActivo.setSelectedIndex(0); // Selecciona el primer elemento del ComboBox

        // Si tienes botones u otros componentes que necesitan restablecerse, puedes hacerlo aquí.
    }

    private void bloquearCampos() {
        jTFCédula.setEnabled(false);
        jTFNombres.setEnabled(false);
        jTFApellidos.setEnabled(false);
        jTFCorreo.setEnabled(false);
        jTFTeléfono.setEnabled(false);
        jTFTeléfonoAdicional.setEnabled(false);
        jTFCiudad.setEnabled(false);
        jCBTipoLicencia.setEnabled(false);
        jCBActivo.setEnabled(false);
        jTFAgencia.setEnabled(false);
        jBIngresoUsuario.setEnabled(false);
    }

    private void desbloquearCampos() {
        jTFCédula.setEnabled(true);
        jTFNombres.setEnabled(true);
        jTFApellidos.setEnabled(true);
        jTFCorreo.setEnabled(true);
        jTFTeléfono.setEnabled(true);
        jTFTeléfonoAdicional.setEnabled(true);
        jTFCiudad.setEnabled(true);
        jCBRol.setEnabled(true);
        jCBActivo.setEnabled(true);
        jTFAgencia.setEnabled(true);
        jBIngresoUsuario.setEnabled(true);
    }

    private void registrarUsuario() {
        // Obtener los datos del formulario
        String cedula = jTFCédula.getText();
        String nombres = jTFNombres.getText();
        String apellidos = jTFApellidos.getText();
        String correo = jTFCorreo.getText();
        String telefono = jTFTeléfono.getText();
        String telefonoAdicional = jTFTeléfonoAdicional.getText();
        String ciudad = jTFCiudad.getText();
        String tipoLicencia;
        boolean activo = jCBActivo.getSelectedItem().equals("Habilitado");
        int idAgencia = Integer.parseInt(jTFAgencia.getText()); // Implementa cómo obtener el ID de la agencia seleccionada.
        String rol = (String) jCBRol.getSelectedItem();

        // Crear un objeto Usuario según el rol seleccionado
        Usuario usuario;
        switch (rol) {
            case "Administrador":
                usuario = new Administrador();
                break;
            case "Conductor":
                usuario = new Conductor();
                tipoLicencia = (String) jCBTipoLicencia.getSelectedItem();
                ((Conductor) usuario).setTipoLicencia(tipoLicencia);
                break;
            case "Empleado":
                usuario = new Empleado();
                break;
            default:
                throw new IllegalArgumentException("Rol desconocido: " + rol);
        }

        // Asignar los datos comunes
        usuario.setCedula(cedula);
        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos);
        usuario.setCorreo(correo);
        usuario.setTelefono(telefono);
        usuario.setCiudad(ciudad);
        usuario.setTelefonoAdicional(telefonoAdicional);
        usuario.setActivo(activo);
        usuario.setIdAgencia(idAgencia);

        try {
            administradorController.registrarUsuarioYCrearCuenta(usuario);
            JOptionPane.showMessageDialog(this, "Usuario registrado y cuenta creada exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar el usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPAIngresoUsuarios = new javax.swing.JPanel();
        jLCédula = new javax.swing.JLabel();
        jLNombres = new javax.swing.JLabel();
        jLApellidos = new javax.swing.JLabel();
        jLCorreo = new javax.swing.JLabel();
        jLTeléfonoPrincipal = new javax.swing.JLabel();
        jLCiudad = new javax.swing.JLabel();
        jLRol = new javax.swing.JLabel();
        jTeléfonoAdicional = new javax.swing.JLabel();
        jCBRol = new javax.swing.JComboBox<>();
        jLTípoLicencia = new javax.swing.JLabel();
        jCBTipoLicencia = new javax.swing.JComboBox<>();
        jLActivo = new javax.swing.JLabel();
        jCBActivo = new javax.swing.JComboBox<>();
        jLTablaAgencía = new javax.swing.JLabel();
        jTFCédula = new javax.swing.JTextField();
        jTFNombres = new javax.swing.JTextField();
        jTFApellidos = new javax.swing.JTextField();
        jTFCorreo = new javax.swing.JTextField();
        jTFTeléfono = new javax.swing.JTextField();
        jTFTeléfonoAdicional = new javax.swing.JTextField();
        jTFCiudad = new javax.swing.JTextField();
        jLAgencia = new javax.swing.JLabel();
        jTFAgencia = new javax.swing.JTextField();
        jBIngresoUsuario = new javax.swing.JButton();
        jBLimpiarVentana = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLCédula.setText("Cédula:");

        jLNombres.setText("Nombres:");

        jLApellidos.setText("Apellidos:");

        jLCorreo.setText("Correo:");

        jLTeléfonoPrincipal.setText("Teléfono:");

        jLCiudad.setText("Ciudad:");

        jLRol.setText("Rol:");

        jTeléfonoAdicional.setText("Teléfono Adicional:");

        jCBRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado", "Conductor" }));
        jCBRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRolActionPerformed(evt);
            }
        });

        jLTípoLicencia.setText("Típo Licencia:");

        jCBTipoLicencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "B", "C", "E" }));

        jLActivo.setText("Activo:");

        jCBActivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habilitado" }));

        jLTablaAgencía.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLTablaAgencía.setText("Tabla Agencia:");

        jLAgencia.setText("Agencia:");

        jBIngresoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBIngresoUsuario.setText("Ingreso de Usuario");
        jBIngresoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresoUsuarioActionPerformed(evt);
            }
        });

        jBLimpiarVentana.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBLimpiarVentana.setText("Limpiar Ventana");
        jBLimpiarVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarVentanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAIngresoUsuariosLayout = new javax.swing.GroupLayout(jPAIngresoUsuarios);
        jPAIngresoUsuarios.setLayout(jPAIngresoUsuariosLayout);
        jPAIngresoUsuariosLayout.setHorizontalGroup(
            jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                        .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLApellidos)
                            .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLRol)
                                .addComponent(jLCorreo)))
                        .addGap(18, 18, 18)
                        .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFApellidos)
                            .addComponent(jTFCorreo)
                            .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                        .addComponent(jLTablaAgencía)
                        .addGap(33, 33, 33)
                        .addComponent(jLAgencia)
                        .addGap(18, 18, 18)
                        .addComponent(jTFAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                        .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLNombres)
                            .addComponent(jLCédula))
                        .addGap(18, 18, 18)
                        .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFCédula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAIngresoUsuariosLayout.createSequentialGroup()
                        .addComponent(jTeléfonoAdicional)
                        .addGap(18, 18, 18)
                        .addComponent(jTFTeléfonoAdicional))
                    .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                        .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLTeléfonoPrincipal)
                            .addComponent(jLTípoLicencia)
                            .addComponent(jLActivo))
                        .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAIngresoUsuariosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTFTeléfono, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBTipoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAIngresoUsuariosLayout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(jLCiudad)
                        .addGap(18, 18, 18)
                        .addComponent(jTFCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
            .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jBIngresoUsuario)
                .addGap(160, 160, 160)
                .addComponent(jBLimpiarVentana)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPAIngresoUsuariosLayout.setVerticalGroup(
            jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCédula)
                    .addComponent(jTFCédula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombres)
                    .addComponent(jTFNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTípoLicencia)
                    .addComponent(jCBTipoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLApellidos)
                    .addComponent(jTFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLActivo)
                    .addComponent(jCBActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCorreo)
                    .addComponent(jTFCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTeléfonoPrincipal)
                    .addComponent(jTFTeléfono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRol)
                    .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTeléfonoAdicional)
                    .addComponent(jTFTeléfonoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTablaAgencía)
                    .addComponent(jLAgencia)
                    .addComponent(jTFAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCiudad))
                .addGap(18, 18, 18)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIngresoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpiarVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPAIngresoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 22, Short.MAX_VALUE)
                    .addComponent(jPAIngresoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 23, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBIngresoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresoUsuarioActionPerformed
        // Llamar al método registrarUsuario cuando el botón es clickeado
        registrarUsuario();
        bloquearCampos();
    }//GEN-LAST:event_jBIngresoUsuarioActionPerformed

    private void jCBRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRolActionPerformed
        String selectedRole = (String) jCBRol.getSelectedItem();

        // Habilitar campos según el rol seleccionado
        switch (selectedRole) {
            case "Administrador":
                // Campos adicionales para Administrador
                desbloquearCampos();
                break;
            case "Empleado":
                // Campos adicionales para Empleado
                desbloquearCampos();
                break;
            case "Conductor":
                desbloquearCampos();
                jCBTipoLicencia.setEnabled(true);
                break;
        }

    }//GEN-LAST:event_jCBRolActionPerformed

    private void jBLimpiarVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarVentanaActionPerformed
        // Restablecer campos al iniciar la ventana
        resetearCampos();
    }//GEN-LAST:event_jBLimpiarVentanaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AIngresoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AIngresoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AIngresoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AIngresoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AIngresoUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBIngresoUsuario;
    private javax.swing.JButton jBLimpiarVentana;
    private javax.swing.JComboBox<String> jCBActivo;
    private javax.swing.JComboBox<String> jCBRol;
    private javax.swing.JComboBox<String> jCBTipoLicencia;
    private javax.swing.JLabel jLActivo;
    private javax.swing.JLabel jLAgencia;
    private javax.swing.JLabel jLApellidos;
    private javax.swing.JLabel jLCiudad;
    private javax.swing.JLabel jLCorreo;
    private javax.swing.JLabel jLCédula;
    private javax.swing.JLabel jLNombres;
    private javax.swing.JLabel jLRol;
    private javax.swing.JLabel jLTablaAgencía;
    private javax.swing.JLabel jLTeléfonoPrincipal;
    private javax.swing.JLabel jLTípoLicencia;
    private javax.swing.JPanel jPAIngresoUsuarios;
    private javax.swing.JTextField jTFAgencia;
    private javax.swing.JTextField jTFApellidos;
    private javax.swing.JTextField jTFCiudad;
    private javax.swing.JTextField jTFCorreo;
    private javax.swing.JTextField jTFCédula;
    private javax.swing.JTextField jTFNombres;
    private javax.swing.JTextField jTFTeléfono;
    private javax.swing.JTextField jTFTeléfonoAdicional;
    private javax.swing.JLabel jTeléfonoAdicional;
    // End of variables declaration//GEN-END:variables
}
