package com.glitches.TicketCounter;

import com.snake.SnakePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GetPrizeFrame extends JFrame{

    public GetPrizeFrame(){
        GetPrizePanel panel = new GetPrizePanel(new BorderLayout());
        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.BLACK);
        panel.setVisible(true);
        this.add(panel);
    }
}
