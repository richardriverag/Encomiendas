package encomiendas.controllers.encomiendas;

import encomiendas.model.entity.encomiendas.Encomienda;
import encomiendas.model.entity.encomiendas.Paquete;
import encomiendas.model.entity.usuarios.Agencia;
import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.services.encomiendas.EncomiendaService;
import encomiendas.views.encomiendas.JFEncomiendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EncomiendaController implements ActionListener, ItemListener {
    private Encomienda encomiendaParaGuardar = new Encomienda();
        
    private Encomienda encomiendaAGuardar = new Encomienda();
    private JFrame view;
    private EncomiendaService encomiendaService;

    private JFEncomiendas viewEncomienda;

    public EncomiendaController(JFrame view, EncomiendaService encomienda) {
        this.view = view;
        this.encomiendaService = encomienda;
    }

    public EncomiendaController(JFEncomiendas viewEncomienda, EncomiendaService encomienda) {
        this.encomiendaService = encomienda;
        this.viewEncomienda = viewEncomienda;
        // Agregar ItemListener al comboBox
        viewEncomienda.jCBAgenciaOrigen.addItemListener(this);

    }

    public void mostrarEncomienda(DefaultTableModel modeloTablaEncomienda) {
        try {
            // Obtener la lista de paquetes desde el servicio
            List<Encomienda> listaEncomienda = encomiendaService.getAllEncomiendas();

            // Limpiar cualquier fila existente en la tabla (opcional)
            modeloTablaEncomienda.setRowCount(0);

            // Iterar sobre la lista de paquetes e insertar cada uno en la tabla
            for (Encomienda encomienda : listaEncomienda) {
                // Convertir el paquete en un array de objetos para agregarlo como una fila
                Object[] fila = new Object[]{
                    encomienda.getIdEncomienda(),
                    encomienda.getEmisor().getNombres(),
                    encomienda.getReceptor().getNombres(),
                    encomienda.getAgenciaOrigen().getNombreAgencia(),
                    encomienda.getAgenciaDestino().getNombreAgencia()

                };

                // Agregar la fila al modelo de la tabla
                modeloTablaEncomienda.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void mostrarEncomiendaFiltro(DefaultTableModel modeloTablaEncomienda, String cedulaR, String cedulaE, String agenciaD, String agenciaO, String tipoEntrega) {
        try {
            // Obtener la lista de paquetes desde el servicio
            List<Encomienda> listaEncomienda = encomiendaService.getAllEncomiendasFiltro(cedulaR, cedulaE, agenciaD, agenciaO, tipoEntrega);

            // Limpiar cualquier fila existente en la tabla (opcional)
            modeloTablaEncomienda.setRowCount(0);
            // Iterar sobre la lista de paquetes e insertar cada uno en la tabla
            for (Encomienda encomienda : listaEncomienda) {
                // Convertir el paquete en un array de objetos para agregarlo como una fila
                Object[] fila = new Object[]{
                    encomienda.getIdEncomienda(),
                    encomienda.getEmisor().getNombres(),
                    encomienda.getReceptor().getNombres(),
                    encomienda.getAgenciaOrigen().getNombreAgencia(),
                    encomienda.getAgenciaDestino().getNombreAgencia()

                };

                // Agregar la fila al modelo de la tabla
                modeloTablaEncomienda.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void cargarAgenciasOrigen() {
        try {
            // Obtener la lista de agencias desde el servicio
            List<Agencia> todasLasAgencias = encomiendaService.obtenerAgencias();

            // Limpiar cualquier opción existente en el combo box
            viewEncomienda.jCBAgenciaOrigen.removeAllItems();

            // Agregar cada agencia al combo box
            for (Agencia agencia : todasLasAgencias) {
                viewEncomienda.jCBAgenciaOrigen.addItem(agencia.getNombreAgencia());
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar agencias de origen: " + ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       

        if (e.getSource() == viewEncomienda.btnGuardarEncomienda) {
            try {
                Cliente emisor = encomiendaService.obtenerCliente(viewEncomienda.txtcedulaEmisor.getText());
                encomiendaParaGuardar.setEmisor(emisor);
                Cliente receptor = encomiendaService.obtenerCliente(viewEncomienda.txtCedulaReceptor.getText());
                encomiendaParaGuardar.setReceptor(receptor);
                encomiendaParaGuardar.setFechaEmision(viewEncomienda.jDCFechaEnvio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                encomiendaParaGuardar.setFechaLLegada(viewEncomienda.jDCFechaLlegada.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                encomiendaParaGuardar.setAgenciaOrigen(encomiendaService.obtenerAgenciaPorNombre(viewEncomienda.jCBAgenciaOrigen.getSelectedItem().toString()));

                // Si es interprovincial y opcional domicilio
                if (viewEncomienda.JCheckInterprovincial.isSelected()) {
                    encomiendaParaGuardar.setAgenciaDestino(encomiendaService.obtenerAgenciaPorNombre(viewEncomienda.jCBAgenciaDestino.getSelectedItem().toString()));
                    encomiendaParaGuardar.setTipoEntrega("Agencia");

                    //Caso cuando es una encomienda para retirar en agencia
                    encomiendaAGuardar = new Encomienda(
                            null,
                            encomiendaParaGuardar.getAgenciaOrigen(),
                            encomiendaParaGuardar.getAgenciaDestino(),
                            receptor,
                            emisor,
                            encomiendaParaGuardar.getFechaEmision(),
                            encomiendaParaGuardar.getFechaLLegada(),
                            encomiendaParaGuardar.getTipoEntrega(),
                            null,
                            null
                    );

                    if (viewEncomienda.JCheckDomicilio.isSelected()) {
                        encomiendaParaGuardar.setTipoEntrega("Domicilio");
                        encomiendaParaGuardar.setDireccionEntrega(viewEncomienda.txtDirEntrega.getText());
                        encomiendaParaGuardar.setCodigoPostal(Integer.parseInt(viewEncomienda.txtCodPostal.getText()));

                        //En el caso de que sea a domicillio y seleccione una agencia de destino para que descanse el paquete uwu 
                        encomiendaAGuardar = new Encomienda(
                                null,
                                encomiendaParaGuardar.getAgenciaOrigen(),
                                encomiendaParaGuardar.getAgenciaDestino(),
                                receptor,
                                emisor,
                                encomiendaParaGuardar.getFechaEmision(),
                                encomiendaParaGuardar.getFechaLLegada(),
                                encomiendaParaGuardar.getTipoEntrega(),
                                encomiendaParaGuardar.getDireccionEntrega(),
                                encomiendaParaGuardar.getCodigoPostal(),
                                null,
                                null
                        );

                    }

                }

                if (viewEncomienda.JCheckDomicilio.isSelected() && !viewEncomienda.JCheckInterprovincial.isSelected()) {
                    encomiendaParaGuardar.setDireccionEntrega(viewEncomienda.txtDirEntrega.getText());
                    encomiendaParaGuardar.setCodigoPostal(Integer.parseInt(viewEncomienda.txtCodPostal.getText()));
                    encomiendaParaGuardar.setAgenciaDestino(encomiendaService.obtenerAgenciaPorNombre(viewEncomienda.jCBAgenciaOrigen.getSelectedItem().toString()));
                    
                    //Cuando es en la misma ciudad a domicillio
                    encomiendaAGuardar = new Encomienda(
                            null,
                            encomiendaParaGuardar.getAgenciaOrigen(),
                            encomiendaParaGuardar.getAgenciaDestino(),
                            receptor,
                            emisor,
                            encomiendaParaGuardar.getFechaEmision(),
                            encomiendaParaGuardar.getFechaLLegada(),
                            encomiendaParaGuardar.getTipoEntrega(),
                            encomiendaParaGuardar.getDireccionEntrega(),
                            encomiendaParaGuardar.getCodigoPostal(),
                            null,
                            null
                    );
                    
                
                }

                //toca crear una encomienda segun los parametros llenados
                JOptionPane.showMessageDialog(null, "Para guardar la encomienda.\nIngrese almenos un paquete");

            } catch (SQLException ex) {
                System.out.println("ERROR EN CONTROLADOR" + ex);
            }
            System.out.println(viewEncomienda.listaPaquete.toString());
        }
        if (e.getSource() == viewEncomienda.btnCrearEncomienda) {

            try {

                // Guardar la encomienda en la base de datos
                
                double precioTotal = 0; 
                // Obtener la última encomienda para obtener su ID
                Encomienda ultimaEncomienda = encomiendaService.obtenerUltimaEncomienda();
                //System.out.println(ultimaEncomienda);
                encomiendaAGuardar.setPrecioEncomienda(1.0);                
                encomiendaService.saveEncomienda(encomiendaAGuardar); 
                if (ultimaEncomienda != null) {
                    int idEncomienda = ultimaEncomienda.getIdEncomienda() + 1;

                    // Asignar el ID de la encomienda a cada paquete
                    for (Paquete paquete : viewEncomienda.listaPaquete) {
                        System.out.println("paquete añadido");
                        paquete.setIdEncomienda(idEncomienda);
                        encomiendaService.paqueteService.savePaquete(paquete);
                        precioTotal = paquete.getPrecioPaquete();
                    }
                    encomiendaService.savePrecioEncomienda(idEncomienda, precioTotal);
                    
                       
                    JOptionPane.showMessageDialog(null, "La encomienda se ha guardado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al obtener la última encomienda.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al crear la encomienda: " + ex);
            }

        }
        if (e.getSource() == viewEncomienda.btnCancelar) {
            System.out.println(viewEncomienda.listaPaquete.toString());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == viewEncomienda.jCBAgenciaOrigen && e.getStateChange() == ItemEvent.SELECTED) {
            // Solo ejecutar el código si una nueva agencia es seleccionada
            String agenciaOrigenSeleccionada = viewEncomienda.jCBAgenciaOrigen.getSelectedItem().toString();

            try {
                List<Agencia> todasLasAgencias = encomiendaService.obtenerAgencias();
                System.out.println("SI JALE LAS AGENCIAS");

                viewEncomienda.jCBAgenciaDestino.removeAllItems();

                for (Agencia agencia : todasLasAgencias) {
                    if (!agencia.getNombreAgencia().equals(agenciaOrigenSeleccionada)) {
                        viewEncomienda.jCBAgenciaDestino.addItem(agencia.getNombreAgencia());
                    }
                }
                System.out.println("SI PUSE LAS AGENCIAS");
            } catch (SQLException ex) {
                System.out.println("Error al obtener agencias: " + ex);
            }
        }
    }
}
