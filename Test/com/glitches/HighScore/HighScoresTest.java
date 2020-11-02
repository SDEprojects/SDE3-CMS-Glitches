package com.glitches.HighScore;

import com.SpaceInvaders.ui.GamePanel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighScoresTest {




    @Test
    void testgetSpaceScore() {

        assertEquals(0, GamePanel.score);
    }
    @Test
    void testgetName() {
        assertEquals("", "");
    }
}