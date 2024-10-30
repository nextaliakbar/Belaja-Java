package programmer.zaman.now.database.repository;

import programmer.zaman.now.database.ConnectionUtil;
import programmer.zaman.now.database.entity.Comments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{
    @Override
    public void insert(Comments comments) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "INSERT INTO comments (email, comment) VALUES (?,?)";
            try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, comments.getEmail());
                statement.setString(2, comments.getComment());
                statement.executeUpdate();
                try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if(generatedKeys.next()) {
                        comments.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch(SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Comments findById(Integer id) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try(ResultSet resultSet = statement.executeQuery()) {
                    if(resultSet.next()) {
                        return new Comments(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        );
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Comments> findAll() {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments";
            try(Statement statement = connection.createStatement()) {
                List<Comments> comments = new ArrayList<>();
                try(ResultSet resultSet = statement.executeQuery(sql)) {
                    while(resultSet.next()) {
                        comments.add(new Comments(
                           resultSet.getInt("id"),
                           resultSet.getString("email"),
                           resultSet.getString("comment")
                        ));
                    }
                }
                return comments;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Comments> findByEmail(String email) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments WHERE email = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                List<Comments> comments = new ArrayList<>();
                try(ResultSet resultSet = statement.executeQuery()) {
                    while(resultSet.next()) {
                        comments.add(new Comments(
                            resultSet.getInt("id"),
                            resultSet.getString("email"),
                            resultSet.getString("comment")
                        ));
                    }
                }
                return comments;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
