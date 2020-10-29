package com.glitches.TicketCounter;


import com.glitches.models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GetPrize {

//    public static int tickets = Player.tickets;
    public static ArrayList<String> showPrize = new ArrayList<>();
    public static PrizeHandler prizeHandler = new PrizeHandler();

    // images
    public static ImageIcon fingertrap = new ImageIcon("src/com/glitches/TicketCounter/prizes/fingerTrap.jpg");
    public static ImageIcon stickyhand = new ImageIcon("src/com/glitches/TicketCounter/prizes/stickyHand.jpg");
    public static ImageIcon recorder = new ImageIcon("src/com/glitches/TicketCounter/prizes/recorder.jpg");
    public static ImageIcon bounceball = new ImageIcon("src/com/glitches/TicketCounter/prizes/superBounceBall.jpg");
    public static ImageIcon pokemonCards = new ImageIcon("src/com/glitches/TicketCounter/prizes/pokemonCards.jpg");
    public static ImageIcon drone = new ImageIcon("src/com/glitches/TicketCounter/prizes/drone.jpg");
    public static ImageIcon gopro = new ImageIcon("src/com/glitches/TicketCounter/prizes/goPro.jpg");
    public static ImageIcon ps5 = new ImageIcon("src/com/glitches/TicketCounter/prizes/PS5Bundle.jpg");
    public static ImageIcon xbox = new ImageIcon("src/com/glitches/TicketCounter/prizes/XboxBundle.jpg");

    public static void main() {
        // making a new JFrame
        JFrame frame = new JFrame("Ticket Counter");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 675);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);

        //making 1 JPanel with BorderLayout for Text
        JPanel TextBox = new JPanel(new BorderLayout());

        //making the JLabel inside of the first JPanel
        JLabel text = new JLabel();
        //using <html> tags allows text to wrap
        text.setText("<html>You have " + Player.tickets + " remaining.");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("TimesRoman", Font.BOLD, 20));
        //adding JLabel to JPanel
        TextBox.add(text);

        JPanel TextBox1 = new JPanel(new BorderLayout());

        //making the JLabel inside of the first JPanel
        JLabel list = new JLabel();
        //using <html> tags allows text to wrap
        list.setText("<html>Prizes selected: " + showPrize + ".</html>");
        list.setHorizontalAlignment(SwingConstants.CENTER);
        list.setVerticalAlignment(SwingConstants.CENTER);
        list.setFont(new Font("TimesRoman", Font.BOLD, 20));
        //adding JLabel to JPanel
        TextBox1.add(list);

        //adding buttons  with mouse Listener  for 2nd JPanel
        JButton p1 = new JButton("5", fingertrap);
        JButton p2 = new JButton("10", stickyhand);
        JButton p3 = new JButton("15", recorder);
        JButton p4 = new JButton("20", bounceball);
        JButton p5 = new JButton("25", pokemonCards);
        JButton p6 = new JButton("75", drone);
        JButton p7 = new JButton("100", gopro);
        JButton p8 = new JButton("200", ps5);
        JButton p9 = new JButton("200", xbox);

        p1.addActionListener(prizeHandler);
        p1.setActionCommand("p1");
        p2.addActionListener(prizeHandler);
        p2.setActionCommand("p2");
        p3.addActionListener(prizeHandler);
        p3.setActionCommand("p3");
        p4.addActionListener(prizeHandler);
        p4.setActionCommand("p4");
        p5.addActionListener(prizeHandler);
        p5.setActionCommand("p5");
        p6.addActionListener(prizeHandler);
        p6.setActionCommand("p6");
        p7.addActionListener(prizeHandler);
        p7.setActionCommand("p7");
        p8.addActionListener(prizeHandler);
        p8.setActionCommand("p8");
        p9.addActionListener(prizeHandler);
        p9.setActionCommand("p9");

        //3 rows, 3 columns, horizontal gap, vertical gap
        JPanel TicketPanel = new JPanel(new GridLayout(3, 3, 20, 10));

        //add button to panel
        TicketPanel.add(p1);
        TicketPanel.add(p2);
        TicketPanel.add(p3);
        TicketPanel.add(p4);
        TicketPanel.add(p5);
        TicketPanel.add(p6);
        TicketPanel.add(p7);
        TicketPanel.add(p8);
        TicketPanel.add(p9);

