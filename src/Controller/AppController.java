package Controller;

import View.StartUpView;

public class AppController {
    public void start(){
        StartUpView startUpView = new StartUpView();
        startUpView.renderView();
    }
}
