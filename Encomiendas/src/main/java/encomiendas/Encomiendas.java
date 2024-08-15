package encomiendas;

import encomiendas.controllers.agencias.AgenciaController;
import encomiendas.model.data.agencias.DbAgencia;
import encomiendas.model.entity.agencias.Agencia;
import encomiendas.views.agencias.ConsultaAgencia;
import encomiendas.views.agencias.ModificarInformacionAgencia;
import encomiendas.views.agencias.NuevaAgencia;
import encomiendas.views.agencias.VerChoferes;
import encomiendas.views.usuarios.MenuAdministrador;
import encomiendas.views.usuarios.MenuClientes;
import encomiendas.views.usuarios.MenuEmpleado;

public class Encomiendas {

public static void main(String[] args) {
        Agencia agencia=new Agencia();
        DbAgencia dbagencia=new DbAgencia();
        ConsultaAgencia frmConsultaAgencia= new ConsultaAgencia();
        NuevaAgencia frmNuevaAgencia=new NuevaAgencia();
        ModificarInformacionAgencia frmModificarInformacionAgencia=new ModificarInformacionAgencia();
        VerChoferes frmVerChoferes=new VerChoferes();
        
        AgenciaController ctragencia=new AgenciaController(agencia,dbagencia,frmConsultaAgencia,frmNuevaAgencia,frmModificarInformacionAgencia,frmVerChoferes);
        ctragencia.iniciar();
        //frmConsultaAgencia.setVisible(true);
        //frmNuevaAgencia.setVisible(true);
        //frmModificarInformacionAgencia.setVisible(true);
        //frmActualizarAgencia.setVisible(true);
        //frmVerChoferes.setVisible(true);
        
            // Crear una instancia de MenuEmpleado
    
    MenuEmpleado menuEmpleado = new MenuEmpleado();
    menuEmpleado.setVisible(true);
    
    
    //MenuClientes menuClientes = new MenuClientes ();
    //menuClientes.setVisible(true);
    
    //MenuAdministrador menuAdministrador= new MenuAdministrador ();
    //menuAdministrador.setVisible(true);
    }
}