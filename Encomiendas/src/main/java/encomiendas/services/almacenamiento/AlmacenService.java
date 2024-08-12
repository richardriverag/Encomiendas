/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.almacenamiento;

import encomiendas.model.data.almacenamiento.AlmacenamientoRepository;
import encomiendas.model.entity.almacenamiento.Almacen;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tandr
 */
public class AlmacenService {
    private final AlmacenamientoRepository almacenamientoRepository;

    public AlmacenService(AlmacenamientoRepository almacenamientoRepository) {
        this.almacenamientoRepository = almacenamientoRepository;
    }
    
    
    
    public List<Almacen> getAllAlmacenes() throws SQLException{
    return almacenamientoRepository.findAll();
    }
    
    public void  guardar(Almacen almacen) throws SQLException{
        almacenamientoRepository.save(almacen);
    }
    public void modificar (Integer id, Almacen almacen) throws SQLException{
        almacenamientoRepository.update(id, almacen);
    }
    public Almacen buscar (Almacen almacen){
       return almacenamientoRepository.buscar(almacen);
    }
}
