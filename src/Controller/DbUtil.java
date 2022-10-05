package Controller;

import java.sql.*;

public class DbUtil {
    private String username = "admin";
    private String password = "password123";
    private String databaseName = "";
    private String connectionAddress = "";

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(connectionAddress, username, password);
        Statement statement = connection.createStatement();
        connection.close();
        return statement.executeQuery(query);
    }
}
