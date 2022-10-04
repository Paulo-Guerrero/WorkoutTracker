package View;

import javax.swing.*;

public class SignUpView {
    private JFrame frame;
    private JPanel panel;

    public SignUpView(JFrame frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;
    }

    public void renderView(){
        this.panel.removeAll();

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JButton signUp = new JButton("Sign Up");

        this.panel.add(username);
        this.panel.add(password);
        this.panel.add(signUp);

        panel.revalidate();
    }
}
