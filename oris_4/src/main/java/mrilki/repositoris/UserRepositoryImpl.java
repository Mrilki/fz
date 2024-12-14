package mrilki.repositoris;

import mrilki.models.User;

import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private Connection connection;

    private static final String SQL_SELECT_FROM_USERS_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    private static final String SQL_SELECT_FROM_USERS_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_INSERT_NEW_USER = "INSERT INTO users (first_name, last_name, age, password, username) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_USER = "UPDATE users SET firstname = ?, lastname = ?, age = ?, password = ?, username = ? WHERE id = ?";
    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id = ?";

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean checkUsername(String username) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FROM_USERS_BY_USERNAME);
        statement.setString(1, username);

        ResultSet resultSet = statement.executeQuery();

        return !resultSet.next();
    }

    @Override
    public boolean checkPassword(String password, String username) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FROM_USERS_BY_USERNAME);
        statement.setString(1, username);

        ResultSet resultSet = statement.executeQuery();
        //Нужно добавить хэширования
        return resultSet.getString("password").equals(password);
    }

    @Override
    public Optional<User> findByUsername(String username) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FROM_USERS_BY_USERNAME);
        statement.setString(1, username);

        ResultSet resultSet = statement.executeQuery();


        if (resultSet.next()) {
            return Optional.of(new User(resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age"),
                    resultSet.getString("password")));
        }

        return Optional.empty();
    }

    @Override
    public List<User> showAllFriends(User user) throws SQLException {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FROM_USERS_BY_ID);
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();


        if (resultSet.next()) {
            return Optional.of(new User(resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age"),
                    resultSet.getString("password")));
        }

        return Optional.empty();
    }

    @Override
    public void save(User entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_NEW_USER);
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setInt(3, entity.getAge());
        statement.setString(4, entity.getPassword());
        statement.setString(5, entity.getUsername());
        statement.executeUpdate();
    }

    @Override
    public void update(User entity) throws SQLException {
        Long userId = entity.getId();

        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER);
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setInt(3, entity.getAge());
        statement.setString(4, entity.getPassword());
        statement.setString(5, entity.getUsername());
        statement.setLong(6, userId);
        statement.executeUpdate();
    }

    @Override
    public void remove(User entity) throws SQLException {
        Long userID = entity.getId();
        removeById(userID);
    }

    @Override
    public void removeById(Long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER);
        statement.setLong(1, id);
        statement.executeUpdate();
    }

}
