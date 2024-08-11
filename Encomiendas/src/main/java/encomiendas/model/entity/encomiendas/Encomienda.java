package encomiendas.model.entity.encomiendas;

import encomiendas.model.entity.usuarios.Agencia;
import encomiendas.model.entity.usuarios.Cliente;

import java.time.LocalDate;
import java.util.List;


public class Encomienda {

    private Integer idEncomienda;
    private Agencia agenciaOrigen;
    private Agencia agenciaDestino;
    private Cliente receptor;
    private Cliente emisor;
    private LocalDate fechaEmision;
    private LocalDate fechaLLegada; 
    private String tipoEntrega;
    private String direccionEntrega;
    private Integer codigoPostal;
    private Estado estado;
    private Double precioEncomienda;
    private List<Paquete> paquetes;

    //En caso de que la encomienda sea de entrega a domicilio
    public Encomienda(Integer id, Agencia agenciaOrigen, Agencia agenciaDestino, Cliente receptor, Cliente emisor, LocalDate fechaEmision, LocalDate fechaLLegada, String tipoEntrega, String direccionEntrega, Integer codigoPostal, Double precioEncomienda, List<Paquete> paquetes) {
        this.idEncomienda = id;
        this.agenciaOrigen = agenciaOrigen;
        this.agenciaDestino = agenciaDestino;
        this.receptor = receptor;
        this.emisor = emisor;
        this.fechaEmision = fechaEmision;
        this.fechaLLegada = fechaLLegada;
        this.tipoEntrega = tipoEntrega;
        this.direccionEntrega = direccionEntrega;
        this.codigoPostal = codigoPostal;
        this.precioEncomienda = precioEncomienda;
        this.paquetes = paquetes;
        this.estado = new EnBodegaO();
    }

    //En caso de que la encomienda sea de entrega en agencia
    public Encomienda(Integer id, Agencia agenciaOrigen, Agencia agenciaDestino, Cliente receptor, Cliente emisor, LocalDate fechaEmision, LocalDate fechaLlegada, String tipoEntrega, List<Paquete> paquetes, Double precioEncomienda) {
        this.idEncomienda = id;
        this.agenciaOrigen = agenciaOrigen;
        this.agenciaDestino = agenciaDestino;
        this.receptor = receptor;
        this.emisor = emisor;
        this.fechaEmision = fechaEmision;
        this.fechaLLegada = fechaLlegada;
        this.tipoEntrega = tipoEntrega;
        this.paquetes = paquetes;
        this.precioEncomienda = precioEncomienda;
        this.estado = new EnBodegaO();
    }

    public Encomienda() {
    }

    public Integer getIdEncomienda() {
        return idEncomienda;
    }

    public void setIdEncomienda(Integer idEncomienda) {
        this.idEncomienda = idEncomienda;
    }

    public Agencia getAgenciaOrigen() {
        return agenciaOrigen;
    }

    public void setAgenciaOrigen(Agencia agenciaOrigen) {
        this.agenciaOrigen = agenciaOrigen;
    }

    public Agencia getAgenciaDestino() {
        return agenciaDestino;
    }

    public void setAgenciaDestino(Agencia agenciaDestino) {
        this.agenciaDestino = agenciaDestino;
    }

    public LocalDate getFechaLLegada() {
        return fechaLLegada;
    }

    public void setFechaLLegada(LocalDate fechaLLegada) {
        this.fechaLLegada = fechaLLegada;
    }

    public Cliente getReceptor() {
        return receptor;
    }

    public void setReceptor(Cliente receptor) {
        this.receptor = receptor;
    }

    public Cliente getEmisor() {
        return emisor;
    }

    public void setEmisor(Cliente emisor) {
        this.emisor = emisor;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

  

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public double calcularPrecioTotal() {
        double precioTotal = 0;
        for (Paquete p : paquetes) {
            precioTotal += p.calcularPrecio();
        }
        return precioTotal;
    }

    public String consultarEstado() {
        return estado.ConsultarEstado();
    }

    public void cambiarEstado() {
        estado.siguiente(this);
    }

    public void setEstadoFromString(String estadoStr) {
        switch (estadoStr) {
            case "En bodega":
                this.estado = new EnBodegaD();
                break;
            case "En bodega origen":
                this.estado = new EnBodegaO();
                break;
            case "EnTransito":
                this.estado = new EnTransito();
                break;
            case "Entregado":
                this.estado = new Entregado();
                break;
            case "Recolectado":
                this.estado = new Recolectado();
                break;
            // Añadir más casos según sea necesario
            default:
                throw new IllegalArgumentException("Estado desconocido: " + estadoStr);
        }
    }

    public Double getPrecioEncomienda() {
        return precioEncomienda;
    }

    public void setPrecioEncomienda(Double precioEncomienda) {
        this.precioEncomienda = precioEncomienda;
    }

    @Override
    public String toString() {
        return "Encomienda{" + "idEncomienda=" + idEncomienda + ", agenciaOrigen=" + agenciaOrigen + ", agenciaDestino=" + agenciaDestino + ", receptor=" + receptor + ", emisor=" + emisor + ", fechaEmision=" + fechaEmision + ", fechaLLegada=" + fechaLLegada + ", tipoEntrega=" + tipoEntrega + ", direccionEntrega=" + direccionEntrega + ", codigoPostal=" + codigoPostal + ", estado=" + estado + ", precioEncomienda=" + precioEncomienda + ", paquetes=" + paquetes + '}';
    }
    
    

}
