package encomiendas.model.entity.usuarios;

public class Cuenta {
    private int id_cuenta;
    private String cedula;
    private String username;
    private String contrasenia;

    public Cuenta(int id_cuenta, String cedula, String username, String contrasenia) {
        this.id_cuenta = id_cuenta;
        this.cedula = cedula;
        this.username = username;
        this.contrasenia = contrasenia;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public String getCedula() {
        return cedula;
    }

    public String getUsername() {
        return username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}
