package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUpView implements ActionListener {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    public void renderView(){
        JButton loginButton = new JButton("Log In");
        loginButton.addActionListener(this);
        JButton signupButton = new JButton("Sign Up");
        signupButton.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(loginButton);
        panel.add(signupButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Workout Tracker v0.01");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SignUpView signUpView = new SignUpView(this.frame, this.panel);
        signUpView.renderView();
    }
}
