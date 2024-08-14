/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.transporte;

/**
 *
 * @author Sebastian Aisalla
 */

import encomiendas.model.entity.transporte.Transporte;
import encomiendas.model.data.transporte.TransporteRepository;
import java.sql.SQLException;
import java.util.List;

public class TransporteService {
    private TransporteRepository transporteRepository;

    public TransporteService(TransporteRepository transporteRepository) {
        this.transporteRepository = transporteRepository;
    }

    public List<Transporte> obtenerTodosLosTransportes() throws SQLException {
        return transporteRepository.findAll();
    }

    public Transporte obtenerTransportePorId(int id) throws SQLException {
        return transporteRepository.getById(id);
    }

    public void agregarTransporte(Transporte transporte) throws SQLException {
        transporteRepository.save(transporte);
    }

    public void actualizarTransporte(int id, Transporte transporte) throws SQLException {
        transporteRepository.update(id, transporte);
    }

    public void eliminarTransporte(int id) throws SQLException {
        transporteRepository.delete(id);
    }
}

