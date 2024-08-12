package encomiendas.services.encomiendas;

import encomiendas.model.data.Agencia.AgenciaRepository;
import encomiendas.model.data.encomiendas.EncomiendaRepository;
import encomiendas.model.data.encomiendas.PaqueteRepository;
import encomiendas.model.data.usuarios.ClienteRepository;
import encomiendas.model.entity.encomiendas.Encomienda;
import encomiendas.model.entity.usuarios.Agencia;
import encomiendas.model.entity.usuarios.Cliente;

import java.sql.SQLException;
import java.util.List;

public class EncomiendaService {

    private final EncomiendaRepository encomiendaRepository;
    private final ClienteRepository clienteRepository;
    private final AgenciaRepository agenciaRepository;
    public final PaqueteService paqueteService;

    public EncomiendaService(EncomiendaRepository encomiendaRepository, ClienteRepository clienteRepository, AgenciaRepository agenciaRepository, PaqueteService paqueteService) {
        this.encomiendaRepository = encomiendaRepository;
        this.clienteRepository = clienteRepository;
        this.agenciaRepository = agenciaRepository;
        this.paqueteService = paqueteService;
    }

   
    //Obtener toda las encomiendas
    public List<Encomienda> getAllEncomiendas() throws SQLException {
        return encomiendaRepository.findAll();
    }
    
    public List<Encomienda> getAllEncomiendasFiltro(String cedulaR,String cedulaE,String agenciaD, String agenciaO, String tipoEntrega) throws SQLException {
        return encomiendaRepository.findAllFiltro(cedulaR, cedulaE, agenciaD, agenciaO, tipoEntrega);
    }
    
    //Obtener una encomienda por id
    public Encomienda getEncomiendaById(Integer id) throws SQLException {
        return encomiendaRepository.getById(id);
    }

    //Guardar una encomienda
    public void saveEncomienda(Encomienda encomienda) throws SQLException {
        encomiendaRepository.save(encomienda);
    }
    public void savePrecioEncomienda(int id, double precio) throws SQLException {
        encomiendaRepository.updatePrecio(id, precio);
    }

    //Eliminar una encomienda
    public void deleteEncomienda(Integer id) throws SQLException {
        encomiendaRepository.delete(id);
    }

    //Actualizar una encomienda
    public void updateEncomienda(Integer idEncomienda, Encomienda encomienda) throws SQLException {
        encomiendaRepository.update(idEncomienda, encomienda);
    }

    //Consultar el estado de una encomienda
    public String consultarEstado(Integer idEncomienda) throws SQLException {
        Encomienda encomienda = getEncomiendaById(idEncomienda);
        return encomienda.consultarEstado();
    }

    //Cambiar el estado de una encomienda
    public void cambiarEstado(Integer idEncomienda, String estado) throws SQLException {
        Encomienda encomienda = getEncomiendaById(idEncomienda);
        encomienda.setEstadoFromString(estado);
        updateEncomienda(idEncomienda, encomienda);
    }

    //Calcular el precio total de una encomienda
//    public double calcularPrecioTotal() throws SQLException {
//        Encomienda encomienda = getEncomiendaById(idEncomienda);
//        return encomienda.calcularPrecioTotal();
//    }
    
    //Retonar un cliente
    public Cliente obtenerCliente(String cedula) throws SQLException{
        return clienteRepository.getById(cedula);
    }
    
    public Agencia obtenerAgenciaPorNombre(String nombre) throws SQLException{
        return agenciaRepository.getByNombre(nombre);
    }
    
    public List<Agencia> obtenerAgencias () throws  SQLException{
        return agenciaRepository.findAll();
    }
    
    public Encomienda obtenerUltimaEncomienda() throws SQLException{
        return encomiendaRepository.getLastEncomienda();
    }

}
