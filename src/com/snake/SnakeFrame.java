package com.snake;

import com.glitches.models.Player;

import javax.swing.*;

public class SnakeFrame extends JFrame {

    public SnakeFrame(Player player) {
        SnakePanel panel = new SnakePanel(player);
        this.add(panel);
        this.setTitle("Snake*Arcade***");
//        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}