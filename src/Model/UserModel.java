package Model;

import java.util.HashMap;
import java.util.List;

public class UserModel {

    private String username;
    private String password;
    private List<EntryModel> entries;
    private HashMap<String, LiftModel> lifts;

    public void addLift(LiftModel lift){
        if (!lifts.containsKey(lift.getName())){
            this.lifts.put(lift.getName(), lift);
        }
        // TODO Error Message
    }

    public boolean verifyLogin(String username, String password){
        return true;
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    public List<EntryModel> getEntries(){
        return this.entries;
    }

    public HashMap<String, LiftModel> getLifts(){
        return this.lifts;
    }
}
