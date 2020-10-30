package com.pacman;

//import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Hero {

    GamePanel panel;
    ArrayList<Food> foods;
    ArrayList<Ghost> ghosts;
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

    public Hero(int x, int y, GamePanel panel, ArrayList<Food> foods, ArrayList<Ghost> ghosts) {
        this.panel = panel;
        this.foods = foods;
        this.ghosts = ghosts;
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

        // horizontal wall collision
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

        // vertical wall collisions
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

        // ghost collisions
        for(Ghost ghost: ghosts) {
            if(hitBox.intersects(ghost.hitBox)) {
                panel.deadByGhost();
                xspeed = 0;
                yspeed = 0;
            }
        }

        x += xspeed;
        y += yspeed;

        hitBox.x = x;
        hitBox.y = y;

        // eating
        foods.removeIf(food -> hitBox.intersects(food.hitBox));
    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.yellow);
        gtd.fillRect(x, y, width, height);
    }
}
