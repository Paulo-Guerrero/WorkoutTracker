package Model;

import Controller.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.time.LocalDate;

public class LiftModel {
    protected double measure;
    protected double personalBest;
    protected HashMap history;

    private DbUtil db = new DbUtil();

    public void addRecord(double measure){
        history.put(LocalDate.now(), measure);
        this.personalBest = Math.max(personalBest, measure);
    }

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

    public HashMap getHistory(){
        return this.history;
    }

    public double getPersonalBest(){
        return this.personalBest;
    }

    public String formatSQLString(String sqlString){
        return "\'" + sqlString + "\'";
    }
}
