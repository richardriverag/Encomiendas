package encomiendas;

import encomiendas.controllers.agencia.agenciaController;
import encomiendas.model.data.agencias.DbAgencia;
import encomiendas.model.entity.agencias.Agencia;
import encomiendas.views.agencia.ConsultaAgencia;
import encomiendas.views.agencia.NuevaAgencia;
import encomiendas.views.agencias.ModificarInformacionAgencia;

public class Encomiendas {

    public static void main(String[] args) {
        Agencia agencia=new Agencia();
        DbAgencia dbagencia=new DbAgencia();
        ConsultaAgencia frmConsultaAgencia= new ConsultaAgencia();
        NuevaAgencia frmNuevaAgencia=new NuevaAgencia();
        ModificarInformacionAgencia frmModificarInformacionAgencia=new ModificarInformacionAgencia();
        
        agenciaController ctragencia=new agenciaController(agencia,dbagencia,frmConsultaAgencia,frmNuevaAgencia,frmModificarInformacionAgencia);
        ctragencia.iniciar();
        frmConsultaAgencia.setVisible(true);
        //frmNuevaAgencia.setVisible(true);
        //frmModificarInformacionAgencia.setVisible(true);
        /*
        JFTransporte transporte = new JFTransporte();
        transporte.setVisible(true);
        transporte.setResizable(false);
        transporte.setLocationRelativeTo(null);*/
    }
}