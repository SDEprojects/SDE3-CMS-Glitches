package com.frogger;

import com.frogger.frames.FroggerFrame;
import com.glitches.models.Player;

public class StartFroggerGame {

    public static void main(Player player) {
        FroggerFrame frame = new FroggerFrame(player); // Starts the game.
    }
}