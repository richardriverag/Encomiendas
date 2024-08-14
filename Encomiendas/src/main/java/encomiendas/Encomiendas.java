package encomiendas;

import encomiendas.views.transporte.JFMantenimiento;
import encomiendas.views.transporte.JFModTransporte;
import encomiendas.views.transporte.JFRuta;
import encomiendas.views.transporte.JFTransporte;
import javax.swing.JFrame;


public class Encomiendas {

    public static void main(String[] args) {
        DbUsuarios modDbCliente = new DbUsuarios();
        Login frmLogin = new Login();
        Registro frmRegistro = new Registro();
        frmRegistro.setVisible(false);
        RecuperarContrasenia frmRContrasenia = new RecuperarContrasenia();
        frmRContrasenia.setVisible(false);
        
        usuarioController crtUsuario = new usuarioController(modDbCliente, frmLogin, frmRegistro, frmRContrasenia);
        
        crtUsuario.iniciar();
        frmLogin.setVisible(true);

    }
}
