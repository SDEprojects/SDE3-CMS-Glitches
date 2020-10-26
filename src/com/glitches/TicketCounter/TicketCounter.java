package com.glitches.TicketCounter;

import com.glitches.models.Player;

import javax.swing.*;
import java.awt.*;

public class TicketCounter extends JFrame {

    public static final String FINGERTRAP_IMAGE = "src/com/glitches/TicketCounter/prizes/fingerTrap.jpg";
    public static final String STICKY_FINGER_IMAGE= "src/com/glitches/TicketCounter/prizes/stickyHand.jpg";
    public static final String RECORDER_IMAGE = "src/com/glitches/TicketCounter/prizes/recorder.jpg";
    public static final String BOUNCE_BALL_IMAGE = "src/com/glitches/TicketCounter/prizes/superBounceBall.jpg";
    public static final String POKEMON_CARDS_IMAGE = "src/com/glitches/TicketCounter/prizes/pokemonCards.jpg";
    public static final String DRONE_IMAGE = "src/com/glitches/TicketCounter/prizes/drone.jpg";
    public static final String GOPRO_IMAGE = "src/com/glitches/TicketCounter/prizes/goPro.jpg";
    public static final String PS5_BUNDLE_IMAGE = "src/com/glitches/TicketCounter/prizes/PS5Bundle.jpg";
    public static final String XBOX_BUNDLE_IMAGE = "src/com/glitches/TicketCounter/prizes/XboxBundle.jpg";

    public int tickets = Player.getTickets();

    public void TicketCounter() {
        initializeTicketCounter();
        System.out.println("init 1");
    }

    public void initializeTicketCounter() {
        System.out.println("initializing");
        //add(new TicketPanel());
        //setTitle("Ticket Counter");
        //pack();

        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setLocationRelativeTo(null);
        //setResizable(false);
        //setVisible(true);
        ImageIcon prize1 = new ImageIcon("src/com/glitches/TicketCounter/prizes/fingerTrap.jpg");

        JFrame frame = new JFrame("Ticket Counter");

        JButton p1 = new JButton("finger trap");
        JButton p2 = new JButton("finger trap");
        JButton p3 = new JButton("finger trap");
        JButton p4 = new JButton("finger trap");
        JButton p5 = new JButton("finger trap");
        JButton p6 = new JButton("finger trap");
        JButton p7 = new JButton("finger trap");
        JButton p8 = new JButton("finger trap");
        JButton p9 = new JButton("finger trap");

        //3 rows, 3 columns, horizontal gap, vertical gap
        JPanel TicketPanel = new JPanel(new GridLayout(3, 3, 20, 20));

        TicketPanel.add(p1);
        TicketPanel.add(p2);
        TicketPanel.add(p3);
        TicketPanel.add(p4);
        TicketPanel.add(p5);
        TicketPanel.add(p6);
        TicketPanel.add(p7);
        TicketPanel.add(p8);
        TicketPanel.add(p9);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(900, 750);
        frame.getContentPane().add(TicketPanel);
        frame.setVisible(true);
        System.out.println("end of initialization");







    }

}
