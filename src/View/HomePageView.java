package View;

import Controller.Controllers;
import Controller.LiftController;
import Controller.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class HomePageView extends PageView implements ActionListener {
    JButton entryButton;
    JButton logoutButton;
    UserController user = this.controllers.userController;
    LiftController liftController = this.controllers.liftController;
    private JLabel welcomeHeader;

    public HomePageView(JFrame frame, JPanel panel, Controllers controllers) {
        super(frame, panel, controllers);
    }

    public void renderView(){
        this.panel.removeAll();

        this.renderHeader();
        this.renderHistory();
        this.renderEntryMenu();
        this.renderPersonalBests();
        this.panel.revalidate();
    }

    public void renderHeader(){
        String username = user.getUsername();
        welcomeHeader = new JLabel("Welcome to your workouts, " + username);
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(this);
        this.panel.add(welcomeHeader);
        this.panel.add(logoutButton);
    }

    public void renderHistory(){
        this.panel.add(new HistoryGraph(controllers));
        this.panel.revalidate();
    }

    public void renderEntryMenu(){
        this.entryButton = new JButton("Create a new entry");
        this.entryButton.addActionListener(this);
        this.panel.add(entryButton);
    }

    public void renderPersonalBests(){
        HashMap map = this.liftController.getLatestPersonalBest();
        JLabel pbContent = new JLabel("You currently have no records");
        if (map.size() > 0) {
            String lift = map.get("Lift").toString();
            int measurement = (int) map.get("Measurement");
            pbContent = new JLabel(lift + ": " + measurement);
        }
        JLabel pbHeader = new JLabel("Look back at your latest personal best");

        this.panel.add(pbHeader);
        this.panel.add(pbContent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.entryButton){
            controllers.entryController.addBlankEntry();
            EntriesView entriesView = new EntriesView(this.frame, this.panel, this.controllers);
            entriesView.renderView();
        } else if (e.getSource() == this.logoutButton) {
            user.logout();
            LoginView loginView = new LoginView(this.frame, this.panel, this.controllers);
            loginView.renderView();
        }
    }
}
