package com.frogger.frames;

import com.glitches.models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class FroggerFrame extends JFrame {

    public FroggerFrame(Player player) {

        super("Frogger");
        InputMap im = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancel");
        am.put("cancel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setResizable(false);
        setSize(FroggerPanel.WIDTH, FroggerPanel.HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);
        pack();
        FroggerPanel panel = new FroggerPanel(player) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        };
        Insets frameInsets = getInsets();
        int frameWidth = panel.getWidth() + (frameInsets.left + frameInsets.right);
        int frameHeight = panel.getHeight() + (frameInsets.top + frameInsets.bottom);
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setLayout(null);
        add(panel);
        pack();
        setVisible(true);
    }
}