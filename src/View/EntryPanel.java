package View;

import Controller.Controllers;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class EntryPanel extends JPanel {
    JComboBox lift;
    JTextField reps;
    JTextField measurement;
    Controllers controllers;

    public EntryPanel(String lift, int reps, int measurement, Controllers controllers){
        this.controllers = controllers;
        this.lift = new JComboBox(controllers.liftController.getLifts());
        this.reps = new JTextField(String.valueOf(reps), 2);
        this.measurement = new JTextField(String.valueOf(measurement), 10);
        this.add(this.lift);
        this.add(this.reps);
        this.add(this.measurement);
    }

    public EntryPanel(Controllers controllers){
        this.controllers = controllers;
        this.lift = new JComboBox(controllers.liftController.getLifts());
        this.reps = new JTextField(2);
        this.measurement = new JTextField(10);
        this.add(this.lift);
        this.add(this.reps);
        this.add(this.measurement);
    }

    public String getLift(){return this.lift.getSelectedItem().toString();}

    public int getReps(){
        if (Objects.equals(this.reps.getText(), "")){
            return -1;
        }
        return Integer.parseInt(this.reps.getText());}

    public int getMeasurement(){
        if (Objects.equals(this.measurement.getText(), ""))
        {
            return -1;
        }
        return Integer.parseInt(this.measurement.getText());}
}
