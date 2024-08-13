/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.data.agencias;

import com.sun.tools.attach.VirtualMachineDescriptor;
import encomiendas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import encomiendas.model.entity.agencia.Agencia;


/**
 *
 * @author Roberth
 */
public class DbAgencia extends Conexion{
    //Rellenar el combo box
    public void RellenarComboBox(String tabla, String valor, JComboBox combo){
        PreparedStatement ps;
        ResultSet rs;
        Connection con= getInstance();
        String sql="SELECT * FROM "+tabla;
        
        try {
            ps=con.prepareStatement(sql);
            ps.execute();
            rs=ps.executeQuery();
            while (rs.next()) {
                combo.addItem(rs.getString(valor));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        
    }
    
    //Rellenar tabla
    public void mostrar(String tabla){
        PreparedStatement ps;
        ResultSet rs;
        Connection con= getInstance();
        String sql="SELECT * FROM "+tabla;
        
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("id_agencia");
        model.addColumn("nombre_agencia");
        model.addColumn("ubicacion_agencia");
        model.addColumn("codigo_postal");
        model.addColumn("provincia_agencia");
        model.addColumn("telefono_agencia");
        model.addColumn("ciudad_agencia");
        model.addColumn("estado_agencia");
        
    }
    
    //guardar
    public boolean guardar (Agencia p){
        PreparedStatement ps;
        Connection con= getInstance();
        String sql="INSERT INTO agencia (nombre_agencia, ubicacion_agencia, codigo_postal"
                +", provincia_agencia, telefono_agencia, ciudad_agencia, estado_agencia)"
                +"VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreAgencia());
            ps.setString(2, p.getUbicacionAgencia());
            ps.setString(3, p.getCodigoPostal());
            ps.setString(4, p.getProvinciaAgencia());
            ps.setString(5, p.getTelefonoAgencia());
            ps.setString(6, p.getCiudadAgencia());
            ps.setBoolean(7, p.isEstadoAgencia());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar (Agencia p){
        PreparedStatement ps;
        Connection con= getInstance();
        String sql="UPDATE agencia set nombre_agencia=?, ubicacion_agencia=?"
                +", codigo_postal=?, provincia_postal=?, telefono_agencia=?"
                +", ciudad_agencia=?, estado_agencia0?, WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreAgencia());
            ps.setString(2, p.getUbicacionAgencia());
            ps.setString(3, p.getCodigoPostal());
            ps.setString(4, p.getProvinciaAgencia());
            ps.setString(5, p.getTelefonoAgencia());
            ps.setString(6, p.getCiudadAgencia());
            ps.setBoolean(7, p.isEstadoAgencia());
            ps.setInt(8, p.getIdAgencia());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    //eliminar
    public boolean eliminar (Agencia p){
        PreparedStatement ps;
        Connection con= getInstance();
        String sql="DELETE FROM agencia WHERE id_agencia = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getIdAgencia());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    //Buscar agencia
    public boolean buscar (Agencia p){
        PreparedStatement ps;
        ResultSet rs;
        Connection con= getInstance();
        String sql="SELECT * FROM agencia WHERE nombre_agencia = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreAgencia());
            ps.execute();
            rs=ps.executeQuery();
            if (rs.next()) {
                p.setIdAgencia(Integer.parseInt(rs.getString("id_agencia")));
                p.setNombreAgencia(rs.getString("nombre_agencia"));
                p.setUbicacionAgencia(rs.getString("ubicacion_agencia"));
                p.setCodigoPostal(rs.getString("codigo_postal"));
                p.setProvinciaAgencia(rs.getString("provincia_agencia"));
                p.setTelefonoAgencia(rs.getString("telefono_agencia"));
                p.setCiudadAgencia(rs.getString("ciudad_agencia"));
                p.setEstadoAgencia(Boolean.parseBoolean(rs.getString("estado_agencia")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
