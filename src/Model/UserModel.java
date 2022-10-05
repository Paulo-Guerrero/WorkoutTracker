package Model;

import java.util.HashMap;
import java.util.List;

public class UserModel {

    private String username;
    private String password;
    private List<EntryModel> entries;
    private HashMap<String, LiftModel> lifts;
    private int userId;
    public void addLift(LiftModel lift){
        if (!lifts.containsKey(lift.getName())){
            this.lifts.put(lift.getName(), lift);
        }
        // TODO Error Message
    }

    public boolean verifyLogin(String username, String password){
        return true;
    }

    public String getUsername(int userId){
        return "Paulo";
    }
    public String getPassword(int userId){
        return this.password;
    }

    public List<EntryModel> getEntries(int userId){
        return this.entries;
    }

    public HashMap<String, LiftModel> getLifts(){
        return this.lifts;
    }

    public int getUserId(String username){return this.userId;}
}
