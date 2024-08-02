package encomiendas.controllers.usuarios;

import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.model.data.usuarios.DbUsuarios;
import encomiendas.views.usuarios.Login;
import encomiendas.views.usuarios.MenuAdministrador;
import encomiendas.views.usuarios.MenuClientes;
import encomiendas.views.usuarios.MenuEmpleado;
import encomiendas.views.usuarios.RecuperarContrasenia;
import encomiendas.views.usuarios.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class usuarioController implements ActionListener{
    
    private DbUsuarios modeloDb;
    private Login frmLogin;
    private Registro frmRegistro;
    private RecuperarContrasenia frmRecuperarContrasenia;
    

    public usuarioController(DbUsuarios modeloDb, Login frmLogin, 
            Registro frmRegistro,RecuperarContrasenia frmRecuperarContrasenia) {
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
    
    public void iniciar(){
        frmLogin.setTitle("Login");
        frmLogin.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        //si se presiono el botón Ingresar
        if(e.getSource()== frmLogin.botonIngresar){
            String username= frmLogin.txtUsername.getText();
            System.out.println(username);
            String contrasenia= frmLogin.txtContrasenia.getText();
            System.out.println(contrasenia);
            String cedula=modeloDb.validarExistencia(username, contrasenia);
            System.out.println(cedula);
            if(cedula != null){
                //JOptionPane.showMessageDialog(null, "Se encontro el usuario");
                String rol = modeloDb.obtenerRol(cedula);
                if(rol.equals("Cliente")){
                    JOptionPane.showMessageDialog(null, "hola soy un cliente");
                    Cliente cliente = new Cliente();
                    cliente.setCedula(cedula);
                    cliente.obtenerDatos(cedula);//con esto obtengo todos los datos del cliente
                    
                    MenuClientes frmCliente= new MenuClientes();
                    frmLogin.dispose();
                    frmCliente.setVisible(true);
                }
                
                if(rol.equals("Administrador")){
                    JOptionPane.showMessageDialog(null, "hola soy un Administrador");
                    MenuAdministrador frmAdministrador= new MenuAdministrador();
                    frmLogin.dispose();
                    frmAdministrador.setVisible(true);
                }
                
                if(rol.equals("Conductor")){
                    JOptionPane.showMessageDialog(null, "hola soy un Conductor");
                    
                }
                if(rol.equals("Agencia")){
                    JOptionPane.showMessageDialog(null, "hola soy un Conductor");
                    MenuEmpleado frmEmpleado= new MenuEmpleado();
                    frmLogin.dispose();
                    frmEmpleado.setVisible(true);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuario o Contraña Incorrectos\nregistrese si aun no lo ha hecho");
            }
        }
        

        //si se presiono el botón Registrarse del frame login
        if(e.getSource()== frmLogin.registrarse){    
            frmRegistro.setVisible(true);
            frmLogin.setVisible(false);
            //frmLogin.dispose();   
        }
         
        //si se presiono el botón registrarse del frame Registro
        if(e.getSource()== frmRegistro.btnRegistrarse){   
            botonRegistrase(e);
        }
        
        //si se presiono el botón olvide mi contraseña del frame login
        if(e.getSource()== frmLogin.resetiarContrasenia){   
            frmRecuperarContrasenia.setVisible(true);
            frmLogin.setVisible(false);
        }
        
        //si se presiono el botón enviar del frame de Olvidar COntraseña
        /*if(e.getSource()== frmRecuperarContrasenia.btnEnviarContrasenia){   
            botonRecuperarContraseña(e);
        }*/
    }
    
    public void botonRegistrase(ActionEvent e){
        
        String cedula = frmRegistro.txtCedula.getText();
        String nombres= frmRegistro.txtNombres.getText();
        String apellidos= frmRegistro.txtApellidos.getText();
        String correo= frmRegistro.txtCorreo.getText();
        String telefono= frmRegistro.txtTelefono.getText();
        String telefono_Adicional= frmRegistro.txtTelefonoAdicional.getText();
        String rol= ("Cliente");
        String direccion= frmRegistro.txtDireccion.getText();
        String ciudad= frmRegistro.comboBoxCiudad.getSelectedItem().toString();
        int id_agencia;
        String contrasenia=frmRegistro.txtContrasenia.getText();
        String username=frmRegistro.txtUsername.getText();
        

        id_agencia = switch (ciudad) {
            case "Quito" -> 1;
            case "Guayaquil" -> 2;
            case "Cuenca" -> 3;
            default -> 1;
        };

        if(modeloDb.registrarCliente(cedula, nombres, apellidos, correo,telefono,telefono_Adicional, 
                    rol, direccion, ciudad, id_agencia)){
                modeloDb.crearCuenta(cedula,username,contrasenia);
                JOptionPane.showMessageDialog(null, "Se registro al cliente");
                frmRegistro.dispose();
                frmLogin.setVisible(true);
        }else{
                JOptionPane.showMessageDialog(null, "No se pudo registrar");
        }
    }
    
    /*public void botonRecuperarContraseña(ActionEvent e){
        
            modeloUsuario.setCorreo(frmRecuperarContrasenia.correoTxt.getText());
            
            frmRecuperarContrasenia.correoTxt.setText(null);
            frmRecuperarContrasenia.txtCedula.setText(null);
            
            if(modeloDb.validarExistencia(modeloUsuario)){
                
                JOptionPane.showMessageDialog(null, "Se envío un correo con sus credenciales");
                frmRegistro.dispose();
                frmLogin.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe en el sistema, Registrese");
                frmRecuperarContrasenia.dispose();
                frmLogin.setVisible(true);
                
            }
    }*/
 
}
