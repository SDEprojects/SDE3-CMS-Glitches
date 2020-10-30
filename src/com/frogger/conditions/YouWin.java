package com.frogger.conditions;

import com.frogger.UI.PlaceholderTextField;
import com.frogger.frames.FroggerFrame;
import com.frogger.frames.FroggerPanel;
import com.glitches.models.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class YouWin extends JPanel implements ActionListener {
    public static PlaceholderTextField usernameTextArea;
    int index;
    int score;


    public YouWin(boolean showUserInput, int index, int score) {
        this.setOpaque(true);
        this.setVisible(true);
        this.setLayout((LayoutManager) null);
        this.index = index;
        this.score = score;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        Composite old = g2d.getComposite();
        g2d.setColor(Color.black);
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.5F));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setComposite(old);
        g.setColor(Color.green);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        g.drawString("Please collect your " + score + " tickets and play another game!.", 50, 100);
        addExitButton();
    }

    public void addExitButton() { // Exit out of game.
        JButton exitButton = new JButton("Back to Arcade");
        Font font = new Font("TimesRoman", Font.ITALIC, 15);
        exitButton.setFont(font);
        setLayout(null);
        exitButton.setBounds(270, 200, 150, 100);
        add(exitButton);
        exitButton.addActionListener(e -> {
            getTopLevelAncestor().setVisible(false);

        });
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}