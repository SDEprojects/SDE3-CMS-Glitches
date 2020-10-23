package com.glitches.TicketCounter;

import javax.swing.*;
import java.awt.*;

public class TicketPanel extends JPanel {

    public TicketPanel() {
        initializeCounterLayout();
    }

    public void initializeCounterLayout() {
        setFocusable(true);
        setPreferredSize(new Dimension(900, 750));
    }

}
