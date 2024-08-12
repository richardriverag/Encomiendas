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
import java.util.List;

public class MantenimientoService {
    private MantenimientoRepository mantenimientoRepository;

    public MantenimientoService(MantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }

    public List<Mantenimiento> obtenerTodosLosMantenimientos() {
        return mantenimientoRepository.findAll();
    }

    public Mantenimiento obtenerMantenimientoPorId(int id) {
        return mantenimientoRepository.getById(id);
    }

    public void agregarMantenimiento(Mantenimiento mantenimiento) {
        mantenimientoRepository.save(mantenimiento);
    }

    public void actualizarMantenimiento(int id, Mantenimiento mantenimiento) {
        mantenimientoRepository.update(id, mantenimiento);
    }

    public void eliminarMantenimiento(int id) {
        mantenimientoRepository.delete(id);
    }
}

