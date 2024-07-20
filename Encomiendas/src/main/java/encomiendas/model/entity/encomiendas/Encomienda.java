package encomiendas.model.entity.encomiendas;

import encomiendas.model.entity.usuarios.Agencia;
import encomiendas.model.entity.usuarios.Cliente;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class Encomienda {

    private Long id;
    private Agencia agenciaOrigen;
    private Agencia agenciaDestino;
    private Cliente receptor;
    private Cliente emisor;
    private LocalDate fechaEmision;
    private Character tipoEntrega;
    private String direccionEntrega;
    private Integer codigoPostal;
    private ESTADOS_ENCOMIENDA estado;
    private List<Paquete> paquetes;

    //En caso de que la encomienda sea de entrega a domicilio
    public Encomienda(Long id, Agencia agenciaOrigen, Agencia agenciaDestino, Cliente receptor, Cliente emisor, LocalDate fechaEmision, Character tipoEntrega, String direccionEntrega, Integer codigoPostal, List<Paquete> paquetes) {
        this.id = id;
        this.agenciaOrigen = agenciaOrigen;
        this.agenciaDestino = agenciaDestino;
        this.receptor = receptor;
        this.emisor = emisor;
        this.fechaEmision = fechaEmision;
        this.tipoEntrega = tipoEntrega;
        this.direccionEntrega = direccionEntrega;
        this.codigoPostal = codigoPostal;
        this.paquetes = paquetes;
        this.estado =  ESTADOS_ENCOMIENDA.EN_BODEGA;
    }

    //En caso de que la encomienda sea de entrega en agencia
    public Encomienda(Long id, Agencia agenciaOrigen, Agencia agenciaDestino, Cliente receptor, Cliente emisor, LocalDate fechaEmision, Character tipoEntrega, List<Paquete> paquetes) {
        this.id = id;
        this.agenciaOrigen = agenciaOrigen;
        this.agenciaDestino = agenciaDestino;
        this.receptor = receptor;
        this.emisor = emisor;
        this.fechaEmision = fechaEmision;
        this.tipoEntrega = tipoEntrega;
        this.paquetes = paquetes;
        this.estado =  ESTADOS_ENCOMIENDA.EN_BODEGA;
    }


    public void cambiarEstado(){
        estado = (tipoEntrega == 'D') ? estado.siguienteEstadoD() : estado.siguienteEstadoA();
    }

    public double calcularPrecioTotal(){
        double precioTotal = 0;
        for(Paquete p: paquetes){
            precioTotal += p.calcularPrecio();
        }
        return precioTotal;
    }

}
