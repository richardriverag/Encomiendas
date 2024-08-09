package encomiendas.model.entity.usuarios;


public class Empleado extends Usuario {

    private String telefonoAdicional;

    public Empleado(String cedula, String nombres, String apellidos, String correo, String telefono, String ciudad, String telefonoAdicional, String fotoPerfil, Boolean activo, int idAgencia, Cuenta cuenta) {
        super(cedula, nombres, apellidos, correo, telefono, ciudad, telefonoAdicional, fotoPerfil, activo, idAgencia, cuenta);
    }




}
