///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package encomiendas.services.transporte;
//
///**
// *
// * @author Sebastian Aisalla
// */
//
//import encomiendas.model.entity.transporte.Transporte;
//import encomiendas.model.data.transporte.TransporteRepository;
//import java.util.List;
//
//public class TransporteService {
//    private TransporteRepository transporteRepository;
//
//    public TransporteService(TransporteRepository transporteRepository) {
//        this.transporteRepository = transporteRepository;
//    }
//
//    public List<Transporte> obtenerTodosLosTransportes() {
//        return transporteRepository.findAll();
//    }
//
//    public Transporte obtenerTransportePorId(int id) {
//        return transporteRepository.getById(id);
//    }
//
//    public void agregarTransporte(Transporte transporte) {
//        transporteRepository.save(transporte);
//    }
//
//    public void actualizarTransporte(int id, Transporte transporte) {
//        transporteRepository.update(id, transporte);
//    }
//
//    public void eliminarTransporte(int id) {
//        transporteRepository.delete(id);
//    }
//}
//
