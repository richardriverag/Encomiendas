/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.transporte;

/**
 *
 * @author Sebastian Aisalla
 */

import encomiendas.model.entity.transporte.Ruta;
import encomiendas.model.data.transporte.RutaRepository;
import java.sql.SQLException;
import java.util.List;

public class RutaService {
    private RutaRepository rutaRepository;

    public RutaService(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    public List<Ruta> obtenerTodasLasRutas() throws SQLException {
        return rutaRepository.findAll();
    }

    public Ruta obtenerRutaPorId(int id) throws SQLException {
        return rutaRepository.getById(id);
    }

    public void agregarRuta(Ruta ruta) throws SQLException {
        rutaRepository.save(ruta);
    }

    public void actualizarRuta(int id, Ruta ruta) throws SQLException {
        rutaRepository.update(id, ruta);
    }

    public void eliminarRuta(int id) throws SQLException {
        rutaRepository.delete(id);
    }
}

