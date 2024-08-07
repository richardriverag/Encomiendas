/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package encomiendas;

import encomiendas.controllers.encomiendas.PaqueteController;
import encomiendas.controllers.usuarios.usuarioController;
import encomiendas.database.Conexion;
import encomiendas.model.data.encomiendas.PaqueteRepository;
import encomiendas.model.data.usuarios.DbUsuarios;
import encomiendas.services.encomiendas.PaqueteService;
import encomiendas.view.encomiendas.PaqueteView;
import encomiendas.views.usuarios.Login;
import encomiendas.views.usuarios.RecuperarContrasenia;
import encomiendas.views.usuarios.Registro;

/**
 * @author Richard
 */
public class Encomiendas {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Inicializar conexión, repositorio y servicio
        Conexion conexion = new Conexion();
        PaqueteRepository paqueteRepository = new PaqueteRepository(conexion.getInstance());
        PaqueteService paqueteService = new PaqueteService(paqueteRepository);

        // Inicializar vista y controlador
        PaqueteView paqueteView = new PaqueteView();
        PaqueteController paqueteController = new PaqueteController(paqueteService, paqueteView);

        // Mostrar la vista
        paqueteView.setVisible(true);
    }
}
