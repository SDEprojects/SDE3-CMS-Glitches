package com.pacman;

//import java.awt.*;
import java.awt.*;
import java.util.Random;

public class Ghost {

    GamePanel panel;

    int x;
    int y;
    int width;
    int height;
    boolean triedUp;
    boolean triedLeft;

    double xspeed;
    double yspeed;

    Rectangle hitBox;

    public Ghost(int x, int y, GamePanel panel) {
        this.panel = panel;
        this.x = x;
        this.y = y;

        yspeed = -3;

        width = 30;
        height = 30;
        hitBox = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.red);
        gtd.fillRect(x, y, width, height);
    }

    // decide which way to go at a dead end
    public void set(Hero hero) {
        Random random = new Random();
        // pick a random decision
        int direction = random.nextInt(8);
        if(yspeed == 0 && xspeed == 0) {

//            // if UP and Left
//            if(triedUp && triedLeft) {
//                xspeed = 3;
//                triedLeft = false;
//            }
//            if(triedUp && triedLeft){
//                yspeed = 3;
//                triedUp = false;
//            }
//
//            // if UP and RIGHT
//            if(triedUp && !triedLeft){
//                xspeed = -3;
//                triedLeft = true;
//            }
//            if(triedUp && !triedLeft){
//                yspeed = 3;
//                triedUp = false;
//            }
//
//            // if DOWN and LEFT
//            if(!triedUp && triedLeft){
//                xspeed = 3;
//                triedLeft = false;
//            }
//            if(!triedUp && triedLeft){
//                yspeed = -3;
//                triedUp = true;
//            }
//
//            // if DOWN and RIGHT
//            if(!triedUp && !triedLeft){
//                xspeed = -3;
//                triedLeft = true;
//            }
//            if(!triedUp && !triedLeft){
//                yspeed = -3;
//                triedUp = true;
//            }
            switch (direction) {
                case 0:
                case 5:
                    xspeed = 3;
                    break;
                case 1:
                case 6:
                    xspeed = -3;
                    break;
                case 2:
                case 7:
                    yspeed = 3;
                    break;
                case 3:
                case 4:
                    yspeed = -3;
                    break;
            }
        }

        // horizontal collision
        hitBox.x += xspeed;
        for (Wall wall: panel.walls) {
            if(hitBox.intersects(wall.hitBox)){
                hitBox.x -= xspeed;
                while(!wall.hitBox.intersects(hitBox)) {
                    hitBox.x += Math.signum(xspeed);
                }
                hitBox.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitBox.x;
            }
        }

        // vertical collisions
        hitBox.y += yspeed;
        for (Wall wall: panel.walls) {
            if(hitBox.intersects(wall.hitBox)){
                hitBox.y -= yspeed;
                while(!wall.hitBox.intersects(hitBox)) {
                    hitBox.y += Math.signum(yspeed);
                }
                hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitBox.y;
            }
        }

        x += xspeed;
        y += yspeed;

        hitBox.x = x;
        hitBox.y = y;
    }
}
