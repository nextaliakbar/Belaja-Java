package programmer.zaman.now.database.repository;

import programmer.zaman.now.database.entity.Comments;

import java.util.List;

public interface CommentRepository {

    void insert(Comments comments);

    Comments findById(Integer id);

    List<Comments> findAll();

    List<Comments> findByEmail(String email);
}
