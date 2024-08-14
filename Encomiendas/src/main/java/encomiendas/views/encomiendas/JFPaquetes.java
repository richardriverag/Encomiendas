package encomiendas.views.encomiendas;

import encomiendas.controllers.encomiendas.PaqueteController;
import encomiendas.database.Conexion;
import encomiendas.model.data.encomiendas.PaqueteRepository;
import encomiendas.model.entity.encomiendas.Paquete;
import encomiendas.services.encomiendas.PaqueteService;
import java.util.ArrayList;
import java.util.List;

public class JFPaquetes extends javax.swing.JFrame {

    Conexion con = new Conexion();

    PaqueteRepository paqueteRepository;
    PaqueteService paqueteService;
    PaqueteController paqueteController;

    public List<Paquete> listaPaquetes = new ArrayList<>();

    public JFPaquetes() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Paquetes");

        //MOSTRAR PRECIO
        lblPrecioPaq.setVisible(false);
        txtPrecioPaquete.setVisible(false);
        btnAddPaquete.setVisible(false);

        //instancia del controlador
        paqueteRepository = new PaqueteRepository(con.getInstance());
        paqueteService = new PaqueteService(paqueteRepository);
        paqueteController = new PaqueteController(this, paqueteService);
        btnAddPaquete.setVisible(false);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosPaquete = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtVolPaquete = new javax.swing.JTextField();
        txtPesoPaquete = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCBIsFragil = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txtDescripPaquete = new javax.swing.JTextField();
        lblPrecioPaq = new javax.swing.JLabel();
        txtPrecioPaquete = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnAddPaquete = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnGuardarPaquete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMISalir = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelDatosPaquete.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del paquete"));

        jLabel3.setText("Volumen del paquete (m3) : ");

        jLabel2.setText("Peso del paquete (kg): ");

        jLabel4.setText("El paquete es fragil:");

        jCBIsFragil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBIsFragilActionPerformed(evt);
            }
        });

        jLabel5.setText("Descripción del paquete:");

        lblPrecioPaq.setText("Precio del paquete: ");

        javax.swing.GroupLayout panelDatosPaqueteLayout = new javax.swing.GroupLayout(panelDatosPaquete);
        panelDatosPaquete.setLayout(panelDatosPaqueteLayout);
        panelDatosPaqueteLayout.setHorizontalGroup(
            panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPaqueteLayout.createSequentialGroup()
                .addComponent(lblPrecioPaq, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPrecioPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelDatosPaqueteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosPaqueteLayout.createSequentialGroup()
                        .addGroup(panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosPaqueteLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(54, 54, 54))
                            .addGroup(panelDatosPaqueteLayout.createSequentialGroup()
                                .addGroup(panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPesoPaquete)
                                .addComponent(txtVolPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCBIsFragil, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDatosPaqueteLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(txtDescripPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDatosPaqueteLayout.setVerticalGroup(
            panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPaqueteLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDescripPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBIsFragil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioPaq)
                    .addComponent(txtPrecioPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnAddPaquete.setText("Agregar paquete");
        btnAddPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPaqueteActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar registro");
        btnCancelar.setToolTipText("");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnGuardarPaquete.setText("Guardar paquete");
        btnGuardarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPaqueteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(btnAddPaquete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarPaquete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnGuardarPaquete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(13, 13, 13)
                .addComponent(btnAddPaquete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolver)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jMISalir.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMISalir.add(jMenuItem1);

        jMenuBar1.add(jMISalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDatosPaquete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatosPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        paqueteController.actionPerformed(evt);
        this.setVisible(false);
        limpiar();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtDescripPaquete.setEditable(true);
        txtPesoPaquete.setEditable(true);
        txtVolPaquete.setEditable(true);
        jCBIsFragil.setEnabled(true);
        txtPesoPaquete.setEditable(true);

        paqueteController.actionPerformed(evt);
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jCBIsFragilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBIsFragilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBIsFragilActionPerformed

    private void btnAddPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPaqueteActionPerformed
        paqueteController.actionPerformed(evt);
    }//GEN-LAST:event_btnAddPaqueteActionPerformed

    private void btnGuardarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPaqueteActionPerformed
        txtDescripPaquete.setEditable(false);
        txtPesoPaquete.setEditable(false);
        txtVolPaquete.setEditable(false);
        jCBIsFragil.setEnabled(false);

        lblPrecioPaq.setVisible(true);
        txtPrecioPaquete.setVisible(true);
        paqueteController.actionPerformed(evt);
        btnGuardarPaquete.setVisible(false);
        
        txtPesoPaquete.setEditable(false);
    }//GEN-LAST:event_btnGuardarPaqueteActionPerformed

    public void limpiar() {
        txtDescripPaquete.setText("");
        txtPrecioPaquete.setText("");
        txtPesoPaquete.setText("");
        txtVolPaquete.setText("");
        jCBIsFragil.setSelected(false);
        lblPrecioPaq.setVisible(false);
        txtPrecioPaquete.setVisible(false);
        btnAddPaquete.setVisible(false);
        btnGuardarPaquete.setVisible(true);
    }

    public void limpiar2() {
        txtDescripPaquete.setText("");
        txtPrecioPaquete.setText("");
        txtPesoPaquete.setText("");
        txtVolPaquete.setText("");
        jCBIsFragil.setSelected(false);
        lblPrecioPaq.setVisible(false);
        txtPrecioPaquete.setVisible(false);
        btnAddPaquete.setVisible(false);
        btnGuardarPaquete.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(JFPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPaquetes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddPaquete;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardarPaquete;
    public javax.swing.JButton btnVolver;
    public javax.swing.JCheckBox jCBIsFragil;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMISalir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPrecioPaq;
    private javax.swing.JPanel panelDatosPaquete;
    public javax.swing.JTextField txtDescripPaquete;
    public javax.swing.JTextField txtPesoPaquete;
    public javax.swing.JTextField txtPrecioPaquete;
    public javax.swing.JTextField txtVolPaquete;
    // End of variables declaration//GEN-END:variables
}
