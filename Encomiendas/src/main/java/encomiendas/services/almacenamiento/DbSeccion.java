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
import modelo.entidades.Seccion;

/**
 *
 * @author tandr
 */
public class DbSeccion extends Conexion {
    private static final String SQL_INSERT = "INSERT INTO seccion (id_almacen, nombre, capacidad) VALUES (?, ?, ?); ";
    private static final String SQL_UPDATE = "UPDATE seccion SET  nombre = ?, capacidad = ? WHERE id_seccion = ?";
    private static final String SQL_SEARCH = "SELECT nombre FROM seccion WHERE id_seccion=? ; ";
    
    
    public String obtenerNombreSeccion(int idSeccion) {
        Connection con = null;
         con = getConexion();
        String nombreSeccion = null;

        // Asegúrate de reemplazar los parámetros de conexión con los adecuados
        try (PreparedStatement ps = con.prepareStatement(SQL_SEARCH)) {
            
            ps.setInt(1, idSeccion);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nombreSeccion = rs.getString("nombre");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombreSeccion;
    }

    
    public boolean guardar(Seccion seccion) {
        Connection con = null;
         con = getConexion();
    if (con == null) {
        System.err.println("Error: La conexión es nula.");
        return false;
    }

    System.out.println("Conexión: " + con);
    
    try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
        System.out.println("Estoy insertando: id_almacen=" + seccion.getIdAlmacen() + ", nombre=" + seccion.getNombreSeccion() + ", capacidad=" + seccion.getCapacidad());
        ps.setInt(1, seccion.getIdAlmacen());
        ps.setString(2, seccion.getNombreSeccion());
        ps.setInt(3, seccion.getCapacidad());
        
        
        ps.executeBatch();
        System.out.println("Filas afectadas: ");
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

    
    public List<Seccion> obtenerSecciones(int idAlmacen) {
    List<Seccion> secciones = new ArrayList<>();
    String sql = "SELECT id_seccion, nombre, capacidad FROM Seccion WHERE id_almacen = ?";
    try (Connection con = getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idAlmacen);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Seccion seccion = new Seccion();
                seccion.setIdSeccion(rs.getInt("id_seccion"));
                seccion.setNombreSeccion(rs.getString("nombre"));
                seccion.setCapacidad(rs.getInt("capacidad"));
                secciones.add(seccion);
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, null, e);
    }
    return secciones;
}
    public List<Seccion> obtenerTodas() {
    List<Seccion> secciones = new ArrayList<>();
    String sql = "SELECT *  FROM Seccion";
    try (Connection con = getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Seccion seccion = new Seccion();
                seccion.setIdSeccion(rs.getInt("id_seccion"));
                seccion.setNombreSeccion(rs.getString("nombre"));
                seccion.setCapacidad(rs.getInt("capacidad"));
                seccion.setIdAlmacen(rs.getInt("id_almacen"));
                secciones.add(seccion);
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, null, e);
    }
    return secciones;
}
    
    public boolean actualizar(Seccion seccion) {
        Connection con =  null;
        con = getConexion();
        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
  
        ps.setString(1, seccion.getNombreSeccion());
        ps.setInt(2, seccion.getCapacidad());
        ps.setInt(3, seccion.getIdSeccion());

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0; // Retorna true si al menos una fila fue afectada

        } catch (SQLException e) {
            Logger.getLogger(DbSeccion.class.getName()).log(Level.SEVERE, "Error al actualizar la sección", e);
            return false;
        }
    }
}
