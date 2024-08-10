package encomiendas.controllers.encomiendas;

import encomiendas.model.entity.encomiendas.Encomienda;
import encomiendas.model.entity.encomiendas.Paquete;
import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.services.encomiendas.EncomiendaService;
import encomiendas.views.encomiendas.JFEncomiendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EncomiendaController implements ActionListener {

    private JFrame view;
    private EncomiendaService encomiendaService;

    private JFEncomiendas viewEncomienda;

    public EncomiendaController(JFrame view, EncomiendaService encomienda) {
        this.view = view;
        this.encomiendaService = encomienda;
    }

    public EncomiendaController(JFEncomiendas viewEncomienda, EncomiendaService encomienda ) {
        this.encomiendaService = encomienda;
        this.viewEncomienda = viewEncomienda;
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
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Encomienda encomiendaParaGuardar = new Encomienda();

        //TODO: HACEER
        if (e.getSource() == viewEncomienda.btnGuardarEncomienda) {
//            try {
//                Cliente emisor = encomiendaService.obtenerCliente(viewEncomienda.txtcedulaEmisor.getText());
//                encomiendaParaGuardar.setEmisor(emisor);
//                Cliente receptor = encomiendaService.obtenerCliente(viewEncomienda.txtCedulaReceptor.getText());
//                encomiendaParaGuardar.setReceptor(receptor);
//                encomiendaParaGuardar.setFechaEmision(viewEncomienda.jDCFechaEnvio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//                encomiendaParaGuardar.setFechaLLegada(viewEncomienda.jDCFechaLlegada.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//                encomiendaParaGuardar.setAgenciaOrigen(encomiendaService.obtenerAgenciaPorNombre(viewEncomienda.jCBAgenciaOrigen.getSelectedItem().toString()));
//                if (viewEncomienda.JCheckInterprovincial.isSelected()) {
//                    encomiendaParaGuardar.setAgenciaDestino(encomiendaService.obtenerAgenciaPorNombre(viewEncomienda.jCBAgenciaDestino.getSelectedItem().toString()));
//                    if (viewEncomienda.JCheckDomicilio.isSelected()) {
//                        encomiendaParaGuardar.setDireccionEntrega(viewEncomienda.txtDirEntrega.getText());
//                        encomiendaParaGuardar.setCodigoPostal(Integer.parseInt(viewEncomienda.txtCodPostal.getText()));
//                    }
//                }
//                encomiendaParaGuardar.setAgenciaDestino(encomiendaService.obtenerAgenciaPorNombre(viewEncomienda.jCBAgenciaOrigen.getSelectedItem().toString()));
//                JOptionPane.showMessageDialog(null, "La encomienda se ha guardado.\nIngrese un paquete");
//            } catch (SQLException ex) {
//                System.out.println("ERROR EN CONTROLADOR" + ex);
//            }
            System.out.println(viewEncomienda.listaPaquete.toString());
        }
        if (e.getSource() == viewEncomienda.btnCrearEncomienda) {
            encomiendaParaGuardar.setPrecioEncomienda(encomiendaParaGuardar.calcularPrecioTotal() + encomiendaParaGuardar.calcularPrecioTotal() * 0.12);
        }
        if (e.getSource() == viewEncomienda.btnCancelar) {
            System.out.println(viewEncomienda.listaPaquete.toString());

        }

        //TO DO
    }

}
