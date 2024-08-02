//package encomiendas.services.encomiendas;
//
//import encomiendas.model.data.encomiendas.PaqueteRepository;
//import encomiendas.model.entity.encomiendas.Paquete;
//
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class PaqueteService {
////
//    private final PaqueteRepository paqueteRepository;
//
//    public PaqueteService(PaqueteRepository paqueteRepository) {
//        this.paqueteRepository = paqueteRepository;
//    }
//
//    //Obtener toda los paquetes
//    public List<Paquete> getAllPaquetes() throws SQLException {
//        return paqueteRepository.findAll();
//    }
//
//    //Obtener un paquete por id
//    public Paquete getPaqueteById(Integer id) throws SQLException {
//        return paqueteRepository.getById(id);
//    }
//
//    //Guardar un paquete
//    public void savePaquete(Paquete paquete) throws SQLException {
//        paqueteRepository.save(paquete);
//    }
//
//    //Eliminar un paquete
//    public void deletePaquete(Integer id) throws SQLException {
//        paqueteRepository.delete(id);
//    }
//
//    //calcular el precio del del paquete
//    public double calcularPrecioTotal(Integer idEncomienda) throws SQLException {
//        Paquete paquete = getPaqueteById(idEncomienda);
//        return paquete.calcularPrecio();
//    }
//}
