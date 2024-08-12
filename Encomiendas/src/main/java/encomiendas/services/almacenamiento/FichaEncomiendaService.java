/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.almacenamiento;

import encomiendas.model.data.almacenamiento.FichaEncomiendaRepository;
import encomiendas.model.entity.almacenamiento.FichaEncomienda;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class FichaEncomiendaService {
    private final FichaEncomiendaRepository fichaEncomiendaRepository;
    
    public FichaEncomiendaService(FichaEncomiendaRepository fichaEncomiendaRepository) {
        this.fichaEncomiendaRepository = fichaEncomiendaRepository;
    }
    
    
    
    public List<FichaEncomienda> getAllFichas() throws SQLException{
    return fichaEncomiendaRepository.findAll();
    }
    
    public void  guardar(FichaEncomienda fichaEncomienda) throws SQLException{
        fichaEncomiendaRepository.save(fichaEncomienda);
    }
    public void modificar (Integer id, FichaEncomienda fichaEncomienda) throws SQLException{
        fichaEncomiendaRepository.update(id, fichaEncomienda);
    }
    public FichaEncomienda buscar (FichaEncomienda fichaEncomienda){
       return fichaEncomiendaRepository.buscar(fichaEncomienda);
    }
}
