package encomiendas.model.data.usuarios;

import encomiendas.model.data.UserRepository;
import encomiendas.model.entity.usuarios.Administrador;
import encomiendas.model.entity.usuarios.Cliente;
import encomiendas.model.entity.usuarios.Conductor;
import encomiendas.model.entity.usuarios.Cuenta;
import encomiendas.model.entity.usuarios.Empleado;
import encomiendas.model.entity.usuarios.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements UserRepository<Usuario, String> {

    private Connection myConn;

    public UsuarioRepository(Connection myConn) {
        this.myConn = myConn;
    }

    @Override
    public List<Usuario> findAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        try (Statement myStatement = myConn.createStatement(); ResultSet myRs = myStatement.executeQuery("SELECT * FROM usuario")) {
            while (myRs.next()) {
                Usuario usuario = createUsuario(myRs);
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    @Override
    public void save(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (cedula, nombres, apellidos, correo, telefono, rol, direccion, ciudad, telefono_adicional, tipo_licencia, activo, id_agencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = myConn.prepareStatement(sql)) {
            ps.setString(1, usuario.getCedula());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, getRol(usuario));
            ps.setString(7, usuario instanceof Cliente ? ((Cliente) usuario).getDireccion() : null);
            ps.setString(8, usuario.getCiudad());
            ps.setString(9, usuario.getTelefonoAdicional());
            ps.setString(10, usuario instanceof Conductor ? ((Conductor) usuario).getTipoLicencia() : null);
            ps.setBoolean(11, usuario.getActivo());
            ps.setInt(12, usuario.getIdAgencia());
            ps.executeUpdate();
        }
    }

    @Override
    public Usuario getById(String cedula) throws SQLException {
        Usuario usuario = null;
        try (PreparedStatement myStatement = myConn.prepareStatement("SELECT * FROM usuario WHERE cedula = ?")) {
            myStatement.setString(1, cedula);
            ResultSet myRs = myStatement.executeQuery();
            if (myRs.next()) {
                usuario = createUsuario(myRs);
            }
        }
        return usuario;
    }

    @Override
    public void delete(String cedula) throws SQLException {
        String sql = "DELETE FROM usuario WHERE cedula = ?";
        try (PreparedStatement ps = myConn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.executeUpdate();
        }
    }

    @Override
    public void update(String cedula, Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nombres = ?, apellidos = ?, correo = ?, telefono = ?, rol = ?, direccion = ?, ciudad = ?, telefono_adicional = ?, tipo_licencia = ?, activo = ?, id_agencia = ? WHERE cedula = ?";
        try (PreparedStatement ps = myConn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, getRol(usuario));
            ps.setString(6, usuario instanceof Cliente ? ((Cliente) usuario).getDireccion() : null);
            ps.setString(7, usuario.getCiudad());
            ps.setString(8, usuario.getTelefonoAdicional());
            ps.setString(9, usuario instanceof Conductor ? ((Conductor) usuario).getTipoLicencia() : null);
            ps.setBoolean(10, usuario.getActivo());
            ps.setInt(11, usuario.getIdAgencia());
            ps.setString(12, cedula);
            ps.executeUpdate();
        }
    }

    private Usuario createUsuario(ResultSet myRs) throws SQLException {
        String rol = myRs.getString("rol");
        Usuario usuario;

        switch (rol) {
            case "Administrador":
                usuario = new Administrador();
                break;
            case "Cliente":
                usuario = new Cliente();
                ((Cliente) usuario).setDireccion(myRs.getString("direccion"));
                break;
            case "Conductor":
                usuario = new Conductor();
                ((Conductor) usuario).setTipoLicencia(myRs.getString("tipo_licencia"));
                break;
            case "Empleado":
                usuario = new Empleado();
                break;
            default:
                throw new IllegalArgumentException("Rol desconocido: " + rol);
        }

        usuario.setCedula(myRs.getString("cedula"));
        usuario.setNombres(myRs.getString("nombres"));
        usuario.setApellidos(myRs.getString("apellidos"));
        usuario.setCorreo(myRs.getString("correo"));
        usuario.setTelefono(myRs.getString("telefono"));
        // Rol
        // Direccion
        usuario.setCiudad(myRs.getString("ciudad"));
        usuario.setTelefonoAdicional(myRs.getString("telefono_Adicional"));
        // Licencia
        usuario.setActivo(myRs.getBoolean("activo"));
        usuario.setIdAgencia(myRs.getInt("id_agencia"));

        return usuario;
    }

    public List<Usuario> findByRol(String rol) throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario WHERE rol = ?";

        try (PreparedStatement stmt = myConn.prepareStatement(query)) {
            stmt.setString(1, rol);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = createUsuario(rs); // Reutiliza el método createUsuario
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    private String getRol(Usuario usuario) {
        if (usuario instanceof Administrador) {
            return "Administrador";
        } else if (usuario instanceof Cliente) {
            return "Cliente";
        } else if (usuario instanceof Conductor) {
            return "Conductor";
        } else if (usuario instanceof Empleado) {
            return "Empleado";
        } else {
            throw new IllegalArgumentException("Tipo de usuario desconocido: " + usuario.getClass().getName());
        }
    }

    public List<Cuenta> findAllC() throws SQLException {
        List<Cuenta> cuentas = new ArrayList<>();
        String query = "SELECT * FROM cuenta";

        try (Statement stmt = myConn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Cuenta cuenta = createCuenta(rs);
                cuentas.add(cuenta);
            }
        }
        return cuentas;
    }

    public void saveC(Cuenta cuenta) throws SQLException {
        String sql = "INSERT INTO cuenta (cedula, username, contrasenia) VALUES (?, ?, ?)";
        try (PreparedStatement ps = myConn.prepareStatement(sql)) {
            ps.setString(1, cuenta.getCedula());
            ps.setString(2, cuenta.getUsername());
            ps.setString(3, cuenta.getContrasenia());
            ps.executeUpdate();
        }
    }

    public Cuenta getByIdC(Integer id) throws SQLException {
        Cuenta cuenta = null;
        String sql = "SELECT * FROM cuenta WHERE id_cuenta = ?";
        try (PreparedStatement ps = myConn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cuenta = createCuenta(rs);
                }
            }
        }
        return cuenta;
    }

    public void deleteC(String cedula) throws SQLException {
        String sql = "DELETE FROM cuenta WHERE cedula = ?";
        try (PreparedStatement ps = myConn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.executeUpdate();
        }
    }

    public void updateC(Integer id, Cuenta cuenta) throws SQLException {
        String sql = "UPDATE cuenta SET cedula = ?, username = ?, contrasenia = ? WHERE id_cuenta = ?";
        try (PreparedStatement ps = myConn.prepareStatement(sql)) {
            ps.setString(1, cuenta.getCedula());
            ps.setString(2, cuenta.getUsername());
            ps.setString(3, cuenta.getContrasenia());
            ps.setInt(4, id);
            ps.executeUpdate();
        }
    }

    public boolean hasCuenta(String cedula) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cuenta WHERE cedula = ?";
        try (PreparedStatement ps = myConn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Retorna true si hay al menos una cuenta asociada
                }
            }
        }
        return false; // No se encontró ninguna cuenta asociada
    }

    public Cuenta getCuentaByCedula(String cedula) throws SQLException {
        String sql = "SELECT * FROM cuenta WHERE cedula = ?";
        try (PreparedStatement ps = myConn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return createCuenta(rs); // Usa el método de la misma clase para crear la cuenta
                }
            }
        }
        return null;
    }

    private Cuenta createCuenta(ResultSet myRs) throws SQLException {
        Cuenta cuenta = new Cuenta();
        cuenta.setCedula(myRs.getString("cedula"));
        cuenta.setUsername(myRs.getString("username"));
        cuenta.setContrasenia(myRs.getString("contrasenia"));
        
        cuenta.setCedula(myRs.getString("cedula"));
        return cuenta;
    }

}
