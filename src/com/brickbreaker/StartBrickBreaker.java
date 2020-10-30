package com.brickbreaker;
import javax.swing.*;

import com.glitches.models.Player;

public class StartBrickBreaker {
    public static void main() {
        JFrame obj = new JFrame();
        BrickPanel gamePlay = new BrickPanel();

        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Brick Breaker");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        obj.add(gamePlay);
        //pass in tickets
    }
}
