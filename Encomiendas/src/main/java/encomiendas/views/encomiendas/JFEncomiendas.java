package encomiendas.views.encomiendas;

import encomiendas.controllers.encomiendas.EncomiendaController;
import encomiendas.controllers.encomiendas.PaqueteController;
import encomiendas.database.Conexion;
import encomiendas.model.data.Agencia.AgenciaRepository;
import encomiendas.model.data.encomiendas.EncomiendaRepository;
import encomiendas.model.data.encomiendas.PaqueteRepository;
import encomiendas.model.data.usuarios.ClienteRepository;
import encomiendas.model.entity.encomiendas.Encomienda;
import encomiendas.model.entity.encomiendas.Paquete;
import encomiendas.services.encomiendas.EncomiendaService;
import encomiendas.services.encomiendas.PaqueteService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class JFEncomiendas extends javax.swing.JFrame {

    Conexion con = new Conexion();

    PaqueteRepository paqueteRepository;
    PaqueteService paqueteService;
    PaqueteController paqueteController;
    public JFInfoEncomiendas infoEncomienda = new JFInfoEncomiendas();

    private Encomienda encomienda = new Encomienda();
    EncomiendaRepository encomiendaRepository;
    public EncomiendaController encomiendaController;

    ClienteRepository clienteRepository;
    AgenciaRepository agenciaRepository;

    EncomiendaService encomiedaService;

    JFPaquetes ventanaPaquete = new JFPaquetes();

    public List<Paquete> listaPaquete = new ArrayList<>();

    public JFEncomiendas() {

        initComponents();
        panelInterprovincial.setVisible(false);
        panelEntregaDomicilio.setVisible(false);
        btnCrearEncomienda.setVisible(false);
        this.setLocationRelativeTo(this);
        this.setTitle("Panel de encomiendas");

        //instancia del controlador
        paqueteRepository = new PaqueteRepository(con.getInstance());
        clienteRepository = new ClienteRepository(con.getInstance());
        agenciaRepository = new AgenciaRepository(con.getInstance());

        paqueteService = new PaqueteService(paqueteRepository);
        paqueteController = new PaqueteController(this, paqueteService);

        encomiendaRepository = new EncomiendaRepository(con.getInstance());
        encomiedaService = new EncomiendaService(encomiendaRepository, clienteRepository, agenciaRepository, paqueteService);
        encomiendaController = new EncomiendaController(this, encomiedaService);
        encomiendaController.cargarAgenciasOrigen();
        encomiendaController.mostrarEncomienda((DefaultTableModel) this.jTEncomiendas.getModel());
        
        btnCrearEncomienda.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        btnAgregarPaquete = new javax.swing.JButton();
        btnCrearEncomienda = new javax.swing.JButton();
        btnGuardarEncomienda = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVerPaquetes = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        panelEntregaDomicilio = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtDirEntrega = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCodPostal = new javax.swing.JTextField();
        panelInterprovincial = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jCBAgenciaDestino = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JCheckDomicilio = new javax.swing.JCheckBox();
        jCBAgenciaOrigen = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDCFechaEnvio = new com.toedter.calendar.JDateChooser();
        txtcedulaEmisor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCedulaReceptor = new javax.swing.JTextField();
        JCheckInterprovincial = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jDCFechaLlegada = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTEncomiendas = new javax.swing.JTable();
        btnRestablecer = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 193, -1, -1));

        panelOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnAgregarPaquete.setText("Agregar paquete");
        btnAgregarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPaqueteActionPerformed(evt);
            }
        });

        btnCrearEncomienda.setText("Crear encomienda");
        btnCrearEncomienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearEncomiendaActionPerformed(evt);
            }
        });

        btnGuardarEncomienda.setText("Guardar encomienda");
        btnGuardarEncomienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEncomiendaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnVerPaquetes.setText("Ver lista de paquetes");
        btnVerPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPaquetesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerPaquetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarEncomienda, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(btnAgregarPaquete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearEncomienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnGuardarEncomienda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarPaquete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearEncomienda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel2.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 190, 240));

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Encomienda"));

        panelEntregaDomicilio.setBorder(javax.swing.BorderFactory.createTitledBorder("Entrega a domicilio"));

        jLabel9.setText("Dirección de entrega:");

        jLabel10.setText("Codigo postal:");

        javax.swing.GroupLayout panelEntregaDomicilioLayout = new javax.swing.GroupLayout(panelEntregaDomicilio);
        panelEntregaDomicilio.setLayout(panelEntregaDomicilioLayout);
        panelEntregaDomicilioLayout.setHorizontalGroup(
            panelEntregaDomicilioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntregaDomicilioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntregaDomicilioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(52, 52, 52)
                .addGroup(panelEntregaDomicilioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDirEntrega)
                    .addComponent(txtCodPostal))
                .addContainerGap())
        );
        panelEntregaDomicilioLayout.setVerticalGroup(
            panelEntregaDomicilioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntregaDomicilioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntregaDomicilioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDirEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEntregaDomicilioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(txtCodPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelInterprovincial.setBorder(javax.swing.BorderFactory.createTitledBorder("Entrega interprovincial"));

        jLabel8.setText("Agencia de destino:");

        jCBAgenciaDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBAgenciaDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAgenciaDestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInterprovincialLayout = new javax.swing.GroupLayout(panelInterprovincial);
        panelInterprovincial.setLayout(panelInterprovincialLayout);
        panelInterprovincialLayout.setHorizontalGroup(
            panelInterprovincialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInterprovincialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCBAgenciaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelInterprovincialLayout.setVerticalGroup(
            panelInterprovincialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInterprovincialLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelInterprovincialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCBAgenciaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la encomienda"));

        jLabel11.setText("Interprovincial:");

        jLabel12.setText("Entrega a domicilio:");

        JCheckDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCheckDomicilioActionPerformed(evt);
            }
        });

        jCBAgenciaOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBAgenciaOrigen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCBAgenciaOrigenMouseReleased(evt);
            }
        });
        jCBAgenciaOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAgenciaOrigenActionPerformed(evt);
            }
        });

        jLabel13.setText("Agencia de origen");

        jLabel14.setText("Fecha de envío:");

        txtcedulaEmisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaEmisorActionPerformed(evt);
            }
        });

        jLabel15.setText("Número de cédula del emisor");

        jLabel16.setText("Número de cédula del receptor");

        txtCedulaReceptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaReceptorActionPerformed(evt);
            }
        });

        JCheckInterprovincial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCheckInterprovincialActionPerformed(evt);
            }
        });

        jLabel17.setText("Fecha de llegada:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(16, 16, 16)
                                .addComponent(txtCedulaReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDCFechaEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtcedulaEmisor)
                                    .addComponent(jCBAgenciaOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDCFechaLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JCheckInterprovincial)))
                                .addGap(60, 60, 60)
                                .addComponent(jLabel12)
                                .addGap(17, 17, 17)
                                .addComponent(JCheckDomicilio)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel16))
                    .addComponent(txtCedulaReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel15))
                    .addComponent(txtcedulaEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jDCFechaEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDCFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jCBAgenciaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(JCheckDomicilio)
                    .addComponent(JCheckInterprovincial))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelInterprovincial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelEntregaDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInterprovincial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEntregaDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jPanel2.add(panelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 480, 650));

        jTabbedPane1.addTab("Crear encomienda", jPanel2);

        btnFiltrar.setLabel("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jTEncomiendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"10223", "Michael", "Micos", "XD1", "XD2"},
                {"11233", "Micos", "Jimmy", "XD3", "XD5"}
            },
            new String [] {
                "ID Encomienda", "Remitente", "Destinatario", "Agencia Origen", "Agencia Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTEncomiendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEncomiendasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTEncomiendas);

        btnRestablecer.setText("Reestablecer");
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrar)
                    .addComponent(btnRestablecer))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar encomienda", jPanel3);

        jMenu1.setText("Archivo");
        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBAgenciaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAgenciaDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBAgenciaDestinoActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        VentanaFiltar ventanaFiltar = new VentanaFiltar(this);
        ventanaFiltar.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        ventanaFiltar.setVisible(true);
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        encomiendaController.actionPerformed(evt);
        
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void limpiar() {
        panelInterprovincial.setVisible(false);
        panelEntregaDomicilio.setVisible(false);
        txtCedulaReceptor.setText("");
        txtCodPostal.setText("");
        txtDirEntrega.setText("");
        txtcedulaEmisor.setText("");
        jCBAgenciaDestino.setSelectedIndex(0);
        jCBAgenciaOrigen.setSelectedIndex(0);
        btnCrearEncomienda.setVisible(false);
        JCheckDomicilio.setSelected(false);
        JCheckInterprovincial.setSelected(false);
        jDCFechaEnvio.setDate(null);
        jDCFechaLlegada.setDate(null);
        btnGuardarEncomienda.setVisible(true);
    }

    private void btnGuardarEncomiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEncomiendaActionPerformed
        encomiendaController.actionPerformed(evt);
        btnGuardarEncomienda.setVisible(false);
    }//GEN-LAST:event_btnGuardarEncomiendaActionPerformed

    private void btnAddPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPaquetesActionPerformed
        btnCrearEncomienda.setVisible(true);
    }//GEN-LAST:event_btnAddPaquetesActionPerformed

    private void btnAgregarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPaqueteActionPerformed
        ventanaPaquete.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        ventanaPaquete.setVisible(true);
        ventanaPaquete.btnAddPaquete.setVisible(false);
        btnCrearEncomienda.setVisible(true);
    }//GEN-LAST:event_btnAgregarPaqueteActionPerformed

    private void btnVerListaPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JCheckDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCheckDomicilioActionPerformed
        if (JCheckDomicilio.isSelected()) {
            panelEntregaDomicilio.setVisible(true);
        } else {
            panelEntregaDomicilio.setVisible(false);
        }
    }//GEN-LAST:event_JCheckDomicilioActionPerformed

    private void txtcedulaEmisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaEmisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaEmisorActionPerformed

    private void txtCedulaReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaReceptorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaReceptorActionPerformed

    private void JCheckInterprovincialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCheckInterprovincialActionPerformed
        if (JCheckInterprovincial.isSelected()) {
            panelInterprovincial.setVisible(true);
        } else {
            panelInterprovincial.setVisible(false);
        }
    }//GEN-LAST:event_JCheckInterprovincialActionPerformed

    private void btnVerPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPaquetesActionPerformed
        listaPaquete = ventanaPaquete.listaPaquetes;
        JFListaPaquetesByEncomienda viewListaPaquetes = new JFListaPaquetesByEncomienda();
        viewListaPaquetes.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        viewListaPaquetes.setVisible(true);
        System.out.println("ANTES DE MOSTRAR EN LA LISTA\n"+listaPaquete.toString());
        paqueteController.mostarPaquetesByEncomienda((DefaultTableModel) viewListaPaquetes.jTListaPaquetes.getModel(), listaPaquete);
        
    }//GEN-LAST:event_btnVerPaquetesActionPerformed

    private void jMISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setLocationRelativeTo(this);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTEncomiendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEncomiendasMouseClicked
       
        int index = jTEncomiendas.getSelectedRow();
        TableModel model = jTEncomiendas.getModel();
        String idEncomienda = model.getValueAt(index, 0).toString();
        infoEncomienda.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        infoEncomienda.setVisible(true);
        try {
            encomiendaController.MostrarInfoEncomida(infoEncomienda, idEncomienda);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jTEncomiendasMouseClicked

    private void btnCrearEncomiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEncomiendaActionPerformed
        listaPaquete = ventanaPaquete.listaPaquetes;
        encomiendaController.actionPerformed(evt);
        encomiendaController.mostrarEncomienda((DefaultTableModel) this.jTEncomiendas.getModel());
        limpiar();
    }//GEN-LAST:event_btnCrearEncomiendaActionPerformed

    private void jCBAgenciaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAgenciaOrigenActionPerformed

    }//GEN-LAST:event_jCBAgenciaOrigenActionPerformed

    private void jCBAgenciaOrigenMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBAgenciaOrigenMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBAgenciaOrigenMouseReleased

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        encomiendaController.mostrarEncomienda((DefaultTableModel) this.jTEncomiendas.getModel());
    }//GEN-LAST:event_btnRestablecerActionPerformed

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
            java.util.logging.Logger.getLogger(JFEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEncomiendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox JCheckDomicilio;
    public javax.swing.JCheckBox JCheckInterprovincial;
    public javax.swing.JButton btnAgregarPaquete;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCrearEncomienda;
    public javax.swing.JButton btnFiltrar;
    public javax.swing.JButton btnGuardarEncomienda;
    private javax.swing.JButton btnRestablecer;
    public javax.swing.JButton btnVerPaquetes;
    public javax.swing.JComboBox<String> jCBAgenciaDestino;
    public javax.swing.JComboBox<String> jCBAgenciaOrigen;
    public com.toedter.calendar.JDateChooser jDCFechaEnvio;
    public com.toedter.calendar.JDateChooser jDCFechaLlegada;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTEncomiendas;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelEntregaDomicilio;
    private javax.swing.JPanel panelInterprovincial;
    public javax.swing.JPanel panelOpciones;
    public javax.swing.JTextField txtCedulaReceptor;
    public javax.swing.JTextField txtCodPostal;
    public javax.swing.JTextField txtDirEntrega;
    public javax.swing.JTextField txtcedulaEmisor;
    // End of variables declaration//GEN-END:variables
}
