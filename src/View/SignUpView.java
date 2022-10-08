package View;

import Controller.Controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView extends PageView implements ActionListener {
    public SignUpView(JFrame frame, JPanel panel, Controllers controllers) {
        super(frame, panel, controllers);
    }

    public void renderView(){
        this.panel.removeAll();

        JTextField username = new JTextField(10);
        JPasswordField password = new JPasswordField(10);
        JButton signUp = new JButton("Sign Up");
        signUp.addActionListener(this);
        this.panel.add(username);
        this.panel.add(password);
        this.panel.add(signUp);

        panel.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
