package mrilki.repositoris;

import mrilki.models.Comment;

import java.sql.SQLException;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment> {
    Optional<Comment> findByUsername(String username) throws SQLException;


}
