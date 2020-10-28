package com.frogger.frames;

import com.glitches.models.Player;
import com.snake.SnakePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FroggerFrame extends JFrame {

    public FroggerFrame() {

//        super("Frogger");
//        InputMap im = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//        ActionMap am = getRootPane().getActionMap();
//
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancel");
//        am.put("cancel", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        });
//
//        setResizable(false);
//        setSize(FroggerPanel.WIDTH, FroggerPanel.HEIGHT);
//        setLocationRelativeTo(null);
//        setUndecorated(true);
//        pack();
//
//        FroggerPanel panel = new FroggerPanel() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                dispose();
//            }
//        };
//
//        Insets frameInsets = getInsets();
//        int frameWidth = panel.getWidth() + (frameInsets.left + frameInsets.right);
//        int frameHeight = panel.getHeight() + (frameInsets.top + frameInsets.bottom);
//        setPreferredSize(new Dimension(frameWidth, frameHeight));
//        setLayout(null);
//        this.add(panel);
//        pack();
//        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        FroggerPanel panel = new FroggerPanel();
        this.add(panel);
        this.setTitle("Frogger*Arcade***");
//        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}