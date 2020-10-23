package com.glitches.TicketCounter;

import com.glitches.models.Player;

import javax.swing.*;

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

    private int tickets = Player.getTickets();

    public TicketCounter() {
        initializeTicketCounter();
    }

    public void initializeTicketCounter() {
        add(new TicketPanel());
         setTitle("Ticket Counter");

         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         setLocationRelativeTo(null);
         setResizable(false);
         setVisible(true);
    }

}
