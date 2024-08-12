package encomiendas.model.entity.usuarios;

public class Administrador extends Usuario {

    public Administrador(String cedula, String nombres, String apellidos, String correo, String telefono, String ciudad, String telefonoAdicional, Boolean activo, int idAgencia) {
        super(cedula, nombres, apellidos, correo, telefono, ciudad, telefonoAdicional, activo, idAgencia);
    }
}
