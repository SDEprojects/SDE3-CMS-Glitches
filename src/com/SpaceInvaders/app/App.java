package com.SpaceInvaders.app;

import com.SpaceInvaders.ui.GameMainFrame;
import com.glitches.models.Player;

import java.awt.EventQueue;

public class App {

    public static void main() {

        //allows for the gui not to be bogged down while processing sounds and inputs
        EventQueue.invokeLater( () -> {
            new GameMainFrame();
        });
    }
}
