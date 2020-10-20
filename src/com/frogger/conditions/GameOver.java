package com.frogger.conditions;

import com.frogger.frames.FroggerFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GameOver extends JPanel {
    int index;

    public GameOver(int index) {
        this.setOpaque(false);
        this.setVisible(true);
        this.setLayout((LayoutManager) null);
        this.index = index;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        Composite old = g2d.getComposite();
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.5F));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setComposite(old);
        g.setColor(Color.green);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 35));
        g.drawString("You died. Try again?", 200, 150);
        addRestartButton();
    }

    public void addRestartButton() { // New game button. Will close out old game.
        String buttonText = "New Game";
        JButton restartButton = new JButton(buttonText);
        Font font = new Font("TimesRoman", Font.ITALIC, 15);
        restartButton.setFont(font);
        setLayout(null);
        restartButton.setBounds(270, 200, 150, 100);
        add(restartButton);
        restartButton.addActionListener(e -> {
            Arrays.asList(Window.getWindows()).forEach(Window::dispose);
            new FroggerFrame();
        });
    }
}