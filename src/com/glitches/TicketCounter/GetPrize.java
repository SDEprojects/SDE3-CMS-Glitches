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

    public static ImageIcon fingertrap = new ImageIcon("src/com/glitches/TicketCounter/prizes/fingerTrap.jpg");
    public static ImageIcon stickyhand = new ImageIcon("src/com/glitches/TicketCounter/prizes/stickyHand.jpg");
    public static ImageIcon recorder = new ImageIcon("src/com/glitches/TicketCounter/prizes/recorder.jpg");
    public static ImageIcon bounceball = new ImageIcon("src/com/glitches/TicketCounter/prizes/superBounceBall.jpg");
    public static ImageIcon pokemonCards = new ImageIcon("src/com/glitches/TicketCounter/prizes/pokemonCards.jpg");
    public static ImageIcon drone = new ImageIcon("src/com/glitches/TicketCounter/prizes/drone.jpg");
    public static ImageIcon gopro = new ImageIcon("src/com/glitches/TicketCounter/prizes/goPro.jpg");
    public static ImageIcon ps5 = new ImageIcon("src/com/glitches/TicketCounter/prizes/PS5Bundle.jpg");
    public static ImageIcon xbox = new ImageIcon("src/com/glitches/TicketCounter/prizes/XboxBundle.jpg");

    public static void main(Player player) {
        // making a new JFrame
        JFrame frame = new JFrame("Ticket Counter");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 975);
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
        p1.addActionListener(prizeHandler);
        p1.setActionCommand("p1");
        JButton p2 = new JButton("10", stickyhand);
        JButton p3 = new JButton("15", recorder);
        JButton p4 = new JButton("20", bounceball);
        JButton p5 = new JButton("25", pokemonCards);
        JButton p6 = new JButton("75", drone);
        JButton p7 = new JButton("100", gopro);
        JButton p8 = new JButton("200", ps5);
        JButton p9 = new JButton("200", xbox);


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
                    showPrize.add("Does this work");
                    Player.tickets -= 5;
//                    tickets = Player.setTickets();
                    System.out.println(showPrize);
                        System.out.println(Player.tickets);}
                    else {
                        System.out.println("not enough tickets");}
                    break;
                case "p2":
                    showPrize.add("2");
                    Player.tickets -= 10;
                    System.out.println(showPrize);
                    break;
            }
        }
    }
}
