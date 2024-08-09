package encomiendas.services.usuarios;

import encomiendas.model.data.usuarios.ClienteRepository;
import encomiendas.model.entity.usuarios.Cliente;

import java.sql.SQLException;

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente getClienteById(String cedula) throws SQLException {
      return clienteRepository.getById(cedula);
    }

}
