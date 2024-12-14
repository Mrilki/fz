package mrilki.repositoris;

import mrilki.models.Image;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class ImageRepositoryImpl implements ImageRepository {

    private Connection connection;

    public ImageRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Optional<Image> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void save(Image entity) throws SQLException {

    }

    @Override
    public void update(Image entity) throws SQLException {

    }

    @Override
    public void remove(Image entity) throws SQLException {

    }

    @Override
    public void removeById(Long id) throws SQLException {

    }


}
