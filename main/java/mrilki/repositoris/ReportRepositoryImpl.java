package mrilki.repositoris;

import mrilki.models.Report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ReportRepositoryImpl implements ReportRepository {

    private Connection connection;

    public ReportRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Report> findAll() throws SQLException {
        return null;
    }

    @Override
    public void acceptReport() throws SQLException {

    }

    @Override
    public void cancelReport() throws SQLException {

    }

    @Override
    public void sendReport() throws SQLException {

    }

    @Override
    public Optional<Report> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void save(Report entity) throws SQLException {

    }

    @Override
    public void update(Report entity) throws SQLException {

    }

    @Override
    public void remove(Report entity) throws SQLException {

    }

    @Override
    public void removeById(Long id) throws SQLException {

    }

}
