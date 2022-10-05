package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView extends PageView implements ActionListener {
    public SignUpView(JFrame frame, JPanel panel) {
        super(frame, panel);
    }

    public void renderView(){
        this.panel.removeAll();

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
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
