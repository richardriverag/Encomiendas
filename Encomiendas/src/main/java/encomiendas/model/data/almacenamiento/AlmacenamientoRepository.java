/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.data.almacenamiento;

import encomiendas.model.data.Repository;
import encomiendas.model.entity.almacenamiento.Almacen;
import encomiendas.model.entity.almacenamiento.Seccion;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tandr
 */
public class AlmacenamientoRepository implements Repository<Almacen> {
    private Connection myConn;

    public AlmacenamientoRepository(Connection myConn) {
        this.myConn = myConn;
    }
    
    

    @Override
    public List<Almacen> findAll() throws SQLException {
        List<Almacen> almacenes = new ArrayList<>();
        String sql = "SELECT id_almacen, nombre_almacen FROM Almacen"; // Ajusta la consulta según tus necesidades
        try (
             Statement stmt = myConn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Almacen almacen = new Almacen();
                almacen.setIdAlmacen(rs.getInt("id_almacen"));
                almacen.setNombreAlmacen(rs.getString("nombre_almacen"));
                almacenes.add(almacen);
            }
        } catch (SQLException e) {
            Logger.getLogger(AlmacenamientoRepository.class.getName()).log(Level.SEVERE, null, e);
        }
        return almacenes; 
    }

    @Override
    public Almacen getById(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Almacen almacen) throws SQLException {
    String sqlInsertAlmacen = "INSERT INTO almacen (limite_superior_caducidad, nombre_almacen, id_agencia, numeroSecciones) VALUES (?, ?, ?, ?)";
    String sqlInsertSeccion = "INSERT INTO seccion (nombre, capacidad, id_almacen) VALUES (?, ?, ?)";

    try (PreparedStatement psAlmacen = myConn.prepareStatement(sqlInsertAlmacen, Statement.RETURN_GENERATED_KEYS);
         PreparedStatement psSeccion = myConn.prepareStatement(sqlInsertSeccion)) {

        myConn.setAutoCommit(false); // Iniciar transacción

        // Insertar el almacén
        psAlmacen.setInt(1, almacen.getLimiteSuperiorCaducidad());
        psAlmacen.setString(2, almacen.getNombreAlmacen());
        psAlmacen.setInt(3, almacen.getAgencia());
        psAlmacen.setInt(4, almacen.getNumeroSecciones());
        psAlmacen.executeUpdate();

        // Obtener el ID generado automáticamente
        try (ResultSet generatedKeys = psAlmacen.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idAlmacen = generatedKeys.getInt(1);
                almacen.setIdAlmacen(idAlmacen); // Establecer el ID en el objeto

                // Insertar secciones asociadas al almacén usando executeBatch
                for (int i = 0; i < almacen.getNumeroSecciones(); i++) {
                    Seccion seccion = new Seccion(0, " ", 0, idAlmacen); // Asegúrate de ajustar los valores
                    psSeccion.setString(1, seccion.getNombreSeccion());
                    psSeccion.setInt(2, seccion.getCapacidad());
                    psSeccion.setInt(3, seccion.getIdAlmacen());
                    psSeccion.addBatch();
                }
                psSeccion.executeBatch();
            }
        }

        myConn.commit(); // Confirmar transacción
    } catch (SQLException e) {
        Logger.getLogger(AlmacenamientoRepository.class.getName()).log(Level.SEVERE, "Error al guardar el almacén", e);
        if (myConn != null) {
            myConn.rollback(); // Revertir transacción en caso de excepción
        }
        throw e; // Lanzar la excepción para que la maneje el llamador
    }
}


    @Override
    public void delete(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Integer id, Almacen almacen) throws SQLException {
       String sqlUpdateAlmacen = "UPDATE almacen SET limite_superior_caducidad=?, nombre=?, id_agencia=? WHERE id_almacen=?";
        try (PreparedStatement ps = myConn.prepareStatement(sqlUpdateAlmacen)) {
            ps.setInt(1, almacen.getLimiteSuperiorCaducidad());
            ps.setString(2, almacen.getNombreAlmacen());
            ps.setInt(3, almacen.getAgencia());
            ps.setInt(4, almacen.getIdAlmacen());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(AlmacenamientoRepository.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    public Almacen buscar(Almacen almacen) {
        String SQL_SELECT = "SELECT * FROM  almacen WHERE id_almacen=?";
        try (PreparedStatement ps = myConn.prepareStatement(SQL_SELECT)) {
            ps.setInt(1, almacen.getIdAlmacen());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    almacen.setIdAlmacen(rs.getInt("id_almacen"));
                    almacen.setNombreAlmacen(rs.getString("nombre_almacen"));
                    almacen.setLimiteSuperiorCaducidad(rs.getInt("limite_superior_caducidad"));
                    almacen.setAgencia(rs.getInt("id_agencia"));
                    return almacen;
                }
            }
            return null;
        } catch (SQLException e) {
            Logger.getLogger(AlmacenamientoRepository.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
