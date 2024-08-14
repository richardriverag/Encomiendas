/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package encomiendas.views.encomiendas;

import encomiendas.controllers.encomiendas.PaqueteController;
import encomiendas.database.Conexion;
import encomiendas.model.data.encomiendas.PaqueteRepository;
import encomiendas.services.encomiendas.PaqueteService;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author djimm
 */
public class JFListaPaquetesByEncomienda extends javax.swing.JFrame {

    public JFListaPaquetesByEncomienda() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Lista de paquetes");

    }

    JFPaquetes paquetes = new JFPaquetes();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTListaPaquetes = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Lista de paquetes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, -1, -1));

        btnVolver.setText("Volver");
        btnVolver.setToolTipText("");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 245, 102, -1));

        jTListaPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Hola",  new Float(12.0),  new Float(2.0),  new Boolean(true), null},
                {"Jeje",  new Float(2.0),  new Float(3.0), null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Descripcion", "Peso", "Volumen", "Es frágil", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Boolean.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTListaPaquetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListaPaquetesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTListaPaquetes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 53, 629, 174));

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTListaPaquetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListaPaquetesMouseClicked
        int index = jTListaPaquetes.getSelectedRow();
        TableModel model = jTListaPaquetes.getModel();
        String descripcion = model.getValueAt(index, 0).toString();
        String pesoPaquete = model.getValueAt(index, 1).toString();
        String volumenPaquete = model.getValueAt(index, 2).toString();
        Boolean isFragil = (Boolean) model.getValueAt(index, 3);
        String precioPaquete = model.getValueAt(index, 4).toString();

        paquetes.setVisible(true);
        paquetes.pack();
        paquetes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        paquetes.btnAddPaquete.setVisible(false);
        paquetes.btnGuardarPaquete.setVisible(false);
        paquetes.btnCancelar.setVisible(false);

        paquetes.txtDescripPaquete.setText(descripcion);
        paquetes.txtPesoPaquete.setText(pesoPaquete);
        // Crear un formateador para dos decimales
        DecimalFormat df = new DecimalFormat("#.##");

        // Convertir el valor de volumenPaquete a double y formatearlo
        double volumen = Double.parseDouble(volumenPaquete);
        String volumenFormateado = df.format(volumen);

        // Convertir el valor de precioPaquete a double y formatearlo
        double precio = Double.parseDouble(precioPaquete);
        String precioFormateado = df.format(precio);

        paquetes.txtVolPaquete.setText(volumenFormateado);
        paquetes.txtPrecioPaquete.setText(precioFormateado);
        paquetes.jCBIsFragil.setSelected(isFragil);
        
        
        paquetes.txtDescripPaquete.setEditable(false);
        paquetes.txtPesoPaquete.setEditable(false);
        paquetes.txtVolPaquete.setEditable(false);
        paquetes.txtPrecioPaquete.setEditable(false);
        paquetes.jCBIsFragil.setEnabled(false);

    }//GEN-LAST:event_jTListaPaquetesMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(JFListaPaquetesByEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFListaPaquetesByEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFListaPaquetesByEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFListaPaquetesByEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new JFListaPaquetesByEncomienda().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTListaPaquetes;
    // End of variables declaration//GEN-END:variables
}
