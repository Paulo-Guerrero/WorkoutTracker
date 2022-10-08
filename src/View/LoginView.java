package View;

import Controller.Controllers;
import Controller.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends PageView implements ActionListener {
    JTextField username = new JTextField(10);
    JPasswordField password = new JPasswordField(10);
    JButton login = new JButton("Log In");
    JLabel loginError = new JLabel("Incorrect username or password");
    private UserController user = this.controllers.userController;

    public LoginView(JFrame frame, JPanel panel, Controllers controllers) {
        super(frame, panel, controllers);
    }


    public void renderView(){
        this.panel.removeAll();
        loginError.setVisible(false);
        login.addActionListener(this);
        this.panel.add(username);
        this.panel.add(password);
        this.panel.add(login);
        this.panel.add(loginError);

        panel.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usernameText = username.getText();
        String passwordText = String.valueOf(password.getPassword());
        if (user.login(usernameText, passwordText)){
            HomePageView homePageView = new HomePageView(this.frame, this.panel, this.controllers);
            homePageView.renderView();
        }else{
            this.loginError.setVisible(true);
            panel.revalidate();
        }
    }
}
