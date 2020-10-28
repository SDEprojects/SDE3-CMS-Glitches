package com.SpaceInvaders.models;

import com.SpaceInvaders.constants.Constants;
import com.SpaceInvaders.image.Image;
import com.SpaceInvaders.image.ImageFactory;
import com.SpaceInvaders.models.Sprite;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;


public class Spaceship extends Sprite {

    public Spaceship() {
        initialize();
    }

    private void initialize() {
        // getting spaceship image
        ImageIcon imageIcon = ImageFactory.createImage(Image.SPACESHIP);
        setImage(imageIcon.getImage());

        // starts image bottom of page, centered
        int start_x = Constants.BOARD_WIDTH/2-Constants.SPACESHIP_WIDTH/2;
        int start_y = Constants.BOARD_HEIGHT -100;

        setX(start_x);
        setY(start_y);
    }


    @Override
    public void move() {
        //moves the spaceship
        x += dx;
        // keeps ship from going off screen to left with ship width buffer
        if(x < Constants.SPACESHIP_WIDTH) {
            x = Constants.SPACESHIP_WIDTH;
        }
        // keeps ship from going off screen to right with ship width buffer
        if (x >= Constants.BOARD_WIDTH - 2 * Constants.SPACESHIP_WIDTH) {
            x = Constants.BOARD_WIDTH - 2 * Constants.SPACESHIP_WIDTH;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        // if left arrow button pressed
        if(key==KeyEvent.VK_LEFT) {
            dx = -2;  // subtract 2 px from x axis
        }
        // if right arrow button pressed
        if(key==KeyEvent.VK_RIGHT) {
            dx = 2;  // add 2 px to x axis
        }
    }

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
        //  stops the movement when key is released
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
