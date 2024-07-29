//package encomiendas.services.encomiendas;
//
//import encomiendas.model.data.encomiendas.EncomiendaRepository;
//import encomiendas.model.entity.encomiendas.ESTADOS_ENCOMIENDA;
//import encomiendas.model.entity.encomiendas.Encomienda;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class EncomiendaService {
//
//    private final EncomiendaRepository encomiendaRepository;
//
//    public EncomiendaService(EncomiendaRepository encomiendaRepository) {
//        this.encomiendaRepository = encomiendaRepository;
//    }
//
//    //Obtener toda las encomiendas
//    public List<Encomienda> getAllEncomiendas() throws SQLException {
//        return encomiendaRepository.findAll();
//    }
//
//    //Obtener una encomienda por id
//    public Encomienda getEncomiendaById(Integer id) throws SQLException {
//        return encomiendaRepository.getById(id);
//    }
//
//    //Guardar una encomienda
//    public void saveEncomienda(Encomienda encomienda) throws SQLException {
//        encomiendaRepository.save(encomienda);
//    }
//
//    //Eliminar una encomienda
//    public void deleteEncomienda(Integer id) throws SQLException {
//        encomiendaRepository.delete(id);
//    }
//
//    //Actualizar una encomienda
//    public void updateEncomienda(Integer idEncomienda, Encomienda encomienda) throws SQLException {
//        encomiendaRepository.update(idEncomienda, encomienda);
//    }
//
//    //Consultar el estado de una encomienda
//    public ESTADOS_ENCOMIENDA consultarEstado(Integer idEncomienda) throws SQLException {
//        Encomienda encomienda = getEncomiendaById(idEncomienda);
//        return encomienda.consultarEstado();
//    }
//
//    //Cambiar el estado de una encomienda
//    public void cambiarEstado(Integer idEncomienda) throws SQLException {
//        Encomienda encomienda = getEncomiendaById(idEncomienda);
//        encomienda.cambiarEstado();
//        updateEncomienda(idEncomienda, encomienda);
//    }
//
//    //Calcular el precio total de una encomienda
//    public double calcularPrecioTotal(Integer idEncomienda) throws SQLException {
//        Encomienda encomienda = getEncomiendaById(idEncomienda);
//        return encomienda.calcularPrecioTotal();
//    }
//
//}
