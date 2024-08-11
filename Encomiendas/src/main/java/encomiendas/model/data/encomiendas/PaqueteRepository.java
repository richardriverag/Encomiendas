package encomiendas.model.data.encomiendas;

import encomiendas.model.data.Repository;
import encomiendas.model.entity.encomiendas.Encomienda;
import encomiendas.model.entity.encomiendas.Paquete;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaqueteRepository implements Repository<Paquete> {

    private Connection myConn;

    public PaqueteRepository(Connection myConn) {
        this.myConn = myConn;
    }

    @Override
    public List<Paquete> findAll() throws SQLException {
        List<Paquete> paquete = new ArrayList<>();
        try (Statement myStament = myConn.createStatement(); ResultSet myRs = myStament.executeQuery("select * from paquete")) {
            while (myRs.next()) {
                Paquete e = createPaquete(myRs);
                paquete.add(e);
            }
        }
        return paquete;
    }

    public List<Paquete> findAllByEncomienda(Integer idEncomienda) throws SQLException {

        List<Paquete> paquete = new ArrayList<>();
        System.out.println("ID DE LA ENCOMIENDA DENTRO DE REPOSITORY" + idEncomienda);
        try (PreparedStatement myStament = myConn.prepareStatement("select * from paquete where id_encomienda = ?")) {
            myStament.setInt(1, idEncomienda);
            ResultSet myRs = myStament.executeQuery();
            while (myRs.next()) {
                Paquete e = createPaquete(myRs);
                paquete.add(e);
            }
        }
        System.out.println(paquete.toString());
        return paquete;
    }

    @Override
    public Paquete getById(Integer id) throws SQLException {

        Paquete paquete = null;
        try (PreparedStatement myStament = myConn.prepareStatement("select * from paquete where id_paquete = ?")) {
            myStament.setInt(1, id);
            ResultSet myRs = myStament.executeQuery();
            if (myRs.next()) {
                paquete = createPaquete(myRs);
            }
        }
        return paquete;
    }

    @Override
    public void save(Paquete paquete) throws SQLException {
        String sql = "INSERT INTO paquete (descripcion, peso, volumen, isFragil, precio, id_encomienda) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement myStament = myConn.prepareStatement(sql)) {
            myStament.setString(1, paquete.getDescripcion());
            myStament.setFloat(2, paquete.getPeso().floatValue());
            myStament.setFloat(3, paquete.getVolumen().floatValue());
            myStament.setBoolean(4, paquete.getFragil());
            myStament.setFloat(5, paquete.getPeso().floatValue());
            myStament.setLong(6, paquete.getIdEncomienda());
            myStament.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement myStament = myConn.prepareStatement("delete from paquete where id_paquete = ?")) {
            myStament.setInt(1, id);
            myStament.executeUpdate();
        }
    }

    @Override
    public void update(Integer id, Paquete paquete) throws SQLException {

    }

    private Paquete createPaquete(ResultSet myRs) throws SQLException {
        Paquete paquete = new Paquete();
        paquete.setIdPaquete(myRs.getInt("id_paquete"));
        paquete.setDescripcion(myRs.getString("descripcion"));
        paquete.setPeso((double) myRs.getFloat("peso"));
        paquete.setVolumen((double) myRs.getFloat("volumen"));
        paquete.setFragil((myRs.getBoolean("isFragil")));
        paquete.setPrecioPaquete((double) (myRs.getFloat("precio")));
        paquete.setIdEncomienda(myRs.getInt("id_encomienda"));
        return paquete;
    }
}
