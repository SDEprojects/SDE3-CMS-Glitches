package com.frogger.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class FroggerFrame extends JFrame {

    public FroggerFrame() {

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
        FroggerPanel p = new FroggerPanel();
        Insets frameInsets = getInsets();
        int frameWidth = p.getWidth() + (frameInsets.left + frameInsets.right);
        int frameHeight = p.getHeight() + (frameInsets.top + frameInsets.bottom);
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setLayout(null);
        add(p);
        pack();
        setVisible(true);
    }
}