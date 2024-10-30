package programmer.zaman.now.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.database.entity.Comments;
import programmer.zaman.now.database.repository.CommentRepository;
import programmer.zaman.now.database.repository.CommentRepositoryImpl;

import java.util.List;

public class RepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comments comments = new Comments("user1@gmail.com", "Hi!");
        commentRepository.insert(comments);
        Assertions.assertNotNull(comments.getId());
        System.out.println(comments.getId());
    }

    @Test
    void testFindById() {
        Comments comments = commentRepository.findById(2410);
        Assertions.assertNotNull(comments);
        System.out.println(comments.getId());
        System.out.println(comments.getEmail());
        System.out.println(comments.getComment());
    }

    @Test
    void testFindAll() {
        List<Comments> comments = commentRepository.findAll();
        System.out.println(comments.size());
        comments.forEach(comment -> {
            System.out.println(comment.getId());
            System.out.println(comment.getEmail());
            System.out.println(comment.getComment());
        });
    }

    @Test
    void testFindByEmail() {
        List<Comments> comments = commentRepository.findByEmail("user1@gmail.com");
        System.out.println(comments.size());
        comments.forEach(comment -> {
            System.out.println(comment.getId());
            System.out.println(comment.getEmail());
            System.out.println(comment.getComment());
        });
    }
}
