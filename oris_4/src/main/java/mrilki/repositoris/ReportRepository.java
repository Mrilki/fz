package mrilki.repositoris;

import mrilki.models.Day;
import mrilki.models.Report;

import java.sql.SQLException;
import java.util.List;


public interface ReportRepository extends CrudRepository<Report> {
    List<Report> findAll() throws SQLException;

    void acceptReport() throws SQLException;

    void cancelReport() throws SQLException;

    void sendReport() throws SQLException;
}
