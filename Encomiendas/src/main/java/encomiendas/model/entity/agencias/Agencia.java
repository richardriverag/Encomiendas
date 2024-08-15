package encomiendas.model.entity.agencias;

import encomiendas.database.Conexion;

public class Agencia extends Conexion{
  
     private int idAgencia;
    private String nombreAgencia;
    private String ubicacionAgencia;
    private String codigoPostal;
    private String provinciaAgencia;
    private String telefonoAgencia;
    private String ciudadAgencia;
    private boolean estadoAgencia;

    public Agencia(int idAgencia, String nombreAgencia, String ubicacionAgencia, String codigoPostal, String provinciaAgencia, String telefonoAgencia, String ciudadAgencia, boolean estadoAgencia) {
        this.idAgencia = idAgencia;
        this.nombreAgencia = nombreAgencia;
        this.ubicacionAgencia = ubicacionAgencia;
        this.codigoPostal = codigoPostal;
        this.provinciaAgencia = provinciaAgencia;
        this.telefonoAgencia = telefonoAgencia;
        this.ciudadAgencia = ciudadAgencia;
        this.estadoAgencia = estadoAgencia;
    }
  
    public Agencia(){
    }
    // Getters y Setters
    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getUbicacionAgencia() {
        return ubicacionAgencia;
    }

    public void setUbicacionAgencia(String ubicacionAgencia) {
        this.ubicacionAgencia = ubicacionAgencia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvinciaAgencia() {
        return provinciaAgencia;
    }

    public void setProvinciaAgencia(String provinciaAgencia) {
        this.provinciaAgencia = provinciaAgencia;
    }

    public String getTelefonoAgencia() {
        return telefonoAgencia;
    }

    public void setTelefonoAgencia(String telefonoAgencia) {
        this.telefonoAgencia = telefonoAgencia;
    }

    public String getCiudadAgencia() {
        return ciudadAgencia;
    }

    public void setCiudadAgencia(String ciudadAgencia) {
        this.ciudadAgencia = ciudadAgencia;
    }

    public boolean isEstadoAgencia() {
        return estadoAgencia;
    }

    public void setEstadoAgencia(boolean estadoAgencia) {
        this.estadoAgencia = estadoAgencia;
    }
    
}
