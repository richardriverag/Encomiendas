package encomiendas.model.data.encomiendas;


import encomiendas.model.data.Agencia.AgenciaRepository;
import encomiendas.model.data.Repository;
import encomiendas.model.data.usuarios.ClienteRepository;
import encomiendas.model.entity.encomiendas.Encomienda;
import encomiendas.model.entity.usuarios.Agencia;
import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.model.entity.usuarios.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EncomiendaRepository implements Repository<Encomienda> {

    private Connection myConn;
    private AgenciaRepository agenciaRepo;
    private ClienteRepository clienteRepo;
    public EncomiendaRepository(Connection myConn) {
        this.myConn = myConn;
        this.agenciaRepo = new AgenciaRepository(myConn);
        this.clienteRepo = new ClienteRepository(myConn);
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

    public List<Encomienda> findAllFiltro(String cedulaR, String cedulaE, String agenciaD, String agenciaO, String tipoEntrega) throws SQLException {
        List<Encomienda> encomiendas = new ArrayList<>();

        // Obtener IDs de las agencias
        Integer idAgenciaDestino = agenciaRepo.getByNombre(agenciaD).getIdAgencia();
        Integer idAgenciaOrigen = agenciaRepo.getByNombre(agenciaO).getIdAgencia();

        // Usar StringBuilder para construir la consulta SQL
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM encomienda WHERE 1=1");

        // Añadir condiciones a la consulta SQL dependiendo de los parámetros proporcionados
        if (cedulaR != null && !cedulaR.trim().isEmpty()) {
            queryBuilder.append(" AND cedula_receptor = ?");
        }
        if (cedulaE != null && !cedulaE.trim().isEmpty()) {
            queryBuilder.append(" AND cedula_emisor = ?");
        }
        if (idAgenciaDestino != null) {
            queryBuilder.append(" AND id_agencia_destino = ?");
        }
        if (idAgenciaOrigen != null) {
            queryBuilder.append(" AND id_agencia_origen = ?");
        }
        if (tipoEntrega != null && !tipoEntrega.trim().isEmpty()) {
            queryBuilder.append(" AND tipo_entrega = ?");
        }

        String query = queryBuilder.toString();

        // Verificar la consulta generada
        //System.out.println("Consulta SQL generada: " + query);

        try (PreparedStatement myStmt = myConn.prepareStatement(query)) {
            int parameterIndex = 1;

            // Establecer los parámetros en el PreparedStatement
            if (cedulaR != null && !cedulaR.trim().isEmpty()) {
                myStmt.setString(parameterIndex++, cedulaR);
            }
            if (cedulaE != null && !cedulaE.trim().isEmpty()) {
                myStmt.setString(parameterIndex++, cedulaE);
            }
            if (idAgenciaDestino != null) {
                myStmt.setInt(parameterIndex++, idAgenciaDestino);
            }
            if (idAgenciaOrigen != null) {
                myStmt.setInt(parameterIndex++, idAgenciaOrigen);
            }
            if (tipoEntrega != null && !tipoEntrega.trim().isEmpty()) {
                myStmt.setString(parameterIndex++, tipoEntrega);
            }

            // Ejecutar la consulta
            try (ResultSet myRs = myStmt.executeQuery()) {
                while (myRs.next()) {
                    Encomienda e = createEncomienda(myRs);
                    encomiendas.add(e);
                }
            }
        }

        return encomiendas;
    }
    
    @Override
    public Encomienda getById(Integer id) throws SQLException {
        Encomienda encomienda = null;
        try(PreparedStatement myStament = myConn.prepareStatement("select * from encomienda where id_encomienda = ?")) {
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
        String sql = "INSERT INTO encomiendas (id_agencia_origen, id_agencia_destino, cedula_receptor, cedula_emisor, fecha_envio, fecha_llegada, tipo_entrega, direccion_entrega, cod_postal_entrega, estado_encomienda, precio_encomienda) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";

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
        try(PreparedStatement myStament = myConn.prepareStatement("delete from encomienda where id_agencia = ?")){
            myStament.setInt(1, id);
            myStament.executeUpdate();
        }
    }

    @Override
    public void update(Integer id, Encomienda encomienda) throws SQLException {
        try(PreparedStatement myStament = myConn.prepareStatement("update encomienda set estado = ? where id_agencia = ?")){
            myStament.setString(1, String.valueOf(encomienda.getTipoEntrega()));
            myStament.executeUpdate();
        }

    }

    //TO DO: HACER TODOO
    private Encomienda createEncomienda(ResultSet myRs) throws SQLException {
        Encomienda encomienda = new Encomienda();
        encomienda.setIdEncomienda(myRs.getInt("id_encomienda"));
        Agencia agenciaOrigen = new Agencia();
        
        agenciaOrigen = agenciaRepo.getById(myRs.getInt("id_agencia_origen"));
        //agenciaOrigen = agenciaOrigen.getById(myRs.getLong("agencia_origen"));
        Agencia agenciaDestino = new Agencia();
        agenciaDestino = agenciaRepo.getById(myRs.getInt("id_agencia_destino"));
        encomienda.setAgenciaOrigen(agenciaOrigen);
        encomienda.setAgenciaDestino(agenciaDestino);

        Usuario receptor = null;
        receptor = clienteRepo.getById(myRs.getString("cedula_receptor"));
        Usuario emisor = null;
        emisor = clienteRepo.getById(myRs.getString("cedula_emisor"));
        encomienda.setReceptor((Cliente) receptor);
        encomienda.setEmisor((Cliente) emisor);

        encomienda.setFechaEmision(myRs.getDate("fecha_envio").toLocalDate());
        encomienda.setFechaLLegada(myRs.getDate("fecha_llegada").toLocalDate());
        encomienda.setTipoEntrega(myRs.getString("tipo_entrega").charAt(0));
        encomienda.setDireccionEntrega(myRs.getString("direccion_entrega"));
        encomienda.setCodigoPostal(myRs.getInt("cod_postal_entrega"));
        encomienda.setPrecioEncomienda(myRs.getDouble("precio_encomienda"));
        encomienda.setEstadoFromString(myRs.getString("estado_encomienda"));
        
        return encomienda;
    }

    
}
