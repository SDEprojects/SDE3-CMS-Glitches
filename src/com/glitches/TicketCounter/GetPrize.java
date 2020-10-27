package com.glitches.TicketCounter;


import com.glitches.models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GetPrize {
    public static void main(Player player) {
        //getting # tickets earned by player
        int tickets = Player.getTickets();
        ArrayList<String> showPrize = new ArrayList<>();
        // testing array
//        showPrize.add("fingertrap");
//        showPrize.add("PS4");
//        showPrize.add("drone");
//        showPrize.add("fingertrap");
//        showPrize.add("PS4");
//        showPrize.add("drone");
//        showPrize.add("fingertrap");
//        showPrize.add("PS4");
//        showPrize.add("drone");
//        showPrize.add("fingertrap");
//        showPrize.add("PS4");
//        showPrize.add("drone");
//        showPrize.add("fingertrap");
//        showPrize.add("PS4");
//        showPrize.add("drone");
//        showPrize.add("fingertrap");
//        showPrize.add("PS4");
//        showPrize.add("drone");
//        showPrize.add("fingertrap");
//        showPrize.add("PS4");
//        showPrize.add("drone");
//        showPrize.add("fingertrap");
//        showPrize.add("PS4");
//        showPrize.add("drone");
//        showPrize.add("fingertrap");
//        showPrize.add("PS4");
//        showPrize.add("drone");

        // making a new JFrame
        JFrame frame = new JFrame("Ticket Counter");

        //making 1 JPanel with BorderLayout for Text
        JPanel TextBox = new JPanel(new BorderLayout());

        //making the JLabel inside of the first JPanel
        JLabel text = new JLabel();
        //using <html> tags allows text to wrap
        text.setText("<html>You have " + tickets + " remaining.");
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


        // prize pictures locations
        ImageIcon fingertrap = new ImageIcon("src/com/glitches/TicketCounter/prizes/fingerTrap.jpg");
        ImageIcon stickyhand = new ImageIcon("src/com/glitches/TicketCounter/prizes/stickyHand.jpg");
        ImageIcon recorder = new ImageIcon("src/com/glitches/TicketCounter/prizes/recorder.jpg");
        ImageIcon bounceball = new ImageIcon("src/com/glitches/TicketCounter/prizes/superBounceBall.jpg");
        ImageIcon pokemonCards = new ImageIcon("src/com/glitches/TicketCounter/prizes/pokemonCards.jpg");
        ImageIcon drone = new ImageIcon("src/com/glitches/TicketCounter/prizes/drone.jpg");
        ImageIcon gopro = new ImageIcon("src/com/glitches/TicketCounter/prizes/goPro.jpg");
        ImageIcon ps5 = new ImageIcon("src/com/glitches/TicketCounter/prizes/PS5Bundle.jpg");
        ImageIcon xbox = new ImageIcon("src/com/glitches/TicketCounter/prizes/XboxBundle.jpg");


        //adding buttons  with mouse Listener  for 2nd JPanel
        JButton p1 = new JButton("5", fingertrap);
        p1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                showPrize.add("Finger Trap");
                System.out.println(showPrize);

            }
        });
        JButton p2 = new JButton("10", stickyhand);
        //p2.addMouseListener(new MouseListener());
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


        //frame settings  the frame is border layout, the jbuttons panel is gridlayout
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 975);
        frame.setBackground(Color.BLACK);
        frame.getContentPane().add(TextBox, BorderLayout.NORTH);
        frame.getContentPane().add(TicketPanel, BorderLayout.CENTER);
        frame.getContentPane().add(TextBox1, BorderLayout.SOUTH);
        frame.setVisible(true);

        //check();

//        private static void check(tickets) {
//                if (player.getTickets() >= 5) {
//                    switch (e.MouseEvent) {
//                        case p1:
//                            showPrize.add("Finger Trap");
//                            break;
//                        case p2:
//                            showPrize.add("Sticky Hand");
//                            break;
//                    }
//                } else {
//                    System.out.println("not enough tickets");
//                }
//            }

        }
}
