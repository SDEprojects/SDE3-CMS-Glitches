package com.snake;

import com.glitches.models.Player;


import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeFrame extends JFrame {

    public SnakeFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        SnakePanel panel = new SnakePanel();
        this.add(panel);
        this.setTitle("Snake*Arcade***");
//        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}