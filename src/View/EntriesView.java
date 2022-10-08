package View;

import Controller.Controllers;
import Controller.EntryController;
import Controller.LiftController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class EntriesView extends PageView implements ActionListener {
    private LiftController liftController = this.controllers.liftController;
    private EntryController entryController = this.controllers.entryController;
    private JButton addRecord = new JButton("Add Record");
    private JComboBox dateHeader = new JComboBox(entryController.getEntryDates());
    private JButton homeButton = new JButton("Home");
    private JButton saveButton = new JButton("Save Entry");
    private ArrayList<EntryPanel> entryComponents = new ArrayList();
    private boolean newEntry;
    public EntriesView(JFrame frame, JPanel panel, Controllers controllers) {

        super(frame, panel, controllers);
        int rowsInserted = controllers.entryController.addBlankEntry();
        this.newEntry = rowsInserted == 0;
    }

    public void renderView(){
        this.panel.removeAll();
        this.panel.add(homeButton);
        this.panel.add(dateHeader);
        this.panel.add(new JLabel("Movement"));
        this.panel.add(new JLabel("Reps"));
        this.panel.add(new JLabel("Value"));
        this.panel.add(addRecord);
        this.panel.add(saveButton);
        addRecord.addActionListener(this);
        homeButton.addActionListener(this);
        saveButton.addActionListener(this);
        dateHeader.addActionListener(this);

        if (!this.newEntry){
            renderLifts(LocalDate.now().toString());
        }
        this.panel.revalidate();
    }

    public void renderLifts(String currDate){
        ArrayList<HashMap<String, Object>> userLifts = liftController.getUserLifts(currDate);
        for (Component component : entryComponents){
            this.panel.remove(component);
        }
        entryComponents.clear();
        for (HashMap<String, Object> userLift : userLifts){
            String lift = (String) userLift.get("Lift");
            int reps = (int) userLift.get("Reps");
            int measurement = (int) userLift.get("Measurement");
            addLiftPanel(lift, reps, measurement);
        }
        this.panel.revalidate();
    }

    public void addLiftPanel(){
        EntryPanel entryPanel = new EntryPanel(this.controllers);
        entryComponents.add(entryPanel);
        this.panel.add(entryPanel, BorderLayout.SOUTH);
        this.panel.revalidate();
    }

    public void addLiftPanel(String lift, int reps, int measurement){
        EntryPanel entryPanel = new EntryPanel(lift, reps, measurement, this.controllers);
        entryComponents.add(entryPanel);
        this.panel.add(entryPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addRecord){
            this.addLiftPanel();
        } else if (e.getSource() == homeButton){
            HomePageView homePageView = new HomePageView(this.frame, this.panel, this.controllers);
            homePageView.renderView();
        }else if (e.getSource() == saveButton){
            for (EntryPanel panel : entryComponents){
                String lift = panel.getLift();
                int reps = panel.getReps();
                int measurement = panel.getMeasurement();
                if (reps != -1 && measurement != -1) {
                    liftController.saveLift(lift, reps, measurement, dateHeader.getSelectedItem().toString());
                }
            }
        }else if (e.getSource() == dateHeader){
            String currDate = dateHeader.getSelectedItem().toString();
            renderLifts(currDate);
        }
    }
}
