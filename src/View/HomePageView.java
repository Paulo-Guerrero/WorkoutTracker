package View;

import javax.swing.*;

public class HomePageView {
    JFrame frame;
    JPanel panel;

    public HomePageView(JFrame frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;
    }
    public void renderView(){
        this.panel.removeAll();
        panel.revalidate();
    }
}
