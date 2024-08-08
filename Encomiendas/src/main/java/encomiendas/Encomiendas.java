package encomiendas;

import encomiendas.controllers.usuarios.usuarioController;
import encomiendas.model.data.usuarios.DbUsuarios;
import encomiendas.views.usuarios.Login;
import encomiendas.views.usuarios.RecuperarContrasenia;
import encomiendas.views.usuarios.Registro;

/**
 *
 * @author Richard
 */
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
