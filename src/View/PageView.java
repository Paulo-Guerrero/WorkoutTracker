package View;

import Controller.Controllers;

import javax.swing.*;

public abstract class PageView {
    protected JFrame frame;
    protected JPanel panel;
    protected Controllers controllers;

    public PageView(JFrame frame, JPanel panel, Controllers controllers){
        this.frame = frame;
        this.panel = panel;
        this.controllers = controllers;
    }

    abstract void renderView();
}
