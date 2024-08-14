package encomiendas;

import encomiendas.controllers.almacenamiento.CtrAlmacen;
import encomiendas.controllers.almacenamiento.CtrFichaEncomienda;
import encomiendas.controllers.almacenamiento.CtrSeccion;
import encomiendas.database.Conexion;
import encomiendas.model.data.Agencia.AgenciaRepository;
import encomiendas.model.data.almacenamiento.AlmacenamientoRepository;
import encomiendas.model.data.almacenamiento.FichaEncomiendaRepository;
import encomiendas.model.data.almacenamiento.SeccionRepository;
import encomiendas.model.data.encomiendas.EncomiendaRepository;
import encomiendas.model.data.encomiendas.PaqueteRepository;
import encomiendas.model.data.usuarios.ClienteRepository;
import encomiendas.model.entity.almacenamiento.Almacen;
import encomiendas.model.entity.almacenamiento.FichaEncomienda;
import encomiendas.model.entity.almacenamiento.Seccion;
import encomiendas.model.entity.usuarios.Agencia;
import encomiendas.services.almacen.AlmacenService;
import encomiendas.services.almacen.FichaEncomiendaService;
import encomiendas.services.almacen.SeccionService;
import encomiendas.services.encomiendas.EncomiendaService;
import encomiendas.services.encomiendas.PaqueteService;
import encomiendas.views.almacenamiento.Bienvenido;
import encomiendas.views.almacenamiento.FRMAlmacen;
import encomiendas.views.almacenamiento.NuevaFicha;
import encomiendas.views.transporte.JFRuta;
import encomiendas.views.transporte.JFTransporte;
import java.sql.Connection;
import java.sql.SQLException;


public class Encomiendas {

    public static void main(String[] args) throws SQLException {
        Almacen almacen = new Almacen();
        FRMAlmacen frmAlm = new FRMAlmacen();
        NuevaFicha frmFicha = new NuevaFicha();
        Agencia agencia =  new  Agencia();
        Seccion seccion = new Seccion();
        FichaEncomienda ficha = new FichaEncomienda();
        Connection connection = Conexion.getInstance();

        SeccionRepository seccionRepository = new SeccionRepository(connection);
        FichaEncomiendaRepository fichaRepository = new FichaEncomiendaRepository(connection);
        AlmacenamientoRepository almacenRepository = new AlmacenamientoRepository(connection);
        EncomiendaRepository encomiendaRepo =  new EncomiendaRepository(connection);
        SeccionService seccionService = new SeccionService(seccionRepository);
        AlmacenService almacenService =  new AlmacenService(almacenRepository);
        FichaEncomiendaService fichaService =  new FichaEncomiendaService(fichaRepository);
        AgenciaRepository agenciaRepo = new AgenciaRepository(connection);
        ClienteRepository clienteRepository = new ClienteRepository(connection);
        PaqueteRepository paqueteRepository = new PaqueteRepository(connection);
        PaqueteService paqueteService = new PaqueteService(paqueteRepository);
        
        EncomiendaService encoService = new EncomiendaService(encomiendaRepo,clienteRepository,agenciaRepo,paqueteService);
        
        
        //FichaEncomienda ficha, FichaEncomiendaService dbFicha, NuevaFicha frmFicha,FRMAlmacen frmALM,SeccionService dbSeccion
        //Seccion Sec, SeccionService dbSec, FRMAlmacen frmAlm, NuevaFicha frmFicha) {
        CtrSeccion ctrSeccion =  new CtrSeccion(seccion,seccionService,frmAlm,frmFicha);
        CtrAlmacen crtAlm = new CtrAlmacen(frmAlm,almacenService,agenciaRepo);
        crtAlm.cargarAlmacenes();
        crtAlm.cargarAgencias();
        ctrSeccion.cargarSecciones();
        CtrFichaEncomienda ctrFicha = new CtrFichaEncomienda(ficha,fichaService,frmFicha,frmAlm,seccionService,encoService);
        ctrFicha.cargarEncomiendas();
        
//        NuevaFicha nuevaFicha = new NuevaFicha();
//        nuevaFicha.setVisible(true);
        
        Bienvenido bienvenido = new Bienvenido();
        bienvenido.setVisible(true);
        
    }
}
