package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrasactionTest {

    @Test
    public void testCommit() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO comments(email,comment) VALUES(?,?)";
        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "aliakbar@gmaail.com");
            preparedStatement.setString(2, "Produk yang Cocok");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        connection.commit();
        connection.close();
    }

    @Test
    void testRollback() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO comments(email,comment) VALUES(?,?)";
        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "aliakbar@gmaail.com");
            preparedStatement.setString(2, "Produk yang Cocok");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        connection.rollback();
        connection.close();
    }
}
