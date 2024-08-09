package encomiendas.model.data.usuarios;

import static encomiendas.database.Conexion.getInstance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbCliente {
    
    public boolean modificarCliente(String corr, String telf, String psw, String ced){
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        Connection con = getInstance();
        
        String sql1 = "UPDATE usuario SET correo=?, telefono=?"
                   + " WHERE cedula=?";
        
        String sql2 = "UPDATE cuenta SET contrasenia=? WHERE cedula=?";
        
        try{
            ps = con.prepareStatement(sql1);
            ps.setString(1, corr);
            ps.setString(2, telf);
            ps.setString(3, ced);
            ps.execute();
            
            ps2 = con.prepareStatement(sql2);
            ps2.setString(1, psw);
            ps2.setString(2, ced);
            ps2.execute();
            
            return true;
            
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
        
    }
    
    public boolean cambiarImagenPerfil(byte[] bytesImagen, String ced){
        PreparedStatement ps = null;
        Connection con = getInstance();
        
        String sql = "UPDATE usuario SET fotoPerfil=? WHERE cedula=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setBytes(1, bytesImagen);
            ps.setString(2, ced);
            ps.execute();
            
            return true;
            
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    
}
