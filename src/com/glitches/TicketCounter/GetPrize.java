package com.glitches.TicketCounter;


import com.glitches.models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GetPrize extends javax.swing.JFrame{

    public static PrizeHandler prizeHandler = new PrizeHandler();
    public static String prize;
    private static JPanel TextBox1;
    private static GetPrizePanel panel;
    public static boolean purchased = false;

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
        panel = new GetPrizePanel(new BorderLayout());
        //making the JLabel inside of the first JPanel
        JLabel text = new JLabel();
        //using <html> tags allows text to wrap
        text.setText("<html>You have " + Player.tickets + " remaining.</html>");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("TimesRoman", Font.BOLD, 20));
        //adding JLabel to JPanel
        panel.add(text);

        // making 2nd panel with prizes bought
        TextBox1 = new JPanel(new BorderLayout());
        //making the JLabel inside of the first JPanel
        JLabel list = new JLabel();
        //using <html> tags allows text to wrap
        list.setText("<html>Prizes selected: " + Player.inventory + ".</html>");
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

        // prizes buttons panel
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

        // Don't include the North and South panels anymore
//        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(TicketPanel, BorderLayout.CENTER);
//        frame.getContentPane().add(TextBox1, BorderLayout.SOUTH);


    }

    public static void popUp() {
        GetPrizeFrame frame = new GetPrizeFrame();
        frame.setSize(500, 100);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2),
                (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
        frame.setResizable(false);
        frame.setTitle(prize);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static class PrizeHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "p1":
                    if (Player.tickets >= 5) {
                        Player.tickets -= 5;
                        System.out.println(Player.tickets);
                        Player.inventory.add("Finger Trap");
                        prize = "Finger Trap";
                        purchased = true;
                    } else {
                        System.out.println("not enough tickets");
                        purchased = false;
                    }
                    break;
                case "p2":
                    if (Player.tickets >= 10) {
                        Player.tickets -= 10;
                        System.out.println(Player.tickets);
                        Player.inventory.add("Sticky Hand");
                        prize = "Sticky Hand";
                        purchased = true;
                    } else {
                        System.out.println("not enough tickets");
                        purchased = false;
                    }
                    break;
                case "p3":
                    if (Player.tickets >= 15) {
                        Player.tickets -= 15;
                        System.out.println(Player.tickets);
                        Player.inventory.add("Recorder");
                        prize = "Recorder";
                        purchased = true;
                    } else {
                        System.out.println("not enough tickets");
                        purchased = false;
                    }
                    break;
                case "p4":
                    if (Player.tickets >= 20) {
                        Player.tickets -= 20;
                        System.out.println(Player.tickets);
                        Player.inventory.add("Bounce ball");
                        prize = "Bounce ball";
                        purchased = true;
                    } else {
                        System.out.println("not enough tickets");
                        purchased = false;
                    }
                    break;
                case "p5":
                    if (Player.tickets >= 25) {
                        Player.tickets -= 25;
                        System.out.println(Player.tickets);
                        Player.inventory.add("Pokemon cards");
                        prize = "Pokemon cards";
                        purchased = true;
                    } else {
                        System.out.println("not enough tickets");
                        purchased = false;
                    }
                    break;
                case "p6":
                    if (Player.tickets >= 75) {
                        Player.tickets -= 75;
                        System.out.println(Player.tickets);
                        Player.inventory.add("Drone");
                        prize = "Drone";
                        purchased = true;
                    } else {
                        System.out.println("not enough tickets");
                        purchased = false;
                    }
                    break;
                case "p7":
                    if (Player.tickets >= 100) {
                        Player.tickets -= 100;
                        System.out.println(Player.tickets);
                        Player.inventory.add("GoPro");
                        prize = "GoPro";
                        purchased = true;
                    } else {
                        System.out.println("not enough tickets");
                        purchased = false;
                    }
                    break;
                case "p8":
                    if (Player.tickets >= 200) {
                        Player.tickets -= 200;
                        System.out.println(Player.tickets);
                        Player.inventory.add("PS5");
                        prize = "PS5";
                        purchased = true;
                    } else {
                        System.out.println("not enough tickets");
                        purchased = false;
                    }
                    break;
                case "p9":
                    if (Player.tickets >= 200) {
                        Player.tickets -= 200;
                        System.out.println(Player.tickets);
                        Player.inventory.add("XBox");
                        prize = "XBox";
                        purchased = true;
                    } else {
                        System.out.println("not enough tickets");
                        purchased = false;
                    }
                    break;
            }
            popUp();
        }
    }
}
