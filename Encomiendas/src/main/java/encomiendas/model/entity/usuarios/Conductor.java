package encomiendas.model.entity.usuarios;

public class Conductor extends Usuario {

    private String tipoLicencia;

    public Conductor(String cedula, String nombres, String apellidos, String correo, String telefono, String ciudad, String telefonoAdicional,Boolean activo, int idAgencia) {
        super(cedula, nombres, apellidos, correo, telefono, ciudad, telefonoAdicional, activo, idAgencia);
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

}
