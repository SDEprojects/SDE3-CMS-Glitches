package com.brickbreaker;
import javax.swing.JFrame;
import com.glitches.models.Player;

public class StartBrickBreaker {
    public static void main() {
        JFrame obj = new JFrame();
        BrickPanel gamePlay = new BrickPanel();

        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Brick Breaker");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        obj.add(gamePlay);
    }
}
