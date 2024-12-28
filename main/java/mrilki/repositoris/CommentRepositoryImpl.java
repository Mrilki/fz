package mrilki.repositoris;

import mrilki.models.Comment;
import mrilki.models.Day;
import mrilki.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CommentRepositoryImpl implements CommentRepository {

    private Connection connection;

    private static final String SQL_SELECT_FROM_COMMENT_BY_ID = "SELECT * FROM comment WHERE id = ?";
    private static final String SQL_SELECT_FROM_COMMENT_BY_USERNAME = "SELECT * FROM comment WHERE username = ?";
    private static final String SQL_INSERT_NEW_COMMENT = "INSERT INTO comment (text, day_id, user_day) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE_COMMENT = "UPDATE comment SET text = ?, author_id, day_id = ? WHERE user_id = ?";
    private static final String SQL_DELETE_COMMENT_BY_ID = "DELETE FROM comment WHERE id = ?";

    public CommentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Comment> findByUsername(String username) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FROM_COMMENT_BY_USERNAME);
        statement.setString(1, username);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return Optional.of(new Comment(resultSet.getLong("username"),
                    resultSet.getString("text"),
                    resultSet.getLong("author_id"),
                    resultSet.getLong("day_id")));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Comment> findById(Long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FROM_COMMENT_BY_ID);
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return Optional.of(new Comment(resultSet.getLong("id"),
                    resultSet.getString("text"),
                    resultSet.getLong("author_id"),
                    resultSet.getLong("day_id")));
        }
        return Optional.empty();
    }

    @Override
    public void save(Comment entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_NEW_COMMENT);
        statement.setString(1, entity.getText());
        statement.setLong(2, entity.getAuthor_id());
        statement.setLong(3, entity.getDay_id());
        statement.executeUpdate();
    }

    @Override
    public void update(Comment entity) throws SQLException {
        Long commentId = entity.getId();

        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_COMMENT);
        statement.setString(1, entity.getText());
        statement.setLong(2, entity.getAuthor_id());
        statement.setLong(3, entity.getDay_id());
        statement.setLong(4, commentId);
        statement.executeUpdate();
    }

    @Override
    public void remove(Comment entity) throws SQLException {
        Long commentId = entity.getId();
        removeById(commentId);
    }

    @Override
    public void removeById(Long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_DELETE_COMMENT_BY_ID);
        statement.setLong(1, id);
        statement.executeUpdate();
    }


}
