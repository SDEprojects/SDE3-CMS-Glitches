package com.pacman;

import java.awt.*;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.BLACK);
        panel.setVisible(true);
        this.add(panel);

        addKeyListener(new KeyChecker(panel));
    }
}
