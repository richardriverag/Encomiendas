package encomiendas.controllers.encomiendas;

import encomiendas.model.entity.encomiendas.Paquete;
import encomiendas.services.encomiendas.PaqueteService;
import encomiendas.view.encomiendas.PaqueteView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class PaqueteController {

    private PaqueteService paqueteService;
    private PaqueteView paqueteView;

    public PaqueteController(PaqueteService paqueteService, PaqueteView paqueteView) {
        this.paqueteService = paqueteService;
        this.paqueteView = paqueteView;

        initController();
    }

    private void initController() {
        paqueteView.getRefreshButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    loadPaquetes();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(paqueteView, "Error al cargar los paquetes: " + ex.getMessage());
                }
            }
        });

        // Load paquetes initially
        try {
            loadPaquetes();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(paqueteView, "Error al cargar los paquetes: " + ex.getMessage());
        }
    }

    private void loadPaquetes() throws SQLException {
        List<Paquete> paquetes = paqueteService.getAllPaquetes();
        paqueteView.setPaquetes(paquetes);
    }

}
