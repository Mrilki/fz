import java.sql.SQLException;
import java.util.List;

public interface UserRepository extends CrudRepository<User> {
    List<User> findAllByAge(Integer age) throws SQLException;
    List<User> findAllByCity(String city) throws SQLException;
    List<User> findAllByHeight(Integer height) throws SQLException;
    List<User> findAllByWeight(Integer weight) throws SQLException;
}
