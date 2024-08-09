package encomiendas.model.data.usuarios;

import encomiendas.model.data.Repository;
import encomiendas.model.entity.usuarios.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class CuentaRepository implements Repository<Cuenta> {
    private Connection myConn;

    public CuentaRepository(Connection myConn) {
        this.myConn = myConn;
    }
    public List<Cuenta> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta getById(Integer id) throws SQLException {
        Cuenta cuenta = null;
        try (PreparedStatement myStament = myConn.prepareStatement("select * from cuenta where cedula = ?")) {
            myStament.setInt(1, id);
            ResultSet myRs = myStament.executeQuery();
            if (myRs.next()) {
                cuenta = createCuenta(myRs);
            }
        }
        return cuenta;
    }

    @Override
    public void save(Cuenta t) throws SQLException {
        int x= 0;
    }


    public void delete(Cuenta id) throws SQLException {
        int x= 0;
    }

    @Override
    public void update(Integer id, Cuenta t) throws SQLException {
        int x= 0;
    }

    private Cuenta createCuenta(ResultSet myRs) throws SQLException {
        return new Cuenta(
                myRs.getInt("id_cuenta"),
                myRs.getString("cedula"),
                myRs.getString("username"),
                myRs.getString("contrasenia")
        );

    }
}
