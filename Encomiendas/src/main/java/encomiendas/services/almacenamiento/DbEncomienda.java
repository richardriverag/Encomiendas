/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.almacenamiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.entidades.Encomienda;
import modelo.entidades.Seccion;

/**
 *
 * @author tandr
 */
public class DbEncomienda extends Conexion {
    private static final String SQL_SELECT = "SELECT  id_encomienda FROM encomienda ";
    
    
    
    
    public List<Encomienda> obtenerEncomiendas() {
    List<Encomienda> encomiendas = new ArrayList<>();
    try (Connection con = getConexion();
         PreparedStatement ps = con.prepareStatement(SQL_SELECT)) {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Encomienda encomienda = new Encomienda();
                encomienda.setIdEncomienda(rs.getInt("id_encomienda"));
                encomiendas.add(encomienda);
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, null, e);
    }
    return encomiendas;
}
    
}
