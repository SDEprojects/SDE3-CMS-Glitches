package com.pacman;

//import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hero {

    GamePanel panel;
    int x;
    int y;
    int width;
    int height;

    double xspeed;
    double yspeed;

    Rectangle hitBox;
    boolean keyLeft;
    boolean keyRight;
    boolean keyDown;
    boolean keyUp;

    public Hero(int x, int y, GamePanel panel) {
        this.panel = panel;
        this.x = x;
        this.y = y;

        width = 30;
        height = 30;
        hitBox = new Rectangle(x, y, width, height);
    }

    public void set() {
        if(keyLeft && !keyRight) {
            yspeed = 0;
            xspeed = -5;
        } else if (keyRight && !keyLeft) {
            yspeed = 0;
            xspeed = 5;
        }

        if(keyUp && !keyDown) {
            xspeed = 0;
            yspeed = -5;
        } else if (keyDown && !keyUp) {
            xspeed = 0;
            yspeed = 5;
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

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.yellow);
        gtd.fillRect(x, y, width, height);
    }
}
