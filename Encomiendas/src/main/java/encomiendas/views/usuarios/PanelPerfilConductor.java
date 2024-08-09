package encomiendas.views.usuarios;

public class PanelPerfilConductor extends javax.swing.JPanel {

    public PanelPerfilConductor() {
        initComponents();
        // Comentario para erreglar el PANEL PerfilClientes
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblNombresCond = new javax.swing.JLabel();
        lblApellidoCon = new javax.swing.JLabel();
        lblCedulaCon = new javax.swing.JLabel();
        lblCorreoCon = new javax.swing.JLabel();
        lblTelefonoCon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCuentaCon = new javax.swing.JLabel();
        lblUsuarioCon = new javax.swing.JLabel();
        lblContraseniaCon = new javax.swing.JLabel();
        jFTNombresCon = new javax.swing.JTextField();
        jTFApellidoCon = new javax.swing.JTextField();
        jTFCedulaCon = new javax.swing.JTextField();
        jTFCorreoCon = new javax.swing.JTextField();
        jTFTelefonoCon = new javax.swing.JTextField();
        jTFUsuarioCon = new javax.swing.JTextField();
        jPFContraseniaCon = new javax.swing.JPasswordField();
        lblFotoPerfilCon = new javax.swing.JLabel();
        jLFotoPerfilCond = new javax.swing.JLabel();
        jBVerContraseniaCon = new javax.swing.JButton();
        jBModificarPerfilCon = new javax.swing.JButton();
        jBCambiarFotoCon = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(690, 430));
        setPreferredSize(new java.awt.Dimension(690, 430));

        jPanel1.setBackground(new java.awt.Color(204, 0, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(690, 430));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombresCond.setText("Nombres:");

        lblApellidoCon.setText("Apellido:");

        lblCedulaCon.setText("Cédula:");

        lblCorreoCon.setText("Correo:");

        lblTelefonoCon.setText("Teléfono:");

        lblCuentaCon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCuentaCon.setText("Cuenta");

        lblUsuarioCon.setText("Usuario:");

        lblContraseniaCon.setText("Contraseña:");

        jFTNombresCon.setEditable(false);

        jTFApellidoCon.setEditable(false);

        jTFCedulaCon.setEditable(false);

        jTFCorreoCon.setEditable(false);

        jTFTelefonoCon.setEditable(false);

        jTFUsuarioCon.setEditable(false);

        jPFContraseniaCon.setEditable(false);

        lblFotoPerfilCon.setText("Foto de perfil:");

        jLFotoPerfilCond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jBVerContraseniaCon.setText("Ver contraseña");

        jBModificarPerfilCon.setText("Modificar perfil");

        jBCambiarFotoCon.setText("Cambiar foto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBModificarPerfilCon)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblUsuarioCon)
                                        .addComponent(lblCuentaCon)
                                        .addComponent(lblContraseniaCon))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTFUsuarioCon)
                                        .addComponent(jPFContraseniaCon, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jBVerContraseniaCon)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombresCond)
                            .addComponent(lblApellidoCon)
                            .addComponent(lblTelefonoCon)
                            .addComponent(lblCorreoCon)
                            .addComponent(lblCedulaCon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFTNombresCon, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(jTFApellidoCon)
                            .addComponent(jTFCedulaCon)
                            .addComponent(jTFCorreoCon)
                            .addComponent(jTFTelefonoCon))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lblFotoPerfilCon))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLFotoPerfilCond, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBCambiarFotoCon)
                .addGap(111, 111, 111))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombresCond)
                    .addComponent(jFTNombresCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFotoPerfilCon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellidoCon)
                            .addComponent(jTFApellidoCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedulaCon)
                            .addComponent(jTFCedulaCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCorreoCon)
                            .addComponent(jTFCorreoCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefonoCon)
                            .addComponent(jTFTelefonoCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLFotoPerfilCond, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCambiarFotoCon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCuentaCon)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarioCon)
                    .addComponent(jTFUsuarioCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseniaCon)
                    .addComponent(jPFContraseniaCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBVerContraseniaCon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBModificarPerfilCon)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBCambiarFotoCon;
    public javax.swing.JButton jBModificarPerfilCon;
    public javax.swing.JButton jBVerContraseniaCon;
    public javax.swing.JTextField jFTNombresCon;
    public javax.swing.JLabel jLFotoPerfilCond;
    public javax.swing.JPasswordField jPFContraseniaCon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField jTFApellidoCon;
    public javax.swing.JTextField jTFCedulaCon;
    public javax.swing.JTextField jTFCorreoCon;
    public javax.swing.JTextField jTFTelefonoCon;
    public javax.swing.JTextField jTFUsuarioCon;
    private javax.swing.JLabel lblApellidoCon;
    private javax.swing.JLabel lblCedulaCon;
    private javax.swing.JLabel lblContraseniaCon;
    private javax.swing.JLabel lblCorreoCon;
    private javax.swing.JLabel lblCuentaCon;
    private javax.swing.JLabel lblFotoPerfilCon;
    private javax.swing.JLabel lblNombresCond;
    private javax.swing.JLabel lblTelefonoCon;
    private javax.swing.JLabel lblUsuarioCon;
    // End of variables declaration//GEN-END:variables
}
