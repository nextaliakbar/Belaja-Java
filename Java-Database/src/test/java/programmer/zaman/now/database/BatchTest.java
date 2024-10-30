package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {

    @Test
    void testBatchStatement() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO comments(email,comment) VALUES('aliakbar@gmaail.com', 'Produk Yang Bagus')";
        for (int i = 0; i < 1000; i++) {
            statement.addBatch(sql);
        }
        statement.executeBatch();
        statement.close();
        connection.close();
    }

    @Test
    void testBatchPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email,comment) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 1000; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "aliakbar@gmaail.com");
            preparedStatement.setString(2, "Produk yang Cocok");
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        preparedStatement.close();
        connection.close();
    }
}
