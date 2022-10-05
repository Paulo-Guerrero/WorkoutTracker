package View;

import javax.swing.*;

public abstract class PageView {
    protected JFrame frame;
    protected JPanel panel;

    public PageView(JFrame frame, JPanel panel){
        this.frame = frame;
        this.panel = panel;
    }

    abstract void renderView();
}
