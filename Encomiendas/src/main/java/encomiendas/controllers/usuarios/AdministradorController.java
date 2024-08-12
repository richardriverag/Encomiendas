package encomiendas.controllers.usuarios;

import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.model.entity.usuarios.Conductor;
import encomiendas.model.entity.usuarios.Cuenta;
import encomiendas.model.entity.usuarios.Usuario;
import encomiendas.services.usuarios.UsuarioService;
import encomiendas.views.usuarios.AEdiciónUsuario;
import encomiendas.views.usuarios.MenuAdministrador;
import encomiendas.views.usuarios.AActualizarUsuarios;
import encomiendas.views.usuarios.AIngresoUsuarios;
import encomiendas.views.usuarios.AListaUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdministradorController implements ActionListener {

    private JFrame view;
    private MenuAdministrador frameMenuAdministrador;
    private UsuarioService usuarioService;

    private AListaUsuarios frameListaUsuarios;
    private AIngresoUsuarios frameIngresoUsuarios;
    private AActualizarUsuarios frameActualizarUsuarios;
    private AEdiciónUsuario frameEdiciónUsuario;

    public AdministradorController(JFrame view, UsuarioService usuarioService) {
        this.view = view;
        this.usuarioService = usuarioService;
    }

    public AdministradorController(MenuAdministrador frameMenuAdministrador, UsuarioService usuarioService) {
        this.frameMenuAdministrador = frameMenuAdministrador;
        this.usuarioService = usuarioService;

        // Inicializar los otros JFrames
        this.frameListaUsuarios = new AListaUsuarios();
        this.frameIngresoUsuarios = new AIngresoUsuarios();
        this.frameActualizarUsuarios = new AActualizarUsuarios();
        this.frameEdiciónUsuario = new AEdiciónUsuario();

        this.frameMenuAdministrador.btListaUsuarios.addActionListener(this);
        this.frameMenuAdministrador.btIngresoUsuarios.addActionListener(this);
        this.frameMenuAdministrador.btActualizarUsuarios.addActionListener(this);
    }

    public void iniciar() {
        frameMenuAdministrador.setTitle("Gestión de Usuarios");
        frameMenuAdministrador.setLocationRelativeTo(null);
        frameMenuAdministrador.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frameMenuAdministrador.btListaUsuarios) {
            mostrarFrameListaUsuarios();
        } else if (e.getSource() == frameMenuAdministrador.btIngresoUsuarios) {
            mostrarFrameIngresoUsuarios();
        } else if (e.getSource() == frameMenuAdministrador.btActualizarUsuarios) {
            mostrarFrameActualizarUsuarios();
        }
    }

    public void ListarUsuariosTable(DefaultTableModel modelTablaUsuarios) {
        try {
            // Obtener la lista de usuarios desde el servicio
            List<Usuario> listaUsuarios = usuarioService.getAllUsuarios();

            // Limpiar cualquier fila existente en la tabla (opcional)
            modelTablaUsuarios.setRowCount(0);

            // Iterar sobre la lista de usuarios e insertar cada uno en la tabla
            for (Usuario usuario : listaUsuarios) {

                Object[] fila = new Object[]{
                    usuario.getCedula(),
                    usuario.getNombres(),
                    usuario.getApellidos(),
                    usuario.getCorreo(),
                    usuario.getTelefono(),
                    usuario.getClass().getSimpleName(), // Nombre de la clase que representa el rol
                    (usuario instanceof Cliente) ? ((Cliente) usuario).getDireccion() : "NULL", // Obtener dirección si es Cliente
                    usuario.getCiudad(),
                    usuario.getTelefonoAdicional(),
                    (usuario instanceof Conductor) ? ((Conductor) usuario).getTipoLicencia() : "NULL", // Obtener tipo de licencia si es Conductor
                    usuario.getActivo(),
                    usuario.getIdAgencia()

                };
                // Agregar la fila al modelo de la tabla
                modelTablaUsuarios.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void buscarUsuario(DefaultTableModel modelTablaUsuarios, String cedula) {
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(frameListaUsuarios, "Ingrese una cédula para buscar.");
            return;
        }

        try {
            Usuario usuario = usuarioService.getUsuarioById(cedula);
            modelTablaUsuarios.setRowCount(0); // Limpiar la tabla antes de mostrar los resultados

            if (usuario != null) {
                Object[] fila = new Object[]{
                    usuario.getCedula(),
                    usuario.getNombres(),
                    usuario.getApellidos(),
                    usuario.getCorreo(),
                    usuario.getTelefono(),
                    usuario.getClass().getSimpleName(), // Nombre de la clase que representa el rol
                    (usuario instanceof Cliente) ? ((Cliente) usuario).getDireccion() : "NULL", // Obtener dirección si es Cliente
                    usuario.getCiudad(),
                    usuario.getTelefonoAdicional(),
                    (usuario instanceof Conductor) ? ((Conductor) usuario).getTipoLicencia() : "NULL", // Obtener tipo de licencia si es Conductor
                    usuario.getActivo(),
                    usuario.getIdAgencia()
                };
                modelTablaUsuarios.addRow(fila);
            } else {
                JOptionPane.showMessageDialog(frameListaUsuarios, "No se encontró ningún usuario con esa cédula.");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(frameListaUsuarios, "Error al buscar el usuario.");
        }
    }

    public void eliminarUsuario(String cedula) {
        try {
            // Verificar si el usuario tiene una cuenta asociada
            if (usuarioService.hasCuenta(cedula)) {
                // Obtener la cuenta asociada por cédula
                Cuenta cuenta = usuarioService.getCuentaByCedula(cedula);
                if (cuenta != null) {
                    int idCuenta = cuenta.getId_cuenta();

                    // Mostrar mensaje informativo
                    int confirm = JOptionPane.showConfirmDialog(frameListaUsuarios,
                            "Para eliminar el usuario, también es necesario eliminar la cuenta asociada. ¿Desea proceder?",
                            "Confirmar Eliminación",
                            JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        // Eliminar la cuenta asociada
                        usuarioService.deleteCuenta(cedula);
                        // Eliminar el usuario
                        usuarioService.deleteUsuario(cedula);
                    } else {
                        return; // Si el usuario no confirma, no hacer nada más
                    }
                }
            }

            // Actualiza la tabla después de la eliminación
            ListarUsuariosTable((DefaultTableModel) frameListaUsuarios.jTListaUsuarios.getModel());

            // Muestra un mensaje de éxito
            JOptionPane.showMessageDialog(frameListaUsuarios, "Usuario y cuenta eliminados exitosamente.");
        } catch (SQLException e) {
            // Maneja el error de eliminación mostrando un mensaje de error
            JOptionPane.showMessageDialog(frameListaUsuarios, "No se pudo eliminar el usuario y/o la cuenta: " + e.getMessage());
        }
    }

    public void filtrarUsuariosPorRol(DefaultTableModel tableModel, String rol) throws SQLException {
        List<Usuario> usuariosFiltrados = usuarioService.obtenerUsuariosPorRol(rol);
        tableModel.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

        for (Usuario usuario : usuariosFiltrados) {
            Object[] rowData = {
                usuario.getCedula(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getCorreo(),
                usuario.getTelefono(),
                usuario.getClass().getSimpleName(), // Nombre de la clase que representa el rol
                (usuario instanceof Cliente) ? ((Cliente) usuario).getDireccion() : "NULL", // Obtener dirección si es Cliente
                usuario.getCiudad(),
                usuario.getTelefonoAdicional(),
                (usuario instanceof Conductor) ? ((Conductor) usuario).getTipoLicencia() : "NULL", // Obtener tipo de licencia si es Conductor
                usuario.getActivo(),
                usuario.getIdAgencia()
            };
            tableModel.addRow(rowData);
        }
    }

    public void registrarUsuarioYCrearCuenta(Usuario usuario) throws SQLException {
        // Guardar el usuario
        usuarioService.saveUsuario(usuario);

        // Crear y guardar la cuenta
        Cuenta cuenta = new Cuenta();
        String cedula = usuario.getCedula();
        String username = usuario.getNombres().toLowerCase() + usuario.getApellidos().toLowerCase().replace(" ", "");
        String contrasenia = "password123";

        cuenta.setCedula(cedula);
        cuenta.setUsername(username);
        cuenta.setContrasenia(contrasenia);

        usuarioService.saveCuenta(cuenta);
    }
   
    private void mostrarFrameListaUsuarios() {
        frameListaUsuarios.setLocationRelativeTo(null);  // Centrar el JFrame
        frameListaUsuarios.setVisible(true);
    }

    private void mostrarFrameIngresoUsuarios() {
        frameIngresoUsuarios.setLocationRelativeTo(null);  // Centrar el JFrame
        frameIngresoUsuarios.setVisible(true);
    }

    private void mostrarFrameActualizarUsuarios() {
        frameActualizarUsuarios.setLocationRelativeTo(null);  // Centrar el JFrame
        frameActualizarUsuarios.setVisible(true);
    }
}
