package encomiendas.model.data.usuarios;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository<T> {

    List<T> findAll() throws SQLException;

    T getById(String cedula) throws SQLException;

    void save(T t) throws SQLException;

    void delete(String cedula) throws SQLException;

    void update(String cedula, T t) throws SQLException;


}
