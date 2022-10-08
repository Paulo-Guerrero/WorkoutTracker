package Model;

import Controller.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class UserModel {
    private DbUtil db = new DbUtil();

    public int addUser(String username, String password){
        username = formatSQLString(username);
        password = formatSQLString(password);
        String query = "INSERT INTO Users VALUES(NULL, " + username + "," + password + ")";
        return db.executeUpdate(query);
    }

    public String getUsername(int userId) {
        String query = "SELECT username FROM Users WHERE userId = " + userId;

        try {
            ResultSet resultSet = db.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getString("username");
            }
            return null;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public String getPassword(String username) {
        username = formatSQLString(username);
        String query = "SELECT password FROM Users WHERE username = " + username;

        try {
            ResultSet resultSet = db.executeQuery(query);
            if (resultSet.next()){
                return resultSet.getString("password");
            }
            return null;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public int getUserId(String username){
        username = formatSQLString(username);
        String query = "SELECT userId FROM Users WHERE username = " + username;
        try {
            ResultSet resultSet = db.executeQuery(query);
            resultSet.next();
            return resultSet.getInt("userId");
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }

    public String formatSQLString(String sqlString){
        return "\'" + sqlString + "\'";
    }
}
