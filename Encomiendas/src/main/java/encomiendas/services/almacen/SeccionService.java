/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.almacen;

import encomiendas.model.data.almacenamiento.SeccionRepository;
import encomiendas.model.entity.almacenamiento.Seccion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tandr
 */
public class SeccionService {
    private final SeccionRepository seccionRepository;

    public SeccionService(SeccionRepository seccionRepository) {
        this.seccionRepository = seccionRepository;
    }
    
    public String obtenerNombreSeccion(int idSeccion){
        return seccionRepository.obtenerNombreSeccion(idSeccion);
    }
    public void guardar(Seccion seccion) throws SQLException{
        seccionRepository.save(seccion);
    }
    public List<Seccion> obtenerSecciones(int idAlmacen){
        return seccionRepository.obtenerSecciones(idAlmacen);
    }
    public List<Seccion>  obtenerTodas() throws SQLException{
        return seccionRepository.findAll();
    }
    public void actualizar (int id,Seccion seccion) throws SQLException{
        seccionRepository.update(id, seccion);
    }
    
}
