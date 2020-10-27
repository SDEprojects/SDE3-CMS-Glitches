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
    Frog frog;
    CarLane[] carLanes;

    public FroggerGame() {

        status = PLAYING;
        reachedMiddle = false;
        lives = 3;
        frog = new Frog(frogX, frogY);
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
        for (CarLane carLane : carLanes) carLane.update();
        for (int y = 0; y < carLanes.length; y++)
            runChecks();
    }

    public int getStatus() {
        return status;
    }

    public int getLives() {
        return lives;
    }

    public Frog getFrog() {
        return frog;
    }

    public CarLane[] getCarLanes() {
        return carLanes;

    }

    void playerDeath() {
        lives--;
        if (lives > 0) {
            frog.setX(frogX);
            frog.setY(frogY);
        }
        else {
            DEAD = true;
        }
    }

    void carCheck() {
        if (CollisionDetector.CollisionDetector(this.getFrog(), this.getCarLanes())) {
            playerDeath();
        }
    }

    void checkifThePlayerWin() {
        if (this.frog.getY() <= 50){
            WIN = true;
        }
    }

    void runChecks() {
        carCheck();
        checkifThePlayerWin();
    }
}