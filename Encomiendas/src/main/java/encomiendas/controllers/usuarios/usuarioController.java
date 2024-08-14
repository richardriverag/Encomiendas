package encomiendas.controllers.usuarios;

import encomiendas.model.data.usuarios.DbCliente;
import encomiendas.model.data.usuarios.DbEmpleado;
import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.model.data.usuarios.DbUsuarios;
import encomiendas.model.entity.usuarios.Cuenta;
import encomiendas.model.entity.usuarios.Empleado;
import encomiendas.views.usuarios.Login;
import encomiendas.views.usuarios.MenuAdministrador;
import encomiendas.views.usuarios.MenuClientes;
import encomiendas.views.usuarios.MenuConductor;
import encomiendas.views.usuarios.MenuEmpleado;
import encomiendas.views.usuarios.PanelPerfilClientes;
import encomiendas.views.usuarios.RecuperarContrasenia;
import encomiendas.views.usuarios.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class usuarioController implements ActionListener {

    private DbUsuarios modeloDb;
    private Login frmLogin;
    private Registro frmRegistro;
    private RecuperarContrasenia frmRecuperarContrasenia;

    public usuarioController(DbUsuarios modeloDb, Login frmLogin, Registro frmRegistro, RecuperarContrasenia frmRecuperarContrasenia) {
        this.modeloDb = modeloDb;
        this.frmLogin = frmLogin;
        this.frmRegistro = frmRegistro;
        this.frmRecuperarContrasenia = frmRecuperarContrasenia;
        this.frmLogin.botonIngresar.addActionListener(this);
        this.frmLogin.resetiarContrasenia.addActionListener(this);
        this.frmLogin.registrarse.addActionListener(this);
        this.frmRegistro.btnRegistrarse.addActionListener(this);
        this.frmRecuperarContrasenia.btnEnviarContrasenia.addActionListener(this);
    }

    public void iniciar() {
        frmLogin.setTitle("Login");
        frmLogin.setLocationRelativeTo(null);
        frmLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //si se presiono el botón Ingresar
        if (e.getSource() == frmLogin.botonIngresar) {
            String username = frmLogin.txtUsername.getText();
            System.out.println(username);
            String contrasenia = frmLogin.txtContrasenia.getText();
            System.out.println(contrasenia);
            String cedula = modeloDb.validarExistencia(username, contrasenia);
            System.out.println(cedula);
            if (cedula != null) {
                //JOptionPane.showMessageDialog(null, "Se encontro el usuario");
                String rol = modeloDb.obtenerRol(cedula);
                if (rol.equals("Cliente")) {
                    JOptionPane.showMessageDialog(null, "hola soy un cliente");
                    Cliente cliente = new Cliente();
                    cliente.setCedula(cedula);
                    System.out.println(cliente.getCedula());
                    cliente.obtenerDatos(cedula);//con esto obtengo todos los datos del cliente

                    frmLogin.dispose();
                    abrirMenuCliente();
                }

                if (rol.equals("Empleado")) {
                    JOptionPane.showMessageDialog(null, "hola soy un empleado");
                    Empleado empleado = new Empleado();
                    empleado.setCedula(cedula);
                    empleado.obtenerDatos(cedula);

                    frmLogin.dispose();
                    abrirMenuEmpleado();
                }

                if (rol.equals("Administrador")) {
                    JOptionPane.showMessageDialog(null, "hola soy un Administrador");
                    MenuAdministrador frmAdministrador = new MenuAdministrador();
                    frmLogin.dispose();
                    frmAdministrador.jTFUsuarioAdministrador.setText(cedula);
                    frmAdministrador.setVisible(true);
                    frmAdministrador.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                }

                if (rol.equals("Conductor")) {
                    JOptionPane.showMessageDialog(null, "hola soy un Conductor");
                    MenuConductor frmConductor = new MenuConductor();
                    frmConductor.dispose();
                    frmConductor.jTFUsuarioConductor.setText(cedula);
                    frmConductor.setVisible(true);
                    frmConductor.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                }
                if (rol.equals("Agencia")) {
                    JOptionPane.showMessageDialog(null, "hola soy un Conductor");
                    MenuEmpleado frmEmpleado = new MenuEmpleado();
                    frmLogin.dispose();
                    frmEmpleado.setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Contraña Incorrectos\nregistrese si aun no lo ha hecho");
            }
        }

        //si se presiono el botón Registrarse del frame login
        if (e.getSource() == frmLogin.registrarse) {
            frmRegistro.setVisible(true);
            frmLogin.setVisible(false);
            //frmLogin.dispose();   
        }

        //si se presiono el botón registrarse del frame Registro
        if (e.getSource() == frmRegistro.btnRegistrarse) {
            botonRegistrase(e);
        }

        //si se presiono el botón olvide mi contraseña del frame login
        if (e.getSource() == frmLogin.resetiarContrasenia) {
            frmRecuperarContrasenia.setVisible(true);
            frmLogin.setVisible(false);
        }

        //si se presiono el botón enviar del frame de Olvidar COntraseña
        if(e.getSource()== frmRecuperarContrasenia.btnEnviarContrasenia){   
            botonRecuperarContraseña(e);
        }
    }

    public void botonRegistrase(ActionEvent e) {

        String cedula = frmRegistro.txtCedula.getText();
        String nombres = frmRegistro.txtNombres.getText();
        String apellidos = frmRegistro.txtApellidos.getText();
        String correo = frmRegistro.txtCorreo.getText();
        String telefono = frmRegistro.txtTelefono.getText();
        String telefono_Adicional = frmRegistro.txtTelefonoAdicional.getText();
        String rol = ("Cliente");
        String direccion = frmRegistro.txtDireccion.getText();
        String ciudad = frmRegistro.comboBoxCiudad.getSelectedItem().toString();
        int id_agencia;
        String contrasenia = frmRegistro.txtContrasenia.getText();
        String username = frmRegistro.txtUsername.getText();

        id_agencia = switch (ciudad) {
            case "Quito" ->
                1;
            case "Guayaquil" ->
                2;
            case "Cuenca" ->
                3;
            default ->
                1;
        };

        if (modeloDb.registrarCliente(cedula, nombres, apellidos, correo, telefono, telefono_Adicional,
                rol, direccion, ciudad, id_agencia)) {
            modeloDb.crearCuenta(cedula, username, contrasenia);
            JOptionPane.showMessageDialog(null, "Se registro al cliente");
            frmRegistro.dispose();
            frmLogin.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar");
        }
    }

    public void botonRecuperarContraseña(ActionEvent e){
        JOptionPane.showMessageDialog(null, "Se envio la clave a su correo");
        frmRecuperarContrasenia.dispose();
        frmLogin.setVisible(true);       
    }
    
    private void abrirMenuCliente() {
        DbCliente modClienteDb = new DbCliente();
        Cliente modCliente = new Cliente();
        MenuClientes frmClienteMenu = new MenuClientes();
        Cuenta modCuenta = new Cuenta();
        PanelPerfilClientes panelCliente = new PanelPerfilClientes();

        clienteController ctrCliente = new clienteController(modClienteDb, frmClienteMenu, panelCliente, modCliente, modCuenta);
        String username = frmLogin.txtUsername.getText();
        String contrasenia = frmLogin.txtContrasenia.getText();
        String cedula = modeloDb.validarExistencia(username, contrasenia);
        frmClienteMenu.jTFUsuarioCliente.setText(cedula);
        frmClienteMenu.setVisible(true);
        ctrCliente.iniciar();
    }

    
    private void abrirMenuEmpleado() {
        DbEmpleado modEmpleadoDb = new DbEmpleado();
        Empleado modEmp = new Empleado();
        MenuEmpleado frmEmpMenu = new MenuEmpleado();
        Cuenta modCuenta = new Cuenta();

        empleadoController ctrEmpleado = new empleadoController(modEmpleadoDb, modEmp, modCuenta,frmEmpMenu);
        String username = frmLogin.txtUsername.getText();
        String contrasenia = frmLogin.txtContrasenia.getText();
        String cedula = modeloDb.validarExistencia(username, contrasenia);
        frmEmpMenu.jTFUsuarioEmpleado.setText(cedula);
        ctrEmpleado.iniciar();
    }
    
   
}
