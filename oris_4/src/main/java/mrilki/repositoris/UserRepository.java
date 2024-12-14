package mrilki.repositoris;

import mrilki.models.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    boolean checkUsername(String username) throws SQLException;

    boolean checkPassword(String password, String username) throws SQLException;

    Optional<User> findByUsername(String username) throws SQLException;

    List<User> showAllFriends(User user) throws SQLException;
}
