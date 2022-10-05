package View;

import Controller.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class HomePageView implements ActionListener {
    JFrame frame;
    JPanel panel;
    JButton entryButton;
    UserController user = new UserController();
    private JLabel welcomeHeader;
    public HomePageView(JFrame frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;
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
        this.panel.add(welcomeHeader);
    }

    public void renderHistory(){

    }

    public void renderEntryMenu(){
        this.entryButton = new JButton("Create a new entry");
        this.entryButton.addActionListener(this);
        this.panel.add(entryButton);
    }

    public void renderPersonalBests(){
        HashMap map = this.user.getLatestPersonalBest();
        String lift = map.get("Lift").toString();
        int measurement = (int) map.get("Measurement");

        JLabel pbHeader = new JLabel("Look back at your latest personal best");
        JLabel pbContent = new JLabel(lift + ": " + measurement);
        this.panel.add(pbHeader);
        this.panel.add(pbContent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.entryButton){
            EntriesView entriesView = new EntriesView(this.frame, this.panel);
            entriesView.renderView();
        }
    }
}
