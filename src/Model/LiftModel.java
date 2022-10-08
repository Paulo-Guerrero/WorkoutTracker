package Model;

import Controller.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LiftModel {
    private DbUtil db = new DbUtil();

    public void saveEntry(String lift, int reps, int measurement, String entryDate){
        lift = formatSQLString(lift);
        entryDate = formatSQLString(entryDate);
        String liftIdQuery = "SELECT liftId FROM Lifts WHERE longName = " + lift;
        String entryIdQuery = "SELECT entryId FROM Entries WHERE creationDate = " + entryDate;

        try {
            System.out.println(liftIdQuery);
            ResultSet liftResult = db.executeQuery(liftIdQuery);
            liftResult.next();
            int liftId = liftResult.getInt("liftId");

            System.out.println(entryIdQuery);
            ResultSet entryResult = db.executeQuery(entryIdQuery);
            entryResult.next();
            int entryId = entryResult.getInt("entryId");

            String saveQuery = "INSERT INTO UserLifts(liftId, entryId, measurement, reps) VALUES(" +
                    liftId + "," + entryId + "," + measurement + "," + reps + ")";
            db.executeUpdate(saveQuery);
        }catch(SQLException e){
            System.out.print(e);
        }
    }

    public HashMap<String, Object> getPersonalBest(int userId){
        String query = "SELECT UserLifts.measurement, Lifts.longName FROM UserLifts \n" +
                "LEFT JOIN Entries ON UserLifts.entryId = Entries.entryId\n" +
                "LEFT JOIN Lifts ON UserLifts.liftId = Lifts.LiftId\n" +
                "WHERE userId = " + userId + "\n" +
                "ORDER BY measurement ASC\n" +
                "LIMIT 1";
        HashMap<String, Object> pbMap = new HashMap<>();
        try {
            ResultSet resultSet = db.executeQuery(query);
            if (resultSet.next()) {
                String liftName = resultSet.getString("longName");
                int measurement = resultSet.getInt("measurement");
                pbMap.put("Lift", liftName);
                pbMap.put("Measurement", measurement);
            }
            return pbMap;
        }catch(SQLException e){
            System.out.println(e);
            return pbMap;
        }
    }

    public String[] getLifts(){
        String query = "SELECT * FROM Lifts";
        ArrayList<String> liftsRslt = new ArrayList();

        try {
            ResultSet resultSet = db.executeQuery(query);
            while (resultSet.next()){
                String liftName = resultSet.getString("longName");
                liftsRslt.add(liftName);
            }
            return liftsRslt.toArray(new String[0]);
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public String formatSQLString(String sqlString){
        return "\'" + sqlString + "\'";
    }
}
