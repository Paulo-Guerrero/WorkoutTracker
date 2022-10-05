package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUpView implements ActionListener {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JButton signupButton = new JButton("Sign Up");
    private JButton loginButton = new JButton("Log In");
    
    public void renderView(){
        loginButton.addActionListener(this);
        signupButton.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(loginButton);
        panel.add(signupButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1000, 700);
        frame.setVisible(true);
        frame.setTitle("Workout Tracker v0.01");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            SignUpView signUpView = new SignUpView(this.frame, this.panel);
            signUpView.renderView();
        } else if (e.getSource() == loginButton) {
            LoginView loginView = new LoginView(this.frame, this.panel);
            loginView.renderView();
        }
    }
}
