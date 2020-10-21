package com.frogger.frames;

import com.frogger.objects.*;

public class FroggerGame {

    public static int PLAYING = 0;
    public static boolean DEAD = false;
    public static boolean WIN = false;
    public static final int frogX = 320, frogY = 275;
    public static final int CarLaneInitialY = 75;

    int status, lives;
    boolean reachedMiddle;
    Frog player;
    CarLane[] carLanes;

    public FroggerGame() {

        status = FroggerGame.PLAYING;
        reachedMiddle = false;
        lives = 3;
        player = new Frog(frogX, frogY);
        carLanes = new CarLane[5];

        for (int i = 0; i < carLanes.length; i++) {
            if (i % 2 == 0)
                carLanes[i] = new CarLane(3, Lane.RIGHT, CarLaneInitialY + i * 40);
            else
                carLanes[i] = new CarLane(3, Lane.LEFT, CarLaneInitialY + i * 40);
        }

        for (int t = 0; t < 1000; t++) //calls update on all lanes before loading game
            update();
    }

    public void update() {
        for (int u = 0; u < carLanes.length; u++)
            carLanes[u].update();
        for (int y = 0; y < carLanes.length; y++)
            runChecks();
    }

    public int getStatus() {
        return status;
    }

    public int getLives() {
        return lives;
    }

    public Frog getPlayer() {
        return player;
    }

    public CarLane[] getCarLanes() {
        return carLanes;

    }

    void playerDeath() {
        lives--;
        if (lives > 0) {
            player.setX(frogX);
            player.setY(frogY);
        }
        else {
            DEAD = true;
        }
    }

    void carCheck() {
        //todo kills player when contacting car{
        if (CollisionDetector.CollisionDetector(this.getPlayer(), this.getCarLanes())) {
            playerDeath();
        }
    }

    void checkifThePlayerWin() {
        if (this.player.getY() <= 50){
            WIN = true;
        }
    }

    void runChecks() {
        carCheck();
        checkifThePlayerWin();
    }
}