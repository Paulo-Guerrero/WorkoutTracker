package View;

import Controller.Controllers;
import Controller.EntryController;
import Controller.LiftController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;

public class EntriesView extends PageView implements ActionListener {
    private LiftController liftController = this.controllers.liftController;
    private EntryController entryController = this.controllers.entryController;
    private JButton addRecord = new JButton("Add Record");
    private JComboBox dateHeader = new JComboBox(entryController.getEntryDates());
    private JButton homeButton = new JButton("Home");
    private JButton saveButton = new JButton("Save Entry");
    private ArrayList<EntryPanel> entryComponents = new ArrayList();

    public EntriesView(JFrame frame, JPanel panel, Controllers controllers) {
        super(frame, panel, controllers);
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
        this.panel.revalidate();
    }

    public void renderLifts(){
//        this.panel.add(new JComboBox(lift.getLifts()));
//        this.panel.add(new JTextField(2));
//        this.panel.add(new JTextField(10));
    }

    public void addLiftPanel(){
        EntryPanel entryPanel = new EntryPanel(this.controllers);
        entryComponents.add(entryPanel);
        this.panel.add(entryPanel, BorderLayout.SOUTH);
        this.panel.revalidate();
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
        }
    }
}
