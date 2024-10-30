package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class AutoIncrementTest {

    @Test
    void testAutoIncrement() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        String sql = "INSERT INTO comments (email, comment) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, "aliakbar@gmail.com");
        preparedStatement.setString(2, "Produk yang cocok");
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()) {
            int id = resultSet.getInt(1);
            System.out.println("id: " + id);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