//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setSize(1000, 975);
//        frame.setBackground(Color.BLACK);
//        frame.setVisible(true);
        frame.getContentPane().add(TextBox, BorderLayout.NORTH);
        frame.getContentPane().add(TicketPanel, BorderLayout.CENTER);
        frame.getContentPane().add(TextBox1, BorderLayout.SOUTH);


    }

    public static class PrizeHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "p1":
                    if (Player.tickets >= 5) {
                        showPrize.add("Finger Trap");
                        Player.tickets -= 5;
                        System.out.println(showPrize);
                        System.out.println(Player.tickets);
                        Player.inventory.add("Finger Trap");
//                        runClerk();
                    } else {
                        System.out.println("not enough tickets");
                    }
                    break;
                case "p2":
                    if (Player.tickets >= 10) {
                        showPrize.add("Sticky Hand");
                        Player.tickets -= 10;
                        System.out.println(showPrize);
                        System.out.println(Player.tickets);
                        Player.inventory.add("Sticky Hand");
                    } else {
                        System.out.println("not enough tickets");
                    }
                    break;
                case "p3":
                    if (Player.tickets >= 15) {
                        showPrize.add("Recorder");
                        Player.tickets -= 15;
                        System.out.println(showPrize);
                        System.out.println(Player.tickets);
                        Player.inventory.add("Recorder");
                    } else {
                        System.out.println("not enough tickets");
                    }
                    break;
                case "p4":
                    if (Player.tickets >= 20) {
                        showPrize.add("Bounce ball");
                        Player.tickets -= 20;
                        System.out.println(showPrize);
                        System.out.println(Player.tickets);
                        Player.inventory.add("Bounce ball");
                    } else {
                        System.out.println("not enough tickets");
                    }
                    break;
                case "p5":
                    if (Player.tickets >= 25) {
                        showPrize.add("Pokemon cards");
                        Player.tickets -= 25;
                        System.out.println(showPrize);
                        System.out.println(Player.tickets);
                        Player.inventory.add("Pokemon cards");
                    } else {
                        System.out.println("not enough tickets");
                    }
                    break;
                case "p6":
                    if (Player.tickets >= 75) {
                        showPrize.add("Drone");
                        Player.tickets -= 75;
                        System.out.println(showPrize);
                        System.out.println(Player.tickets);
                        Player.inventory.add("Drone");
                    } else {
                        System.out.println("not enough tickets");
                    }
                    break;
                case "p7":
                    if (Player.tickets >= 100) {
                        showPrize.add("GoPro");
                        Player.tickets -= 100;
                        System.out.println(showPrize);
                        System.out.println(Player.tickets);
                        Player.inventory.add("GoPro");
                    } else {
                        System.out.println("not enough tickets");
                    }
                    break;
                case "p8":
                    if (Player.tickets >= 200) {
                        showPrize.add("PS5");
                        Player.tickets -= 200;
                        System.out.println(showPrize);
                        System.out.println(Player.tickets);
                        Player.inventory.add("PS5");
                    } else {
                        System.out.println("not enough tickets");
                    }
                    break;
                case "p9":
                    if (Player.tickets >= 200) {
                        showPrize.add("XBox");
                        Player.tickets -= 200;
                        System.out.println(showPrize);
                        System.out.println(Player.tickets);
                        Player.inventory.add("Xbox");
                    } else {
                        System.out.println("not enough tickets");
                    }
                    break;
            }
        }
    }
}
