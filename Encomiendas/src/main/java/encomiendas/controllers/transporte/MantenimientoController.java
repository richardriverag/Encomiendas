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
import java.util.List;

public class MantenimientoController {
    private MantenimientoService mantenimientoService;

    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }

    public List<Mantenimiento> listarMantenimientos() {
        return mantenimientoService.obtenerTodosLosMantenimientos();
    }

    public Mantenimiento obtenerMantenimiento(int id) {
        return mantenimientoService.obtenerMantenimientoPorId(id);
    }

    public void crearMantenimiento(Mantenimiento mantenimiento) {
        mantenimientoService.agregarMantenimiento(mantenimiento);
    }

    public void actualizarMantenimiento(int id, Mantenimiento mantenimiento) {
        mantenimientoService.actualizarMantenimiento(id, mantenimiento);
    }

    public void eliminarMantenimiento(int id) {
        mantenimientoService.eliminarMantenimiento(id);
    }
}

