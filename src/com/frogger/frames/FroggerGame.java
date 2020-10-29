package com.frogger.frames;

import com.frogger.objects.*;

public class FroggerGame {

    public int PLAYING = 0;
    public boolean DEAD = false;
    public boolean WIN = false;
    public final int frogX = 320, frogY = 275;
    public final int CarLaneInitialY = 75;

    int status, lives;
    boolean reachedMiddle;
    Frog frog;
    CarLane[] carLanes;
    FroggerPanel panel;

    public FroggerGame(FroggerPanel panel) {
        this.panel = panel;
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
            panel.gameOver();
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
            panel.gameOver();
            WIN = true;
        }
    }

    void runChecks() {
        carCheck();
        checkifThePlayerWin();
    }
}