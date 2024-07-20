package encomiendas.model.data.encomiendas;


import encomiendas.model.data.Repository;
import encomiendas.model.entity.encomiendas.ESTADOS_ENCOMIENDA;
import encomiendas.model.entity.encomiendas.Encomienda;
import encomiendas.model.entity.usuarios.Agencia;
import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.model.entity.usuarios.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EncomiendaRepository implements Repository<Encomienda> {

    private Connection myConn;

    public EncomiendaRepository(Connection myConn) {
        this.myConn = myConn;
    }


    @Override
    public List<Encomienda> findAll() throws SQLException {
        List<Encomienda> encomiendas = new ArrayList<>();
        try(Statement myStament = myConn.createStatement();
            ResultSet myRs = myStament.executeQuery("select * from encomienda")){
            while (myRs.next()) {
                Encomienda e = createEncomienda(myRs);
                encomiendas.add(e);
            }
        }
        return encomiendas;
    }

    @Override
    public Encomienda getById(Integer id) throws SQLException {
        Encomienda encomienda = null;
        try(PreparedStatement myStament = myConn.prepareStatement("select * from encomienda where id = ?")) {
            myStament.setInt(1, id);
            ResultSet myRs = myStament.executeQuery();
            if (myRs.next()) {
                encomienda = createEncomienda(myRs);
            }
        }
        return encomienda;
    }

    @Override
    public void save(Encomienda encomienda) throws SQLException {
        String sql = "INSERT INTO encomiendas (agencia_origen, agencia_destino, receptor, emisor, fecha_emision, tipo_entrega, direccion_entrega, codigo_postal, estado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement myStament = myConn.prepareStatement(sql)){
//            myStament.setLong(1, encomienda.getAgenciaOrigen().getId());
//            myStament.setLong(2, encomienda.getAgenciaDestino().getId());
//            myStament.setLong(3, encomienda.getReceptor().getId());
//            myStament.setLong(4, encomienda.getEmisor().getId());
//            myStament.setDate(5, java.sql.Date.valueOf(encomienda.getFechaEmision()));
//            myStament.setString(6, String.valueOf(encomienda.getTipoEntrega()));
//            myStament.setString(7, encomienda.getDireccionEntrega());
//            myStament.setInt(8, encomienda.getCodigoPostal());
//            myStament.setString(9, encomienda.getEstado().name());
//            myStament.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try(PreparedStatement myStament = myConn.prepareStatement("delete from encomienda where id = ?")){
            myStament.setInt(1, id);
            myStament.executeUpdate();
        }
    }

    @Override
    public void update(Integer id, Encomienda encomienda) throws SQLException {
        try(PreparedStatement myStament = myConn.prepareStatement("update encomienda set estado = ? where id = ?")){
            myStament.setString(1, String.valueOf(encomienda.getTipoEntrega()));
            myStament.executeUpdate();
        }

    }

    private Encomienda createEncomienda(ResultSet myRs) throws SQLException {
        Encomienda encomienda = new Encomienda();
        encomienda.setId(myRs.getLong("id"));
        Agencia agenciaOrigen = new Agencia();
        agenciaOrigen = agenciaOrigen.getById(myRs.getLong("agencia_origen"));
        Agencia agenciaDestino = new Agencia();
        agenciaDestino = agenciaDestino.getById(myRs.getLong("agencia_destino"));
        encomienda.setAgenciaOrigen(agenciaOrigen);
        encomienda.setAgenciaDestino(agenciaDestino);

        Usuario receptor = new Cliente();
        receptor = receptor.getById(myRs.getLong("receptor"));
        Usuario emisor = new Cliente();
        emisor = emisor.getById(myRs.getLong("emisor"));
        encomienda.setReceptor((Cliente) receptor);
        encomienda.setEmisor((Cliente) emisor);

        encomienda.setFechaEmision(myRs.getDate("fecha_emision").toLocalDate());
        encomienda.setTipoEntrega(myRs.getString("tipo_entrega").charAt(0));
        encomienda.setDireccionEntrega(myRs.getString("direccion_entrega"));
        encomienda.setCodigoPostal(myRs.getInt("codigo_postal"));
        encomienda.setEstado(ESTADOS_ENCOMIENDA.valueOf(myRs.getString("estado")));

        return encomienda;
    }
}
