package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {

    @Test
    void testPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        String username = "admin'; #"; // contoh SQL injection
        String password = "admin";
        String sql = """
                SELECT * FROM admin WHERE username=? AND password=?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            System.out.println("Sukses Login " + resultSet.getString("username"));
        } else {
            System.out.println("Gagal Login ");
        }
    }
}
