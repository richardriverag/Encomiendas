/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.data.almacenamiento;

import encomiendas.model.data.Repository;
import encomiendas.model.entity.almacenamiento.FichaEncomienda;
import encomiendas.model.entity.encomiendas.Encomienda;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author tandr
 */
public class FichaEncomiendaRepository implements Repository<FichaEncomienda> {
    
    private Connection myConn;

    public FichaEncomiendaRepository(Connection myConn) {
        this.myConn = myConn;
    }
    
    

    @Override
    public List<FichaEncomienda> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FichaEncomienda getById(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(FichaEncomienda ficha) throws SQLException {
        
    String SQL_INSERT = "INSERT INTO FICHA_ENCOMIENDA(fecha_entrada,fecha_salida,estado_ficha,id_seccion,id_encomienda) VALUES (?,?,?,?,?)";
    try (PreparedStatement ps = myConn.prepareStatement(SQL_INSERT)) {
        
        ps.setDate(1, new java.sql.Date(ficha.getFechaEntrda().getTime()));
        ps.setString(2, null);
        ps.setInt(3, ficha.isEstadoFicha());
        ps.setInt(4, ficha.getIdSeccion());
        ps.setInt(5, ficha.getEncomienda());
        
        
        ps.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(FichaEncomiendaRepository.class.getName()).log(Level.SEVERE, "Error al guardar la sección", e);

        } 
    }

    @Override
    public void delete(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Integer id, FichaEncomienda ficha) throws SQLException {
        String SQL_UPDATE = "UPDATE ficha_encomienda SET estado_ficha = ?, fecha_salida = ? WHERE id_ficha_encomienda = ?";
        boolean actualizado = false;
        java.util.Date fechaActual = Calendar.getInstance().getTime();

    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActualStr = dateFormat.format(fechaActual);

       
        java.util.Date utilFechaActual = null;
        try {
            utilFechaActual =dateFormat.parse(fechaActualStr);
        } catch (ParseException e) {
            e.printStackTrace();
            
        }
        try (PreparedStatement ps = myConn.prepareStatement(SQL_UPDATE)) {
            
            // Establecer los parámetros de la consulta
            ps.setInt(1, 0); // Estado de la ficha: 0 (inactiva)
            ps.setObject(2,  utilFechaActual); // Fecha de salida: fecha actual
            ps.setInt(3, ficha.getIdFichaEncomienda()); // ID de la ficha
            
            // Ejecutar la actualización
            int filasAfectadas = ps.executeUpdate();
            actualizado = (filasAfectadas > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

       
    
    }
    public FichaEncomienda buscar(FichaEncomienda ficha) {
        String SQL_SELECT = "SELECT * FROM  ficha_encomienda WHERE id_ficha_encomienda=?";
        try (PreparedStatement ps = myConn.prepareStatement(SQL_SELECT)) {
            ps.setInt(1, ficha.getIdFichaEncomienda());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ficha.setFechaEntrda(rs.getDate("fecha_entrada"));
                    ficha.setFechaSalida(rs.getDate("fecha_salida"));
                    ficha.setEstadoFicha(rs.getInt("estado_ficha"));
                    ficha.setIdSeccion(rs.getInt("id_seccion"));
                    ficha.setEncomienda(rs.getInt("id_encomienda"));
                    return ficha;
                }
            }
            return ficha;
        } catch (SQLException e) {
            
            return null;
        }
    }
    
    
    
    
}
