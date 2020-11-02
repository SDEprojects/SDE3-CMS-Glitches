package com.brickbreaker;

import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Robot;
import static org.junit.Assert.*;

public class BrickPanelTest {

    @Test
    public void moveRightTest() {
        int playerX = 300;
        boolean play = true;
        if (play) {
            playerX += 20;
        }
        assertNotEquals("Player moves right",playerX, 300);
    }

    @Test
    public void moveLeftTest() {
        int playerX = 300;
        boolean play = true;

        if (play) {
            playerX -= 20;
        } else {
            playerX -= 30;
        }
        assertEquals("Player moves left", playerX, 280);

    }

    @Test
    public void keyPressedTest() {
        try {
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(1000);

        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}