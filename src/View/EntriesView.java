package View;

import Controller.LiftController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.*;

public class EntriesView extends PageView implements ActionListener {
    private JButton addRecord = new JButton("Add Record");
    private JLabel dateHeader = new JLabel(LocalDate.now().toString());
    private JButton homeButton = new JButton("Home");
    private LiftController liftController = new LiftController();

    public EntriesView(JFrame frame, JPanel panel) {
        super(frame, panel);
    }

    public void renderView(){
        this.panel.removeAll();
        this.panel.add(homeButton);
        this.panel.add(dateHeader);
        this.panel.add(addRecord);
        addRecord.addActionListener(this);
        homeButton.addActionListener(this);
        this.panel.revalidate();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addRecord){
            this.panel.add(new JComboBox(liftController.getLifts()));
            this.panel.add(new JTextField());
            this.panel.revalidate();
        } else if (e.getSource() == homeButton){
            HomePageView homePageView = new HomePageView(this.frame, this.panel);
            homePageView.renderView();
        }
    }
}
