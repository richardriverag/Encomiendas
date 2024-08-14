package encomiendas.model.entity.usuarios;

import static encomiendas.database.Conexion.getInstance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cuenta {
    private int id_cuenta;
    private String cedula;
    private String username;
    private String contrasenia;

    public Cuenta() {
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public Boolean obtenerDatosCuenta(String cedula){
        PreparedStatement ps = null;
        Connection con = getInstance(); 
        ResultSet rs;
        String sql = "SELECT * FROM cuenta WHERE cedula = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, this.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                // Llena el objeto Usuario con los datos obtenidos de la base de datos
                this.setId_cuenta(rs.getInt("id_cuenta"));
                this.setCedula(rs.getString("cedula"));
                this.setUsername(rs.getString("username"));
                this.setContrasenia(rs.getString("contrasenia"));
                return true; // Retorna true si el usuario existe
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e + " NO se pudo conectar");
            return false;
        } 
    }
}
