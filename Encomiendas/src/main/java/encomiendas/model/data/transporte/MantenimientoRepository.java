///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package encomiendas.model.data.transporte;
//
///**
// *
// * @author Sebastian Aisalla
// */
//
//import encomiendas.model.data.Repository;
//import encomiendas.model.entity.transporte.Mantenimiento;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MantenimientoRepository implements Repository<Mantenimiento> {
//    private Connection myConn;
//
//    public MantenimientoRepository(Connection myConn) {
//        this.myConn = myConn;
//    }
//
//    @Override
//    public List<Mantenimiento> findAll() throws SQLException {
//        List<Mantenimiento> mantenimientos = new ArrayList<>();
//        try (Statement stmt = myConn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM mantenimiento")) {
//            while (rs.next()) {
//                Mantenimiento mantenimiento = createMantenimiento(rs);
//                mantenimientos.add(mantenimiento);
//            }
//        }
//        return mantenimientos;
//    }
//
//    @Override
//    public Mantenimiento getById(Integer id) throws SQLException {
//        Mantenimiento mantenimiento = null;
//        try (PreparedStatement stmt = myConn.prepareStatement("SELECT * FROM mantenimiento WHERE id_mantenimiento = ?")) {
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                mantenimiento = createMantenimiento(rs);
//            }
//        }
//        return mantenimiento;
//    }
//
//    @Override
//    public void save(Mantenimiento mantenimiento) throws SQLException {
//        String sql = "INSERT INTO mantenimiento (fecha, descripcion, transporte_id) VALUES (?, ?, ?)";
//        try (PreparedStatement stmt = myConn.prepareStatement(sql)) {
//            stmt.setDate(1, Date.valueOf(mantenimiento.getFecha()));
//            stmt.setString(2, mantenimiento.getDescripcion());
//            stmt.setInt(3, mantenimiento.getTransporteId());
//            stmt.executeUpdate();
//        }
//    }
//
//    @Override
//    public void delete(Integer id) throws SQLException {
//        try (PreparedStatement stmt = myConn.prepareStatement("DELETE FROM mantenimiento WHERE id_mantenimiento = ?")) {
//            stmt.setInt(1, id);
//            stmt.executeUpdate();
//        }
//    }
//
//    @Override
//    public void update(Integer id, Mantenimiento mantenimiento) throws SQLException {
//        String sql = "UPDATE mantenimiento SET fecha = ?, descripcion = ?, transporte_id = ? WHERE id_mantenimiento = ?";
//        try (PreparedStatement stmt = myConn.prepareStatement(sql)) {
//            stmt.setDate(1, Date.valueOf(mantenimiento.getFecha()));
//            stmt.setString(2, mantenimiento.getDescripcion());
//            stmt.setInt(3, mantenimiento.getTransporteId());
//            stmt.setInt(4, id);
//            stmt.executeUpdate();
//        }
//    }
//
//    private Mantenimiento createMantenimiento(ResultSet rs) throws SQLException {
//        Mantenimiento mantenimiento = new Mantenimiento();
//        mantenimiento.setId(rs.getInt("id_mantenimiento"));
//        mantenimiento.setFecha(rs.getDate("fecha").toLocalDate());
//        mantenimiento.setDescripcion(rs.getString("descripcion"));
//        mantenimiento.setTransporteId(rs.getInt("transporte_id"));
//        return mantenimiento;
//    }
//}
//
