/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.controllers.transporte;

/**
 *
 * @author Sebastian Aisalla
 */

import encomiendas.model.entity.transporte.Transporte;
import encomiendas.services.transporte.TransporteService;
import java.sql.SQLException;
import java.util.List;

public class TransporteController {
    private TransporteService transporteService;

    public TransporteController(TransporteService transporteService) {
        this.transporteService = transporteService;
    }

    public List<Transporte> listarTransportes() throws SQLException {
        return transporteService.obtenerTodosLosTransportes();
    }

    public Transporte obtenerTransporte(int id) throws SQLException {
        return transporteService.obtenerTransportePorId(id);
    }

    public void crearTransporte(Transporte transporte) throws SQLException {
        transporteService.agregarTransporte(transporte);
    }

    public void actualizarTransporte(int id, Transporte transporte) throws SQLException {
        transporteService.actualizarTransporte(id, transporte);
    }

    public void eliminarTransporte(int id) throws SQLException {
        transporteService.eliminarTransporte(id);
    }
}

