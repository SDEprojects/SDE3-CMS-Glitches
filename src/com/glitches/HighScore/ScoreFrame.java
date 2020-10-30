package com.glitches.HighScore;

import com.glitches.models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class ScoreFrame extends JFrame {

    public static void HighScoreFrame() {

        JFrame frame = new JFrame("High Scores" );
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

        JPanel ScoreBox = new JPanel();

        JLabel text = new JLabel();
        text.setText("<html> " + Player.name + "'s Scores: <br><br> Total Score: " + HighScores.getTotalScore() + "<br> Brick Breaker: " + HighScores.getBrickScore() + "<br> Frogger: " + HighScores.getFroggerScore() + "<br> Pacman: " + HighScores.getPacScore() + "<br> Snake: " + HighScores.getSnakeScore() + "<br> Space Invaders: " + HighScores.getSpaceScore());
        text.setFont(new Font("Sans Serif", Font.BOLD, 18));
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        ScoreBox.add(text);
        frame.getContentPane().add(ScoreBox);

        HighScores.HighScore();

    }


}
