/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.almacen;

import encomiendas.model.data.almacenamiento.FichaEncomiendaRepository;
import encomiendas.model.entity.almacenamiento.FichaEncomienda;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author tandr
 */
public class FichaEncomiendaService {
    private final FichaEncomiendaRepository fichaRepository;

    public FichaEncomiendaService(FichaEncomiendaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }
    public FichaEncomienda buscarFicha(FichaEncomienda ficha){
        FichaEncomienda fichaEncontrada= this.fichaRepository.buscar(ficha);
        if(fichaEncontrada!= null){
            return fichaEncontrada;
        }
        else{
            JOptionPane.showMessageDialog(null, "Ficha No encontrada .");
            return null;
        }
        
        
    }
    public void guardarFicha (FichaEncomienda ficha) throws SQLException{
        try {
            this.fichaRepository.save(ficha);
            JOptionPane.showMessageDialog(null, "Ficha guardada con éxito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ficha no se ha guardado.");
        }
        
    }
    public void update(int id, FichaEncomienda ficha) throws SQLException{
        try {
        this.fichaRepository.update(id, ficha);
        JOptionPane.showMessageDialog(null, "Ficha retirada con éxito.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al al retirar la Ficha ");
    }
  }
    public int contarFichasEnSecciones(int idSeccion) throws SQLException{
        return this.fichaRepository.contarFichasEnSeccion(idSeccion);
    }
}
