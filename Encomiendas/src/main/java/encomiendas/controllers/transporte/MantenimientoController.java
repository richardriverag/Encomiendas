/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.controllers.transporte;

/**
 *
 * @author Sebastian Aisalla
 */

import encomiendas.model.entity.transporte.Mantenimiento;
import encomiendas.services.transporte.MantenimientoService;
import java.sql.SQLException;
import java.util.List;

public class MantenimientoController {
    private MantenimientoService mantenimientoService;

    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }

    public List<Mantenimiento> listarMantenimientos() throws SQLException {
        return mantenimientoService.obtenerTodosLosMantenimientos();
    }

    public Mantenimiento obtenerMantenimiento(int id) throws SQLException {
        return mantenimientoService.obtenerMantenimientoPorId(id);
    }

    public void crearMantenimiento(Mantenimiento mantenimiento) throws SQLException {
        mantenimientoService.agregarMantenimiento(mantenimiento);
    }

    public void actualizarMantenimiento(int id, Mantenimiento mantenimiento) throws SQLException {
        mantenimientoService.actualizarMantenimiento(id, mantenimiento);
    }

    public void eliminarMantenimiento(int id) throws SQLException {
        mantenimientoService.eliminarMantenimiento(id);
    }
}

