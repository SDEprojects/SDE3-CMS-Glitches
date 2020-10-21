package com.snake;

import com.glitches.models.Player;

import javax.swing.*;
import java.awt.*;

public class SnakeMiniGame {

    public static void main(Player player) {
        new SnakeFrame(player); // Starts the game.

//        frame.setSize(700, 700);
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
//
//        frame.setResizable(false);
//        frame.setTitle("Starship");
//        frame.setVisible(true);
//
//        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}