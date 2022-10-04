package Controller;

import Model.UserModel;

public class UserController {
    public UserModel user = new UserModel();
    public boolean login(String username, String password){
        if (user.verifyLogin(username, password)){
            return true;
        }
        return false;
    }
}
