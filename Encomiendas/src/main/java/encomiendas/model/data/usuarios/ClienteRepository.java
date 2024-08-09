/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.data.usuarios;

import encomiendas.model.data.Repository;
import encomiendas.model.entity.usuarios.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Michael
 */
public class ClienteRepository implements Repository<Cliente>{
    
    private Connection myConn;

    public ClienteRepository(Connection myConn) {
        this.myConn = myConn;
    }
    

    @Override
    public List<Cliente> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente getById(Integer id) throws SQLException {
        Cliente cliente = null;
        try(PreparedStatement myStament = myConn.prepareStatement("select * from paquete where id_paquete = ?")) {
            myStament.setInt(1, id);
            ResultSet myRs = myStament.executeQuery();
            if (myRs.next()) {
                cliente = createCliente(myRs);
            }
        }
        return cliente;
    }

    @Override
    public void save(Cliente t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Integer id, Cliente t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Cliente createCliente(ResultSet myRs) throws SQLException {
        Cliente cliente = new Cliente(
        myRs.getString("cedula"),
        myRs.getString("nombres"),
        myRs.getString("apellidos"),
        myRs.getString("correo"),
        myRs.getString("telefono"),
        myRs.getString("ciudad"),
        myRs.getString("telefono_adicional"),
        myRs.getString("foto_perfil"),
        myRs.getBoolean("activo"),
        myRs.getInt("id_agencia"),
        // Supongo que la clase Cliente tiene un campo 'Cuenta' que debe ser instanciado aquí
        // Esto depende de cómo obtienes o manejas una instancia de Cuenta en tu contexto
        //createCuenta(myRs),  // Este método debe ser implementado para crear una instancia de Cuenta a partir del ResultSet
        myRs.getString("direccion")
    );

    return cliente;
        
        
    }
}
