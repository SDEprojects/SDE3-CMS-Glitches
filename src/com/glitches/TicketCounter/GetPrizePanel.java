package com.glitches.TicketCounter;

import com.glitches.models.Player;
import com.pacman.Ghost;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GetPrizePanel extends javax.swing.JPanel implements ActionListener {


    public GetPrizePanel(BorderLayout borderLayout){
        JLabel text = new JLabel();
        if(GetPrize.purchased){
            text.setText("<html>You purchased a " + GetPrize.prize +".\n You have " + Player.tickets + " remaining.</html>");
        } else {
            text.setText("You do not have enough tickets to trade for that item.");
        }
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setForeground(Color.green);
        text.setFont(new Font("TimesRoman", Font.BOLD, 18));
        //adding JLabel to JPanel
        this.add(text);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
