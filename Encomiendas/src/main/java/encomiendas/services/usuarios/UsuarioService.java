package encomiendas.services.usuarios;

import encomiendas.model.data.usuarios.UsuarioRepository;
import encomiendas.model.entity.usuarios.Cuenta;
import encomiendas.model.entity.usuarios.Usuario;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuarios() throws SQLException {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(String cedula) throws SQLException {
        return usuarioRepository.getById(cedula);
    }

    public void saveUsuario(Usuario usuario) throws SQLException {
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(String cedula) throws SQLException {
        usuarioRepository.delete(cedula);
    }

    public void updateUsuario(String cedula, Usuario usuario) throws SQLException {
        usuarioRepository.update(cedula, usuario);
    }

    public List<Usuario> obtenerUsuariosPorRol(String rol) throws SQLException {
        return usuarioRepository.findByRol(rol);
    }

    public List<Cuenta> getAllCuentas() throws SQLException {
        return usuarioRepository.findAllC();
    }

    public Cuenta getCuentaById(Integer id_cuenta) throws SQLException {
        return usuarioRepository.getByIdC(id_cuenta);
    }

    public void saveCuenta(Cuenta cuenta) throws SQLException {
        usuarioRepository.saveC(cuenta);
    }

    public void deleteCuenta(String cedula) throws SQLException {
        usuarioRepository.deleteC(cedula);
    }

    public boolean hasCuenta(String cedula) throws SQLException {
        return usuarioRepository.hasCuenta(cedula);
    }

    public Cuenta getCuentaByCedula(String cedula) throws SQLException {
        return usuarioRepository.getCuentaByCedula(cedula);
    }

}
