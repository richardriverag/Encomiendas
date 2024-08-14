/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.data.almacenamiento;

import encomiendas.model.data.Repository;
import encomiendas.model.entity.almacenamiento.Seccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author tandr
 */
public class SeccionRepository implements Repository<Seccion> {
    
    private Connection myConn;

    public SeccionRepository(Connection myConn) {
        this.myConn = myConn;
    }

    @Override
    public List<Seccion> findAll() throws SQLException {
       List<Seccion> secciones = new ArrayList<>();
    String sql = "SELECT *  FROM Seccion";
    try (
         PreparedStatement ps = myConn.prepareStatement(sql)) {
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
        Logger.getLogger(SeccionRepository.class.getName()).log(Level.SEVERE, null, e);
    }
    return secciones;
    }

    @Override
    public void save(Seccion seccion) throws SQLException {
       

    String SQL_INSERT = "INSERT INTO seccion (id_almacen, nombre, capacidad) VALUES (?, ?, ?); ";
    try (PreparedStatement ps = myConn.prepareStatement(SQL_INSERT)) {
        
        ps.setInt(1, seccion.getIdAlmacen());
        ps.setString(2, seccion.getNombreSeccion());
        ps.setInt(3, seccion.getCapacidad());
        
        
        ps.executeBatch();

    } catch (SQLException e) {
        Logger.getLogger(SeccionRepository.class.getName()).log(Level.SEVERE, "Error al guardar la sección", e);
    } finally {
        try {
            if (myConn != null && !myConn.isClosed()) {
                myConn.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(SeccionRepository.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", e);
        }
    }

    }

    @Override
    public void delete(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Integer id, Seccion seccion) throws SQLException {
    String sql = "UPDATE seccion SET nombre = ?, capacidad = ?, id_almacen = ? WHERE id_seccion = ?";
    
    // Desactivar el modo autocommit para manejar la transacción manualmente
    myConn.setAutoCommit(false);

    try (PreparedStatement stmt = myConn.prepareStatement(sql)) {
        stmt.setString(1, seccion.getNombreSeccion());
        stmt.setInt(2, seccion.getCapacidad());
        stmt.setInt(3, seccion.getIdAlmacen());
        stmt.setInt(4, seccion.getIdSeccion());
        
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected == 0) {
            throw new SQLException("No se encontró la sección con el ID: " + seccion.getIdSeccion());
        }

        // Confirmar la transacción
        myConn.commit();
    } catch (SQLException ex) {
        // En caso de error, revertir la transacción
        myConn.rollback();
        throw ex;  // Rethrow the exception to be handled by the caller
    } finally {
        // Restaurar el modo autocommit
        myConn.setAutoCommit(true);
    }
}
    
     public String obtenerNombreSeccion(int idSeccion) {
        String nombreSeccion = null;
        String SQL_SEARCH = "SELECT nombre FROM seccion WHERE id_seccion=? ; ";
        // Asegúrate de reemplazar los parámetros de conexión con los adecuados
        try (PreparedStatement ps = myConn.prepareStatement(SQL_SEARCH)) {
            
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

    @Override
    public Seccion getById(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public List<Seccion> obtenerSecciones(int idAlmacen) {
    List<Seccion> secciones = new ArrayList<>();
    String sql = "SELECT id_seccion, nombre, capacidad FROM Seccion WHERE id_almacen = ?";
    try (
         PreparedStatement ps = myConn.prepareStatement(sql)) {
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
        Logger.getLogger(SeccionRepository.class.getName()).log(Level.SEVERE, null, e);
    }
    return secciones;
}

    
    
}
