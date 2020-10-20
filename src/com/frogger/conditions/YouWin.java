package com.frogger.conditions;

import com.frogger.UI.PlaceholderTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class YouWin extends JPanel implements ActionListener {
    public static PlaceholderTextField usernameTextArea;
    int index;

    public YouWin(boolean showUserInput, int index) {
        this.setOpaque(false);
        this.setVisible(true);
        this.setLayout((LayoutManager) null);
        this.index = index;
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
        g.drawString("You fixed Frogger! A key spawns in front of you, and you take it.", 50, 100);
        addExitButton();
    }

    public void addExitButton() { // Exit out of game.
        String buttonText = "Exit Game";
        JButton exitButton = new JButton(buttonText);
        Font font = new Font("TimesRoman", Font.ITALIC, 15);
        exitButton.setFont(font);
        setLayout(null);
        exitButton.setBounds(270, 200, 150, 100);
        add(exitButton);
        exitButton.addActionListener(e -> {
//            Arrays.asList(Window.getWindows()).forEach(Window::dispose);
            System.exit(0);
        });
    }

    public void actionPerformed(ActionEvent action) {
        String name = usernameTextArea.getText();
    }
}