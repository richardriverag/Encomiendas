package encomiendas.model.entity.encomiendas;


/**
 * Clase que representa un paquete
 */

public class Paquete {

   private Integer idPaquete;
   private String descripcion;
   private Double peso;
   private Double volumen;
   private Boolean isFragil;
   private Integer idEncomienda;
   private Double precioPaquete;

   public Double calcularPrecio(){
       double precio = 0;
       if(peso < 5){
           precio = 10;
       }else if(peso < 10){
           precio = 20;
       }else if(peso < 20){
           precio = 30;
       }else{
           precio = 40;
       }
       if(volumen > 0.5){
           precio += 10;
       }
       if(isFragil){
           precio += 20;
       }
       return precio;
   }

    public Paquete(Integer idPaquete, String descripcion, Double peso, Double volumen, Boolean isFragil, Integer idEncomienda, Double precioPaquete) {
        this.idPaquete = idPaquete;
        this.descripcion = descripcion;
        this.peso = peso;
        this.volumen = volumen;
        this.isFragil = isFragil;
        this.idEncomienda = idEncomienda;
        this.precioPaquete = precioPaquete;
    }

    

    public Paquete() {
    }

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public Boolean getFragil() {
        return isFragil;
    }

    public void setFragil(Boolean fragil) {
        isFragil = fragil;
    }


    public Integer getIdEncomienda() {
        return idEncomienda;
    }

    public void setIdEncomienda(Integer idEncomienda) {
        this.idEncomienda = idEncomienda;
    }

    public Boolean getIsFragil() {
        return isFragil;
    }

    public void setIsFragil(Boolean isFragil) {
        this.isFragil = isFragil;
    }

    public Double getPrecioPaquete() {
        return precioPaquete;
    }

    public void setPrecioPaquete(Double precioPaquete) {
        this.precioPaquete = precioPaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
}
