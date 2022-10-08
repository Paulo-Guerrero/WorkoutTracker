package Controller;

import Model.LiftModel;

public class LiftController {
    private String[] lifts = {"Squat", "Deadlift", "Bench Press"};
    private LiftModel lift = new LiftModel();
    public LiftController(Controllers controllers){};

    public void saveLift(String lift, int reps, int measurement, String entryDate){
        this.lift.saveEntry(lift, reps, measurement, entryDate);
    }

    public String[] getLifts(){
        return this.lifts;
    }
}
