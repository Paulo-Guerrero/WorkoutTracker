package View;

import Controller.Controllers;
import Controller.EntryController;
import Controller.LiftController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.*;

public class EntriesView extends PageView implements ActionListener {
    private JButton addRecord = new JButton("Add Record");
    private JLabel dateHeader = new JLabel(LocalDate.now().toString());
    private JButton homeButton = new JButton("Home");
    private JButton saveButton = new JButton("Save Entry");
    private LiftController lift = this.controllers.liftController;

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


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addRecord){
            this.panel.add(new JComboBox(lift.getLifts()));
            this.panel.add(new JTextField(2));
            this.panel.add(new JTextField(10));
            this.panel.revalidate();
        } else if (e.getSource() == homeButton){
            HomePageView homePageView = new HomePageView(this.frame, this.panel, this.controllers);
            homePageView.renderView();
        }else if (e.getSource() == saveButton){
            EntryController entryController = new EntryController();
            entryController.saveEntry();
        }
    }
}
