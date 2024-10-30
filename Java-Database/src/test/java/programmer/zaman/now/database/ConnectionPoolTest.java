package programmer.zaman.now.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    void testHikariCP() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/db_inventaris");
        config.setUsername("root");
        config.setPassword("");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

        try {
            HikariDataSource dataSource = new HikariDataSource(config);
            Connection connection = dataSource.getConnection();
            connection.close(); // Jika menggunakan hikari config, maka sebenarnya tidak menutup koneksi
            dataSource.close(); // Menutup semua koneksi dalam koneksi pool
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void testUtil() {
        try {
            Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }
}
