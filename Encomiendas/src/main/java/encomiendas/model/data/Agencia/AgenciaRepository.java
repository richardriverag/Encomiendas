/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.data.Agencia;

import encomiendas.model.data.Repository;

import encomiendas.model.entity.usuarios.Agencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Michael
 */
public class AgenciaRepository implements Repository<Agencia> {
    
    private Connection myConn;
    
    public AgenciaRepository(Connection myConn) {
        this.myConn = myConn;
    }
    
    @Override
    public List<Agencia> findAll() throws SQLException {
        List<Agencia> agencia = new ArrayList<>();
        try(Statement myStament = myConn.createStatement();
            ResultSet myRs = myStament.executeQuery("select * from paquete")){
            while (myRs.next()) {
                Agencia e = createAgencia(myRs);
                agencia.add(e);
            }
        }
        return agencia;
    }

    @Override
    public Agencia getById(Integer id) throws SQLException {
        Agencia agencia = null;
        try(PreparedStatement myStament = myConn.prepareStatement("select * from agencia where id_agencia = ?")) {
            myStament.setInt(1, id);
            ResultSet myRs = myStament.executeQuery();
            if (myRs.next()) {
                agencia = createAgencia(myRs);
            }
        }
        return agencia;
    }
    
    public Agencia getByNombre (String nombre) throws  SQLException{
    
        Agencia agencia = null;
        try (PreparedStatement myStament = myConn.prepareStatement("select * from agencia where nombre_agencia = ?")){
            myStament.setString(1, nombre);
            ResultSet myRs = myStament.executeQuery();
            if (myRs.next()) {
                agencia = createAgencia(myRs);
            }
        } 
        return agencia;        
    }

    @Override
    public void save(Agencia t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Integer id, Agencia t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     private Agencia createAgencia(ResultSet myRs) throws SQLException {
        Agencia agencia = new Agencia(
        myRs.getInt("id_agencia"),
        myRs.getString("nombre_agencia"),
        myRs.getString("ubicacion_agencia"),
        myRs.getString("codigo_postal"),
        myRs.getString("provincia_agencia"),
        myRs.getString("telefono_agencia"),
        myRs.getString("ciudad_agencia"),
        myRs.getBoolean("estado_agencia")
        );
        return agencia;
    }
}
