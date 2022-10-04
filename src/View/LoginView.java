package View;

import javax.swing.*;

public class LoginView {
    private JFrame frame;
    private JPanel panel;

    public LoginView(JFrame frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;
    }

    public void renderView(){
        this.panel.removeAll();

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JButton login = new JButton("Log In");

        this.panel.add(username);
        this.panel.add(password);
        this.panel.add(login);

        panel.revalidate();
    }
}
