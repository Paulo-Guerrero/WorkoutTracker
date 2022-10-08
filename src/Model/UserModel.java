package Model;

import Controller.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class UserModel {

    private DbUtil db = new DbUtil();
    public void addLift(LiftModel lift){
        // TODO Error Message
    }

    public String getUsername(int userId) {
        String query = "SELECT username FROM Users WHERE userId = " + userId;

        try {
            ResultSet resultSet = db.executeQuery(query);
            if (resultSet == null){
                return null;
            }
            resultSet.next();
            System.out.println(query);
            return resultSet.getString("username");
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public String getPassword(String username) {
        username = "\'" + username + "\'";
        String query = "SELECT password FROM Users WHERE username = " + username;

        try {
            ResultSet resultSet = db.executeQuery(query);
            if (resultSet == null){
                return null;
            }
            resultSet.next();
            return resultSet.getString("password");
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public int getUserId(String username){
        username = "\'" + username + "\'";
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
}
