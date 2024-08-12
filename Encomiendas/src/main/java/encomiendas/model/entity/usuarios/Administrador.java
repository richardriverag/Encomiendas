package encomiendas.model.entity.usuarios;

import static encomiendas.database.Conexion.getInstance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador extends Usuario {
    
    @Override
    public Boolean obtenerDatos(String cedula){
        PreparedStatement ps = null;
        Connection con = getInstance(); 
        ResultSet rs;
        String sql = "SELECT * FROM USUARIO WHERE cedula = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, this.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                // Llena el objeto Usuario con los datos obtenidos de la base de datos
                this.setCorreo(rs.getString("correo"));
                this.setCedula(rs.getString("cedula"));
                this.setNombres(rs.getString("nombres"));
                this.setApellidos(rs.getString("apellidos"));
                this.setTelefono(rs.getString("telefono"));
                this.setTelefonoAdicional(rs.getString("telefono_adicional"));
                this.setCiudad(rs.getString("ciudad"));
                this.setActivo(rs.getBoolean("activo"));
                this.setIdAgencia(rs.getInt("id_agencia"));
                this.setFotoPerfil(rs.getBytes("fotoPerfil"));
                return true; // Retorna true si el usuario existe
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e + " NO se pudo conectar");
            return false;
        } 
    }
}
