package encomiendas.model.entity.encomiendas;


/**
 * Clase que representa un paquete
 */

public class Paquete {

   private Integer idPaquete;
   private Double peso;
   private Double volumen;
   private Boolean isFragil;
   private Integer idEncomienda;

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

    public Paquete(Integer idPaquete, Double peso, Double volumen, Boolean isFragil, Integer idEncomienda) {
        this.idPaquete = idPaquete;
        this.peso = peso;
        this.volumen = volumen;
        this.isFragil = isFragil;
        this.idEncomienda = idEncomienda;
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
}
