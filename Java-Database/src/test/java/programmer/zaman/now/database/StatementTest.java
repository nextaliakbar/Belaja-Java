package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

    @Test
    void testCreateStatement() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        statement.close();
        connection.close();
    }

    @Test
    void testExecuteUpdate() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                    INSERT INTO customer (id,name,email) 
                    VALUES ('001', 'Ali Akbar 1', 'aliakbar1@gmail.com')
                """;
        int update = statement.executeUpdate(sql);
        System.out.println(update);
        statement.close();
        connection.close();
    }

    @Test
    void testExecuteDelete() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                    DELETE FROM customer;
                """;
        int update = statement.executeUpdate(sql);
        System.out.println(update);
        statement.close();
        connection.close();
    }

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                    SELECT * FROM customer;
                """;
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("email"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
