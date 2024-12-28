package mrilki.repositoris;

import mrilki.models.Day;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface DayRepository extends CrudRepository<Day> {
    List<Day> findByDate(Date date) throws SQLException;

    List<Day> findAll() throws SQLException;



}
