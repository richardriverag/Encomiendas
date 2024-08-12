///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package encomiendas.controllers.transporte;
//
///**
// *
// * @author Sebastian Aisalla
// */
//
//import encomiendas.model.entity.transporte.Ruta;
//import encomiendas.services.transporte.RutaService;
//import java.util.List;
//
//public class RutaController {
//    private RutaService rutaService;
//
//    public RutaController(RutaService rutaService) {
//        this.rutaService = rutaService;
//    }
//
//    public List<Ruta> listarRutas() {
//        return rutaService.obtenerTodasLasRutas();
//    }
//
//    public Ruta obtenerRuta(int id) {
//        return rutaService.obtenerRutaPorId(id);
//    }
//
//    public void crearRuta(Ruta ruta) {
//        rutaService.agregarRuta(ruta);
//    }
//
//    public void actualizarRuta(int id, Ruta ruta) {
//        rutaService.actualizarRuta(id, ruta);
//    }
//
//    public void eliminarRuta(int id) {
//        rutaService.eliminarRuta(id);
//    }
//}
//
