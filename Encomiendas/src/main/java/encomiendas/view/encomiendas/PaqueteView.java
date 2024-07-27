package encomiendas.view.encomiendas;

import encomiendas.model.entity.encomiendas.Paquete;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PaqueteView extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton refreshButton;

    public PaqueteView() {
        setTitle("Paquete View");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        tableModel = new DefaultTableModel(new Object[]{"ID", "Peso", "Volumen", "Fragil", "Precio"}, 0);
        table = new JTable(tableModel);
        refreshButton = new JButton("Refrescar");

        // Layout
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(refreshButton, BorderLayout.SOUTH);
    }

    public void setPaquetes(List<Paquete> paquetes) {
        tableModel.setRowCount(0); // Clear existing data
        for (Paquete paquete : paquetes) {
            tableModel.addRow(new Object[]{paquete.getIdPaquete(), paquete.getPeso(), paquete.getVolumen(), paquete.getIsFragil(), paquete.calcularPrecio()});
        }
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }

}
