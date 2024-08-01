/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.usuarios;

import static encomiendas.database.Conexion.getInstance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER-PC
 */
public class DbUsuarios {
    
    public boolean registrarCliente (String cedula, String nombres, String apellidos, String correo, String telefono,
            String telefono_Adicional, String rol, String direccion, String ciudad, int id_agencia){
        PreparedStatement ps = null;
        Connection con = getInstance();
        String sql = "INSERT INTO USUARIO (cedula, nombres, apellidos, correo,"
                + " telefono, rol, direccion, ciudad, telefono_adicional, tipo_licencia, activo, id_agencia) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, correo);
            ps.setString(5, telefono);
            ps.setString(6, rol);
            ps.setString(7, direccion);
            ps.setString(8, ciudad);
            ps.setString(9, telefono_Adicional);
            ps.setString(10, " ");
            ps.setBoolean(11, true);
            ps.setInt(12, id_agencia);
            ps.execute();
            return true; 
        }catch(SQLException e){
            System.err.println(e+ "NO se pudo conectar");
            return false;
        }
    }
    
    public Boolean crearCuenta(String cedula, String username, String contrasenia){
        PreparedStatement ps = null;
        Connection con = getInstance();
        String sql = "INSERT INTO CUENTA (cedula, username, contrasenia) "
                + "VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, username);
            ps.setString(3, contrasenia);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e + " NO se pudo conectar");
            return false;
        }
        
    }
    
    public String validarExistencia(String nombreUsuario, String contrasenia) {
        PreparedStatement ps = null;
        Connection con = getInstance();
        ResultSet rs;
        String cedula; 
        String sql = "SELECT * FROM CUENTA WHERE username = ? AND contrasenia = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenia);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                // Llena el objeto Usuario con los datos obtenidos de la base de datos
                cedula = rs.getString("cedula");
                
                return cedula; // Retorna true si el usuario existe
            }
            return null;
        } catch (SQLException e) {
            System.err.println(e + " NO se pudo conectar");
            return null;
        } 
    }
    
    
    public String obtenerRol(String cedula){
        String rol; 
        PreparedStatement ps = null;
        Connection con = getInstance();
        ResultSet rs;
        
        String sql = "SELECT * FROM USUARIO WHERE cedula = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Llena el objeto Usuario con los datos obtenidos de la base de datos
                rol = rs.getString("rol");
                
                return rol; // Retorna el rol del usuario
            }
            return null;
        } catch (SQLException e) {
            System.err.println(e + " NO se pudo conectar");
            return null;
        }
        
    }
    
    
    
    
}
