package Controller;

import java.sql.*;

public class DbUtil {
    private String username = "admin";
    private String password = "password123";
    private String endpoint = "workouttracker.cvi29upq4yqe.us-east-1.rds.amazonaws.com/demo";
    private String connectionAddress = "jdbc:mysql://" + endpoint;

    public ResultSet executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(connectionAddress, username, password);
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }

    }
}
