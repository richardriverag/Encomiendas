/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.data.transporte;

/**
 *
 * @author Sebastian Aisalla
 */

import encomiendas.model.data.Repository;
import encomiendas.model.entity.transporte.ESTADO_TRANSPORTE;
import encomiendas.model.entity.transporte.Transporte;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransporteRepository implements Repository<Transporte> {
    private Connection myConn;

    public TransporteRepository(Connection myConn) {
        this.myConn = myConn;
    }

    @Override
    public List<Transporte> findAll() throws SQLException {
        List<Transporte> transportes = new ArrayList<>();
        try (Statement stmt = myConn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM transporte")) {
            while (rs.next()) {
                Transporte transporte = createTransporte(rs);
                transportes.add(transporte);
            }
        }
        return transportes;
    }

    @Override
    public Transporte getById(Integer id) throws SQLException {
        Transporte transporte = null;
        try (PreparedStatement stmt = myConn.prepareStatement("SELECT * FROM transporte WHERE transporte_id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                transporte = createTransporte(rs);
            }
        }
        return transporte;
    }

    @Override
    public void save(Transporte transporte) throws SQLException {
        String sql = "INSERT INTO transporte (capacidad_carga, modelo, anio_fabricacion, kilometraje, tipo_transporte, estado_transporte) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = myConn.prepareStatement(sql)) {
            stmt.setDouble(1, transporte.getCapacidad_carga());
            stmt.setString(2, transporte.getModelo());
            stmt.setInt(3, transporte.getAnio_fabricacion());
            stmt.setDouble(4, transporte.getKilometraje());
            stmt.setString(5, transporte.getTipo_transporte());
            stmt.setString(6, transporte.getEstado().toString());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement stmt = myConn.prepareStatement("DELETE FROM transporte WHERE transporte_id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Integer id, Transporte transporte) throws SQLException {
        String sql = "UPDATE transporte SET capacidad_carga = ?, modelo = ?, anio_fabricacion = ?, kilometraje = ?, tipo_transporte = ?, estado = ? WHERE transporte_id = ?";
        try (PreparedStatement stmt = myConn.prepareStatement(sql)) {
            stmt.setDouble(1, transporte.getCapacidad_carga());
            stmt.setString(2, transporte.getModelo());
            stmt.setInt(3, transporte.getAnio_fabricacion());
            stmt.setDouble(4, transporte.getKilometraje());
            stmt.setString(5, transporte.getTipo_transporte());
            stmt.setString(6, transporte.getEstado().toString());
            stmt.setInt(7, id);
            stmt.executeUpdate();
        }
    }

    private Transporte createTransporte(ResultSet rs) throws SQLException {
        Transporte transporte = new Transporte();
        transporte.setTransporte_id(rs.getInt("transporte_id"));
        transporte.setCapacidad_carga(rs.getDouble("capacidad_carga"));
        transporte.setModelo(rs.getString("modelo"));
        transporte.setAnio_fabricacion(rs.getInt("anio_fabricacion"));
        transporte.setKilometraje(rs.getDouble("kilometraje"));
        transporte.setTipo_transporte(rs.getString("tipo_transporte"));
        transporte.setEstado(ESTADO_TRANSPORTE.valueOf(rs.getString("estado_transporte")));

        return transporte;
    }
}

