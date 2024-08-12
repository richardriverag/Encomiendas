/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.almacenamiento;

import encomiendas.model.entity.almacenamiento.FichaEncomienda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;


/**
 *
 * @author tandr
 */
public class DbFichaEncomienda extends Conexion {
    private static final String SQL_INSERT = "INSERT INTO FICHA_ENCOMIENDA(fecha_entrada,fecha_salida,estado_ficha,id_seccion,id_encomienda) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM  ficha_encomienda WHERE id_ficha_encomienda=?";
    private static final String SQL_UPDATE = "UPDATE ficha_encomienda SET estado_ficha = ?, fecha_salida = ? WHERE id_ficha_encomienda = ?";
    
    
    
    
    
    
    public boolean buscar(FichaEncomienda ficha) {
        Connection con = getConexion();
        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT)) {
            ps.setInt(1, ficha.getIdFichaEncomienda());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ficha.setFechaEntrda(rs.getDate("fecha_entrada"));
                    ficha.setFechaSalida(rs.getDate("fecha_salida"));
                    ficha.setEstadoFicha(rs.getInt("estado_ficha"));
                    ficha.setIdSeccion(rs.getInt("id_seccion"));
                    ficha.setEncomienda(rs.getInt("id_encomienda"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    
    
    public boolean guardar(FichaEncomienda ficha) {
        Connection con = null;
         con = getConexion();
    if (con == null) {
        System.err.println("Error: La conexión es nula.");
        return false;
    }

    System.out.println("Conexión: " + con);
    
    try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
        
        ps.setDate(1, new java.sql.Date(ficha.getFechaEntrda().getTime()));
        ps.setString(2, null);
        ps.setInt(3, ficha.isEstadoFicha());
        ps.setInt(4, ficha.getIdSeccion());
        ps.setInt(5, ficha.getEncomienda());
        
        
        ps.executeUpdate();
        return true;

    } catch (SQLException e) {
        Logger.getLogger(DbSeccion.class.getName()).log(Level.SEVERE, "Error al guardar la sección", e);
        return false;
    } finally {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(DbSeccion.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", e);
        }
    }
}
    
    public boolean actualizarFicha(FichaEncomienda ficha) {
        
        Connection con = null;
         con = getConexion();
            if (con == null) {
                System.err.println("Error: La conexión es nula.");
                return false;
            }
        boolean actualizado = false;
        java.util.Date fechaActual = Calendar.getInstance().getTime();

    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActualStr = dateFormat.format(fechaActual);

        // Convertir el String de fecha a java.sql.Date
        java.util.Date utilFechaActual = null;
        try {
            utilFechaActual =dateFormat.parse(fechaActualStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return false; // Si no se puede parsear la fecha, retorna false
        }
        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            
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

        return actualizado;
    }
    
    
}
