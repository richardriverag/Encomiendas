package encomiendas.views.usuarios;

import encomiendas.views.encomiendas.JFEncomiendas;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class MenuConductor extends javax.swing.JFrame {

    public MenuConductor() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPDefault = new javax.swing.JPanel();
        lblBienvenidosCon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnEncomiendas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTFUsuarioConductor = new javax.swing.JTextField();
        jLCliente = new javax.swing.JLabel();
        btPerfilCon1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú - Cliente");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPDefault.setBackground(new java.awt.Color(37, 37, 61));

        lblBienvenidosCon.setFont(new java.awt.Font("Segoe UI", 3, 44)); // NOI18N
        lblBienvenidosCon.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenidosCon.setText("BIENVENIDO ");

        javax.swing.GroupLayout jPDefaultLayout = new javax.swing.GroupLayout(jPDefault);
        jPDefault.setLayout(jPDefaultLayout);
        jPDefaultLayout.setHorizontalGroup(
            jPDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDefaultLayout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(lblBienvenidosCon)
                .addGap(195, 195, 195))
        );
        jPDefaultLayout.setVerticalGroup(
            jPDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDefaultLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(lblBienvenidosCon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jPanel1.add(jPDefault, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 690, 430));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEncomiendas.setBackground(new java.awt.Color(200, 0, 0));
        btnEncomiendas.setForeground(new java.awt.Color(255, 255, 255));
        btnEncomiendas.setText("Abrir encomiendas");
        btnEncomiendas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 255, 255), null, null));
        btnEncomiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncomiendasActionPerformed(evt);
            }
        });
        jPanel2.add(btnEncomiendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 150, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize()-2f));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo - copia.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 90));

        jTFUsuarioConductor.setEditable(false);
        jPanel2.add(jTFUsuarioConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 130, -1));

        jLCliente.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCliente.setText("Conductor:");
        jPanel2.add(jLCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, -1));

        btPerfilCon1.setBackground(new java.awt.Color(200, 0, 0));
        btPerfilCon1.setForeground(new java.awt.Color(255, 255, 255));
        btPerfilCon1.setText("Perfil");
        btPerfilCon1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 255, 255), null, null));
        jPanel2.add(btPerfilCon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 150, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncomiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncomiendasActionPerformed
        JFEncomiendas vistaEncomienda = new JFEncomiendas();
        vistaEncomienda.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        vistaEncomienda.panelDatos.setVisible(false);
        vistaEncomienda.panelOpciones.setVisible(false);
        vistaEncomienda.infoEncomienda.panelOpEmpleado.setVisible(false);
        vistaEncomienda.infoEncomienda.panelConductores.setVisible(true);
        vistaEncomienda.setVisible(true);
        vistaEncomienda.encomiendaController.mostrarEncomiendaCliente((DefaultTableModel) vistaEncomienda.jTEncomiendas.getModel(), jTFUsuarioConductor.getText());
    }//GEN-LAST:event_btnEncomiendasActionPerformed

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
            java.util.logging.Logger.getLogger(MenuConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuConductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btPerfilCon1;
    public javax.swing.JButton btnEncomiendas;
    private javax.swing.JLabel jLCliente;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPDefault;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField jTFUsuarioConductor;
    private javax.swing.JLabel lblBienvenidosCon;
    // End of variables declaration//GEN-END:variables
}
