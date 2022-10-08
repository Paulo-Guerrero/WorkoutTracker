package Controller;

import Model.LiftModel;

import java.util.ArrayList;
import java.util.HashMap;

public class LiftController {
    private Controllers controllers;
    private LiftModel lift = new LiftModel();
    private UserController userController;
    public LiftController(Controllers controllers){
        this.controllers = controllers;
        this.userController = controllers.userController;
    };

    public void saveLift(String lift, int reps, int measurement, String entryDate){
        this.lift.saveEntry(lift, reps, measurement, entryDate);
    }

    public HashMap<String, Object> getLatestPersonalBest(){
        int userId = userController.getCurrentUserId();
        return lift.getPersonalBest(userId);
    }

    public String[] getLifts(){
        return lift.getLifts();
    }

    public ArrayList<HashMap<String, Object>> getUserLifts(String currDate){
        int userId = userController.getCurrentUserId();
        return lift.getUserLifts(userId, currDate);
    }
}
