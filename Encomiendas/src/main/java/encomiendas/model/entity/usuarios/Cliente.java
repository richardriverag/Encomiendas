package encomiendas.model.entity.usuarios;

import static encomiendas.database.Conexion.getInstance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente extends Usuario {  

    private String direccion;

    public Cliente(String cedula, String nombres, String apellidos, String correo, String telefono, String ciudad, String telefonoAdicional, String fotoPerfil, Boolean activo, int idAgencia, Cuenta cuenta, String direccion) {
        super(cedula, nombres, apellidos, correo, telefono, ciudad, telefonoAdicional, fotoPerfil, activo, idAgencia, cuenta);
        this.direccion = direccion;
    }
   
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
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
                //this.setRol(rs.getString("rol"));
                this.setDireccion(rs.getString("direccion"));
                this.setCiudad(rs.getString("ciudad"));
                this.setActivo(rs.getBoolean("activo"));
                this.setIdAgencia(rs.getInt("id_agencia"));
                return true; // Retorna true si el usuario existe
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e + " NO se pudo conectar");
            return false;
        } 
    }


}
