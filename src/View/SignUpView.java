package View;

import Controller.Controllers;
import Controller.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView extends PageView implements ActionListener {
    UserController user = controllers.userController;
    JTextField username = new JTextField(10);
    JPasswordField password = new JPasswordField(10);
    JLabel signUpFailed = new JLabel("That username is already taken.");
    JButton signUp = new JButton("Sign Up");
    public SignUpView(JFrame frame, JPanel panel, Controllers controllers) {
        super(frame, panel, controllers);
    }

    public void renderView(){
        this.panel.removeAll();
        signUpFailed.setVisible(false);
        signUp.addActionListener(this);
        this.panel.add(username);
        this.panel.add(password);
        this.panel.add(signUp);
        this.panel.add(signUpFailed);

        panel.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUp){
            Boolean succesfulSignup = user.signUp(username.getText(), String.valueOf(password.getPassword()));
            if(succesfulSignup){
                HomePageView homePageView = new HomePageView(this.frame, this.panel, this.controllers);
                homePageView.renderView();
            }else{
                signUpFailed.setVisible(true);
                panel.revalidate();
            }
        }
    }
}
