package mrilki.repositoris;

import mrilki.models.Day;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DayRepositoryImpl implements DayRepository {
    private static final String SQL_SELECT_ALL = "SELECT * FROM day";
    private Connection connection;

    public DayRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Day> findByDate(Date date) throws SQLException {
        return null;
    }

    @Override
    public List<Day> findAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
        ResultSet resultSet = statement.executeQuery();

        List<Day> days = new ArrayList<>();

        while (resultSet.next()) {

        }
        return null;
    }

    @Override
    public Optional<Day> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void save(Day entity) throws SQLException {

    }

    @Override
    public void update(Day entity) throws SQLException {

    }

    @Override
    public void remove(Day entity) throws SQLException {

    }

    @Override
    public void removeById(Long id) throws SQLException {

    }


}
