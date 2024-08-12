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
import encomiendas.model.entity.transporte.Ruta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RutaRepository implements Repository<Ruta> {
    private Connection myConn;

    public RutaRepository(Connection myConn) {
        this.myConn = myConn;
    }

    @Override
    public List<Ruta> findAll() throws SQLException {
        List<Ruta> rutas = new ArrayList<>();
        try (Statement stmt = myConn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ruta")) {
            while (rs.next()) {
                Ruta ruta = createRuta(rs);
                rutas.add(ruta);
            }
        }
        return rutas;
    }

    @Override
    public Ruta getById(Integer id) throws SQLException {
        Ruta ruta = null;
        try (PreparedStatement stmt = myConn.prepareStatement("SELECT * FROM ruta WHERE ruta_id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ruta = createRuta(rs);
            }
        }
        return ruta;
    }

    @Override
    public void save(Ruta ruta) throws SQLException {
        String sql = "INSERT INTO ruta (descripcion, listaParadas, tipo_ruta) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = myConn.prepareStatement(sql)) {
            stmt.setString(1, ruta.getDescripcion());
            stmt.setString(2, ruta.getParadas());
            stmt.setBoolean(3, ruta.isEsInterprovincial());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement stmt = myConn.prepareStatement("DELETE FROM ruta WHERE ruta_id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Integer id, Ruta ruta) throws SQLException {
        String sql = "UPDATE ruta SET descripcion = ?, listaParadas = ?, tipo_ruta = ? WHERE ruta_id = ?";
        try (PreparedStatement stmt = myConn.prepareStatement(sql)) {
            stmt.setString(1, ruta.getDescripcion());
            stmt.setString(2, ruta.getParadas());
            stmt.setBoolean(3, ruta.isEsInterprovincial());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    private Ruta createRuta(ResultSet rs) throws SQLException {
        Ruta ruta = new Ruta();
        ruta.setDescripcion(rs.getString("descripcion"));
        ruta.setParadas(rs.getString("listaParadas"));
        ruta.setEsInterprovincial(rs.getBoolean("tipo_ruta"));
        return ruta;
    }
}

