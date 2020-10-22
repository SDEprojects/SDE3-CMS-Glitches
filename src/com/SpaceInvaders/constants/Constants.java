package com.SpaceInvaders.constants;

import com.SpaceInvaders.ui.GamePanel;
import com.frogger.frames.FroggerPanel;

public class Constants {

    private Constants() {

    }

    public static final String Title = "Space Invaders";

    // size of the board, not the frame
    public static final int BOARD_WIDTH = 900;
    public static final int BOARD_HEIGHT = 750;

    public static final int BOMB_HEIGHT = 6;

    // UFO constants
    public static final int ENEMY_SHIP_HEIGHT = 24;
    public static final int ENEMY_SHIP_WIDTH = 32;
    public static final int ENEMY_SHIP_INIT_X = 300; // starting point
    public static final int ENEMY_SHIP_INIT_Y = 100;  // starting point
    public static final int ENEMY_SHIPS_ROW = 4;
    public static final int ENEMY_SHIPS_COLUMN = 8;
    public static final int BORDER_PADDING = 50;



    public static final int INVADING = 30;
    public static final int NUMBER_OF_ALIENS_TO_DESTROY = 32;
    public static final double BOMB_DROPPING_PROBABILITY = 0.0005;

    //speed of the game
    public static final int GAME_SPEED = 10;

    // Spaceship width and height
    public static final int SPACESHIP_WIDTH = 34;
    public static final int SPACESHIP_HEIGHT = 28;

    //speed of laser
    public static final int LASER_SPEED = 4;

    // image locations
    public static final String BACKGROUND_IMAGE_URL = "src/com/SpaceInvaders/sprites/background.jpg";
    public static final String SPACESHIP_IMAGE_URL = "src/com/SpaceInvaders/sprites/spaceship.png";
    public static final String BOMB_IMAGE_URL = "src/com/SpaceInvaders/sprites/bomb.png";
    public static final String LASER_IMAGE_URL = "src/com/SpaceInvaders/sprites/laser.png";
    public static final String UFO_IMAGE_URL = "src/com/SpaceInvaders/sprites/ufo.png";

    public static final String WIN = "Congratulations!";
    public static final String GAME_OVER = "Better Luck Next Time!";
    public static final String TICKETS = "Tickets Won: " + GamePanel.score + " !";

}
