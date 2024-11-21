import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UsersRepositoryJdbcImpl implements UserRepository {

    private Connection connection;

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = String.format("select * from test1");
        return findBySqlReq(sql);
    }

    @Override
    public Optional<User> findById(Long id) throws SQLException {
        String sql = "SELECT * FROM test1 WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return Optional.of(new User(resultSet.getLong("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getInt("age"),
                    resultSet.getString("city"),
                    resultSet.getInt("height"),
                    resultSet.getInt("weight")));
        }

        return Optional.empty();
    }

    @Override
    public void save(User entity) throws SQLException {
        String sql = "INSERT INTO test1 (firstname, lastname, age, city, height, weight) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setInt(3, entity.getAge());
        statement.setString(4, entity.getCity());
        statement.setInt(5, entity.getHeight());
        statement.setInt(6, entity.getWeight());

        statement.executeUpdate();
    }


    @Override
    public void update(User entity) throws SQLException {
        Long userID = entity.getId();
        String sql = "UPDATE test1 SET firstname = ?, lastname = ?, age = ?, city = ?, height = ?, weight = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setInt(3, entity.getAge());
        statement.setString(4, entity.getCity());
        statement.setInt(5, entity.getHeight());
        statement.setInt(6, entity.getWeight());
        statement.setLong(7, userID);

        statement.executeUpdate();
    }

    @Override
    public void remove(User entity) throws SQLException {
        Long userID = entity.getId();
        removeById(userID);
    }

    @Override
    public void removeById(Long id) throws SQLException {
        String sql = "DELETE FROM test1 WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);

        statement.executeUpdate();
    }

    @Override
    public void save(int count) throws SQLException {
        String sql = "INSERT INTO test1 (firstname, lastname, age, city, height, weight) VALUES (?, ?, ?, ?, ?, ?)";
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, scan.next());
            statement.setString(2, scan.next());
            statement.setInt(3, scan.nextInt());
            statement.setString(4, scan.next());
            statement.setInt(5, scan.nextInt());
            statement.setInt(6, scan.nextInt());
            statement.executeUpdate();
        }
    }

    public List<User> findBySqlReq(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<User> result = new ArrayList<>();

        while (resultSet.next()) {
            User user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getInt("age"),
                    resultSet.getString("city"),
                    resultSet.getInt("height"),
                    resultSet.getInt("weight")
            );
            result.add(user);
        }
        return result;
    }

    @Override
    public List<User> findAllByAge(Integer age) throws SQLException {
        String sql = String.format("select * from test1 where age = %d", age);
        return findBySqlReq(sql);
    }


    @Override
    public List<User> findAllByCity(String city) throws SQLException {
        String sql = String.format("select * from test1 where city = %s", city);
        return findBySqlReq(sql);
    }

    @Override
    public List<User> findAllByHeight(Integer height) throws SQLException {
        String sql = String.format("select * from test1 where height = %d", height);
        return findBySqlReq(sql);
    }

    @Override
    public List<User> findAllByWeight(Integer weight) throws SQLException {
        String sql = String.format("select * from test1 where weight = %d", weight);
        return findBySqlReq(sql);
    }
}
