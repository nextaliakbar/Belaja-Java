package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MetaDataTest {

    @Test
    void testMetaData() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        DatabaseMetaData databaseMetaData =  connection.getMetaData();
        System.out.println(databaseMetaData.getDatabaseProductName());
        System.out.println(databaseMetaData.getDatabaseProductVersion());

        ResultSet resultSet = databaseMetaData.getTables("java_database", null, null, null);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("TABLE_NAME"));
        }
    }

    @Test
    void testParamaterMetaData() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
        System.out.println(parameterMetaData.getParameterCount());
        //System.out.println(parameterMetaData.getParameterType(1)); // Belum  support
        preparedStatement.close();
        connection.close();
    }

    @Test
    void testResultSetMetaData() throws SQLException {
        Connection connection = ConnectionUtilTest.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM sample_time");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.println("Column Name : " + resultSetMetaData.getColumnName(i));
            System.out.println("Column Type : " + resultSetMetaData.getColumnType(i));
            System.out.println("Column Type Name : " + resultSetMetaData.getColumnTypeName(i));
            if(resultSetMetaData.getColumnType(i) == Types.INTEGER) {
                System.out.println("Ini Integer");
            }
        }
        statement.close();
        connection.close();
    }
}
