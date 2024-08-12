/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.almacenamiento;
import encomiendas.model.entity.almacenamiento.Almacen;
import encomiendas.model.entity.almacenamiento.Seccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
/**
 *
 * @author tandr
 */

public class DbAlmacen extends Conexion {
    private static final String SQL_INSERT = "INSERT INTO almacen(limite_superior_caducidad, nombre_almacen, id_agencia,numeroSecciones) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE almacen SET limite_superior_caducidad=?, nombre=?, id_agencia=? WHERE id_almacen=?";
    private static final String SQL_DELETE = "DELETE FROM almacen WHERE id_almacen=?";
    private static final String SQL_SELECT = "SELECT * FROM  almacen WHERE id_almacen=?";
    
    public boolean guardar(Almacen almacen) {
    Connection con = null;
    try {
        con = getConexion();
        con.setAutoCommit(false); // Iniciar transacción
        
        // Insertar el almacén
        
        int idAlmacen = -1;
        try (PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, almacen.getLimiteSuperiorCaducidad());
            ps.setString(2, almacen.getNombreAlmacen());
            ps.setInt(3, almacen.getAgencia());
            ps.setInt(4, almacen.getNumeroSecciones());
            ps.executeUpdate();
            
            // Obtener el ID generado automáticamente
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idAlmacen = generatedKeys.getInt(1);
                    almacen.setIdAlmacen(idAlmacen); // Establecer el ID en el objeto
                }
            }
        }
        
        // Insertar secciones asociadas al almacén usando executeBatch
        String sqlInsertSeccion = "INSERT INTO seccion (nombre, capacidad, id_almacen) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sqlInsertSeccion)) {
            for (int i = 0; i < almacen.getNumeroSecciones(); i++) {
                // Crear y añadir la sección al batch
                Seccion seccion = new Seccion(0, " ", 0, idAlmacen); // Asegúrate de ajustar los valores
                ps.setString(1, seccion.getNombreSeccion());
                ps.setInt(2, seccion.getCapacidad());
                ps.setInt(3, seccion.getIdAlmacen());
                ps.addBatch();
            }
            // Ejecutar el batch
            ps.executeBatch();
        }

        con.commit(); // Confirmar transacción
        return true;
    } catch (SQLException e) {
        Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, "Error al guardar el almacén", e);
        try {
            if (con != null) {
                con.rollback(); // Revertir transacción en caso de excepción
            }
        } catch (SQLException rollbackEx) {
            Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, "Error al hacer rollback", rollbackEx);
        }
        return false;
    } finally {
        try {
            if (con != null && !con.isClosed()) {
                con.close(); // Asegúrate de cerrar la conexión
            }
        } catch (SQLException e) {
            Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", e);
        }
    }
}



    public boolean modificar(Almacen almacen) {
        Connection con = getConexion();
        try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setInt(1, almacen.getLimiteSuperiorCaducidad());
            ps.setString(2, almacen.getNombreAlmacen());
            ps.setInt(3, almacen.getAgencia());
            ps.setInt(4, almacen.getIdAlmacen());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean eliminar(Almacen almacen) {
        Connection con = getConexion();
        try (PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, almacen.getIdAlmacen());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean buscar(Almacen almacen) {
        Connection con = getConexion();
        try (PreparedStatement ps = con.prepareStatement(SQL_SELECT)) {
            ps.setInt(1, almacen.getIdAlmacen());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    almacen.setIdAlmacen(rs.getInt("id_almacen"));
                    almacen.setNombreAlmacen(rs.getString("nombre_almacen"));
                    almacen.setLimiteSuperiorCaducidad(rs.getInt("limite_superior_caducidad"));
                    almacen.setAgencia(rs.getInt("id_agencia"));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    public List<Almacen> obtenerAlmacenes() {
    List<Almacen> almacenes = new ArrayList<>();
    String sql = "SELECT id_almacen, nombre_almacen FROM Almacen"; // Ajusta la consulta según tus necesidades
    try (Connection con = getConexion();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Almacen almacen = new Almacen();
            almacen.setIdAlmacen(rs.getInt("id_almacen"));
            almacen.setNombreAlmacen(rs.getString("nombre_almacen"));
            almacenes.add(almacen);
        }
    } catch (SQLException e) {
        Logger.getLogger(DbAlmacen.class.getName()).log(Level.SEVERE, null, e);
    }
    return almacenes;
}
    
    
}
