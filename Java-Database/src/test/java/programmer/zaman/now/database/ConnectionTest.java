package programmer.zaman.now.database;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testConnection() {
        String jdbUrl = "jdbc:mysql://localhost:3306/db_inventaris";
        String username = "root";
        String password = "";
        try {
        Connection connection = DriverManager.getConnection(jdbUrl, username, password);
        System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testConnectionClose() {
        String jdbUrl = "jdbc:mysql://localhost:3306/db_inventaris";
        String username = "root";
        String password = "";
        try(Connection connection = DriverManager.getConnection(jdbUrl, username, password)) {
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
