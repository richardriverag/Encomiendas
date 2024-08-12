/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.transporte;

/**
 *
 * @author Sebastian Aisalla
 */

import encomiendas.model.entity.transporte.Mantenimiento;
import encomiendas.model.data.transporte.MantenimientoRepository;
import java.sql.SQLException;
import java.util.List;

public class MantenimientoService {
    private MantenimientoRepository mantenimientoRepository;

    public MantenimientoService(MantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }

    public List<Mantenimiento> obtenerTodosLosMantenimientos() throws SQLException {
        return mantenimientoRepository.findAll();
    }

    public Mantenimiento obtenerMantenimientoPorId(int id) throws SQLException {
        return mantenimientoRepository.getById(id);
    }

    public void agregarMantenimiento(Mantenimiento mantenimiento) throws SQLException {
        mantenimientoRepository.save(mantenimiento);
    }

    public void actualizarMantenimiento(int id, Mantenimiento mantenimiento) throws SQLException {
        mantenimientoRepository.update(id, mantenimiento);
    }

    public void eliminarMantenimiento(int id) throws SQLException {
        mantenimientoRepository.delete(id);
    }
}

