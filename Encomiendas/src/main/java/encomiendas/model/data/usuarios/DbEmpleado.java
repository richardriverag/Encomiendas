package encomiendas.model.data.usuarios;

import static encomiendas.database.Conexion.getInstance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Atik
 */
public class DbEmpleado {

    public List<Object[]> ListaEmpleados() {
        List<Object[]> empleados = new ArrayList<>();
        Connection con = getInstance();
        String rol = "Empleado";
        String sql = "SELECT * FROM usuario WHERE rol = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rol); // Aquí se establece el valor del parámetro
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] row = {
                        rs.getString("cedula"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("rol"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("telefono_adicional"),
                        rs.getString("tipo_licencia"),
                        rs.getBoolean("activo"),
                        rs.getInt("id_agencia")
                    };
                    empleados.add(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }
    
    public List<Object[]> ListaConductores() {
        List<Object[]> empleados = new ArrayList<>();
        Connection con = getInstance();
        String rol = "Conductor";
        String sql = "SELECT * FROM usuario WHERE rol = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rol); // Aquí se establece el valor del parámetro
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] row = {
                        rs.getString("cedula"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("rol"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("telefono_adicional"),
                        rs.getString("tipo_licencia"),
                        rs.getBoolean("activo"),
                        rs.getInt("id_agencia")
                    };
                    empleados.add(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public String obtenerRol(String cedula) {
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
