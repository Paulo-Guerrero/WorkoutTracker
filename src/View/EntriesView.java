package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EntriesView implements ActionListener {
    private JFrame frame;
    private JPanel panel;

    public EntriesView(JFrame frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;
    }

    public void renderView(){}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
