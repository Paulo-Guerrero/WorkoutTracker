package Controller;

import Model.UserModel;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class UserController {
    private UserModel user = new UserModel();
    private int currentUserId;
    public boolean login(String username, String password){
        if (user.getPassword(username).equals(password)){
            this.currentUserId = user.getUserId(username);
            return true;
        }
        return false;
    }

    public boolean signUp(String username, String password){
        if (user.addUser(username, password) == 1){
            this.currentUserId = user.getUserId(username);
            return true;
        }
        return false;
    }
    public String getUsername(){
        return user.getUsername(this.currentUserId);
    }

    public HashMap<String, Object> getLatestPersonalBest(){
        HashMap map = new HashMap<>();
        map.put("Lift", "Bench Press");
        map.put("Measurement", 225);
        return map;
    }
}
