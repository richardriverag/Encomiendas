package encomiendas.model.data;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository<T, ID> {

    List<T> findAll() throws SQLException;

    void save(T t) throws SQLException;

    T getById(ID id) throws SQLException;

    void delete(ID id) throws SQLException;

    void update(ID id, T t) throws SQLException;
}
