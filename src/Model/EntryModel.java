package Model;

import Controller.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

    public int addBlankEntry(int userId){
        String currDate = LocalDate.now().toString();
        currDate = formatSQLString(currDate);
        String query = "INSERT INTO Entries(creationDate, userId) VALUES(" + currDate + "," + userId + ")";
        return db.executeUpdate(query);
    }

    public String formatSQLString(String sqlString){
        return "\'" + sqlString + "\'";
    }
}
