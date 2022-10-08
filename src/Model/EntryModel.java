package Model;

import Controller.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntryModel {
    private DbUtil db = new DbUtil();

    public Object[] getUserEntryDates(int userId){
        String query = "SELECT creationDate FROM Entries WHERE userId = " + userId;
        try {
            ArrayList<String> results = new ArrayList<>();
            ResultSet resultSet = db.executeQuery(query);
            while (resultSet.next()){
                results.add(resultSet.getString("creationDate"));
            }
            return results.toArray();
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public void addBlankEntry(int userId){
        String query = "INSERT INTO Entries(userId) VALUES(" + userId + ")";
        db.executeUpdate(query);
    }

    public String formatSQLString(String sqlString){
        return "\'" + sqlString + "\'";
    }
}
