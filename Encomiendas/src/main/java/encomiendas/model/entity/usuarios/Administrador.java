package encomiendas.model.entity.usuarios;

import static encomiendas.database.Conexion.getInstance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador extends Usuario {

    public Administrador() {
    }
    
    public Administrador(String cedula, String nombres, String apellidos, String correo, String telefono, String ciudad, String telefonoAdicional, Boolean activo, int idAgencia) {
        super(cedula, nombres, apellidos, correo, telefono, ciudad, telefonoAdicional, activo, idAgencia);
    }
}
