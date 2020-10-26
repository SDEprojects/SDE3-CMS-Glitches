package com.pacman;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.io.IOException;

public class Pacman {
    public static void main() {
        MainFrame frame = new MainFrame();

        frame.setSize(700, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2),
                (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));

        frame.setResizable(false);
        frame.setTitle("PacMan");
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
