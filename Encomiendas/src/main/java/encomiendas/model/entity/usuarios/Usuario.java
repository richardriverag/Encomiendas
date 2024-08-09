package encomiendas.model.entity.usuarios;


import encomiendas.database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuario extends Conexion{

    private String cedula;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String ciudad;
    private String telefonoAdicional;
    private String fotoPerfil;
    private Boolean activo;
    private int idAgencia;

    public Usuario(String cedula, String nombres, String apellidos, String correo, String telefono, String ciudad, String telefonoAdicional, String fotoPerfil, Boolean activo, int idAgencia) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.telefonoAdicional = telefonoAdicional;
        this.fotoPerfil = fotoPerfil;
        this.activo = activo;
        this.idAgencia = idAgencia;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefonoAdicional() {
        return telefonoAdicional;
    }

    public void setTelefonoAdicional(String telefonoAdicional) {
        this.telefonoAdicional = telefonoAdicional;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }
    
    public Boolean obtenerDatos(String cedula){
        return true;
    }

}
