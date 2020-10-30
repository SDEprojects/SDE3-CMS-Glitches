package com.glitches.TicketCounter;

import com.snake.SnakePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GetPrizeFrame extends JFrame{

    public GetPrizeFrame(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        GetPrizePanel panel = new GetPrizePanel();
//        this.add(panel);
        // making a new JFrame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.setSize(1000, 975);
        this.setSize(500, 505);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
    }
}
