/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package encomiendas.views.usuarios;

/**
 *
 * @author USER-PC
 */
public class PanelAIngresoUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form PanelPerfil
     */
    public PanelAIngresoUsuarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMétodoIngreso = new javax.swing.JPanel();
        jPAIngresoUsuarios = new javax.swing.JPanel();
        jLCédula = new javax.swing.JLabel();
        jLNombres = new javax.swing.JLabel();
        jLApellidos = new javax.swing.JLabel();
        jLCorreo = new javax.swing.JLabel();
        jLTeléfonoPrincipal = new javax.swing.JLabel();
        jLCiudad = new javax.swing.JLabel();
        jLRol = new javax.swing.JLabel();
        jTeléfonoSecundario = new javax.swing.JLabel();
        jCBRol = new javax.swing.JComboBox<>();
        jLTípoLicencia = new javax.swing.JLabel();
        jCBTípoLicencia = new javax.swing.JComboBox<>();
        jLEstado = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox<>();
        jLTablaAgencía = new javax.swing.JLabel();
        jTFCédula = new javax.swing.JTextField();
        jTFNombres = new javax.swing.JTextField();
        jTFApellidos = new javax.swing.JTextField();
        jTFCorreo = new javax.swing.JTextField();
        jTFTeléfonoPrincipal = new javax.swing.JTextField();
        jTFTeléfonoSecundario = new javax.swing.JTextField();
        jTFCiudad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLAgencia = new javax.swing.JLabel();
        jTFAgencia = new javax.swing.JTextField();
        jLDirección = new javax.swing.JLabel();
        jTFDirección = new javax.swing.JTextField();
        jBIngresoUsuario = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(690, 430));
        setPreferredSize(new java.awt.Dimension(690, 430));

        jPMétodoIngreso.setBackground(new java.awt.Color(204, 0, 51));
        jPMétodoIngreso.setMinimumSize(new java.awt.Dimension(690, 430));
        jPMétodoIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLCédula.setText("Cédula:");

        jLNombres.setText("Nombres:");

        jLApellidos.setText("Apellidos:");

        jLCorreo.setText("Correo:");

        jLTeléfonoPrincipal.setText("Teléfono Principal:");

        jLCiudad.setText("Ciudad:");

        jLRol.setText("Rol:");

        jTeléfonoSecundario.setText("Teléfono Secundario:");

        jCBRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado", "Conductor" }));

        jLTípoLicencia.setText("Típo Licencia:");

        jCBTípoLicencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "B", "C", "E" }));

        jLEstado.setText("Estado:");

        jCBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habilitado", "Desabilitado", " ", " " }));

        jLTablaAgencía.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLTablaAgencía.setText("Tabla Agencia:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLAgencia.setText("Agencia:");

        jLDirección.setText("Dirección:");

        jBIngresoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBIngresoUsuario.setText("Ingreso de Usuario");
        jBIngresoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAIngresoUsuariosLayout = new javax.swing.GroupLayout(jPAIngresoUsuarios);
        jPAIngresoUsuarios.setLayout(jPAIngresoUsuariosLayout);
        jPAIngresoUsuariosLayout.setHorizontalGroup(
            jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAIngresoUsuariosLayout.createSequentialGroup()
                        .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLApellidos)
                                    .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLRol)
                                        .addComponent(jLCorreo)))
                                .addGap(18, 18, 18)
                                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
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
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLCiudad)
                                .addGap(18, 18, 18)
                                .addComponent(jTFCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAIngresoUsuariosLayout.createSequentialGroup()
                                .addComponent(jTeléfonoSecundario)
                                .addGap(18, 18, 18)
                                .addComponent(jTFTeléfonoSecundario))
                            .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLTeléfonoPrincipal)
                                    .addComponent(jLTípoLicencia)
                                    .addComponent(jLEstado))
                                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jCBTípoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAIngresoUsuariosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTFTeléfonoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAIngresoUsuariosLayout.createSequentialGroup()
                                .addComponent(jLDirección)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTFDirección, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)))
                .addContainerGap())
            .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jBIngresoUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPAIngresoUsuariosLayout.setVerticalGroup(
            jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAIngresoUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCédula)
                    .addComponent(jTFCédula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFDirección, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDirección))
                .addGap(15, 15, 15)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombres)
                    .addComponent(jTFNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTípoLicencia)
                    .addComponent(jCBTípoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLApellidos)
                    .addComponent(jTFApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEstado)
                    .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCorreo)
                    .addComponent(jTFCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTeléfonoPrincipal)
                    .addComponent(jTFTeléfonoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRol)
                    .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTeléfonoSecundario)
                    .addComponent(jTFTeléfonoSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPAIngresoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTablaAgencía)
                    .addComponent(jLAgencia)
                    .addComponent(jTFAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCiudad))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBIngresoUsuario)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPMétodoIngreso.add(jPAIngresoUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 680, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPMétodoIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPMétodoIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBIngresoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBIngresoUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBIngresoUsuario;
    private javax.swing.JComboBox<String> jCBEstado;
    private javax.swing.JComboBox<String> jCBRol;
    private javax.swing.JComboBox<String> jCBTípoLicencia;
    private javax.swing.JLabel jLAgencia;
    private javax.swing.JLabel jLApellidos;
    private javax.swing.JLabel jLCiudad;
    private javax.swing.JLabel jLCorreo;
    private javax.swing.JLabel jLCédula;
    private javax.swing.JLabel jLDirección;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLNombres;
    private javax.swing.JLabel jLRol;
    private javax.swing.JLabel jLTablaAgencía;
    private javax.swing.JLabel jLTeléfonoPrincipal;
    private javax.swing.JLabel jLTípoLicencia;
    private javax.swing.JPanel jPAIngresoUsuarios;
    private javax.swing.JPanel jPMétodoIngreso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFAgencia;
    private javax.swing.JTextField jTFApellidos;
    private javax.swing.JTextField jTFCiudad;
    private javax.swing.JTextField jTFCorreo;
    private javax.swing.JTextField jTFCédula;
    private javax.swing.JTextField jTFDirección;
    private javax.swing.JTextField jTFNombres;
    private javax.swing.JTextField jTFTeléfonoPrincipal;
    private javax.swing.JTextField jTFTeléfonoSecundario;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTeléfonoSecundario;
    // End of variables declaration//GEN-END:variables
}