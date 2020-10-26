package com.glitches.TicketCounter;

import javax.swing.*;
import java.awt.*;

public class TicketPanel extends JPanel {

    public TicketPanel() {
        initializeCounterLayout();
    }

    public void initializeCounterLayout() {

        ImageIcon prize1 = new ImageIcon("src/com/glitches/TicketCounter/prizes/fingerTrap.jpg");

        JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
       // JPanel subPanel1 = new JPanel();

        setFocusable(true);
        setPreferredSize(new Dimension(900, 750));


        //label1 = new JLabel("fingertrap", prize1, SwingConstants.LEFT);


    }

}
