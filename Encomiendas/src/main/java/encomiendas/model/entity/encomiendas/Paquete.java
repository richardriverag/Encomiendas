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

    public Paquete(Integer idPaquete, String descripcion, Double peso, Double volumen, Boolean isFragil, Integer idEncomienda) {
        this.idPaquete = idPaquete;
        this.descripcion = descripcion;
        this.peso = peso;
        this.volumen = volumen;
        this.isFragil = isFragil;
        this.idEncomienda = idEncomienda;
        this.precioPaquete = calcularPrecio(); // Calcula el precio al crear el paquete
    }
    
    public Paquete() {
    }

    public Double calcularPrecio() {
        double precioPaquete = 5; // Precio base mínimo

        // Calcular precio según peso
        if (peso < 5) {
            precioPaquete += peso * 2; // Precio base por kg para paquetes ligeros
        } else if (peso < 10) {
            precioPaquete += peso * 2.5;
        } else if (peso < 20) {
            precioPaquete += peso * 3;
        } else {
            precioPaquete += peso * 3.5;
        }

        // Calcular precio según volumen
        if (volumen < 0.2) {
            precioPaquete += 5;
        } else if (volumen < 0.5) {
            precioPaquete += 10;
        } else if (volumen < 1.0) {
            precioPaquete += 20;
        } else {
            precioPaquete += 30;
        }

        // Aumentar el precio si el paquete es frágil
        if (isFragil) {
            precioPaquete *= 1.2; // Incremento del 20% por fragilidad
        }

        return precioPaquete;
    }

    public void updatePrecioPaquete() {
        this.precioPaquete = calcularPrecio();
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

    @Override
    public String toString() {
        return "Paquete{" + "idPaquete=" + idPaquete + ", descripcion=" + descripcion + ", peso=" + peso + ", volumen=" + volumen + ", isFragil=" + isFragil + ", idEncomienda=" + idEncomienda + ", precioPaquete=" + precioPaquete + '}';
    }
    
    
    
}
