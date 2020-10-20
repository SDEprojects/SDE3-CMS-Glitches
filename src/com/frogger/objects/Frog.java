package com.frogger.objects;

import java.awt.*;

public class Frog {

    public static final int LEFT = 0, RIGHT = 1, DOWN = 2, UP = 3, WIDTH = 22;
    private Rectangle boundingBox;
    private int x, y, direction;


    public Frog(int x, int y) {
        direction = UP;
        this.x = x;
        this.y = y;
        this.boundingBox = new Rectangle(this.x + 7, this.y + 9, 24, 24);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.boundingBox = new Rectangle(this.x + 7, this.y + 9, 24, 24);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.boundingBox = new Rectangle(this.x + 7, this.y + 9, 24, 24);
    }

    public int getHitX() {
        return x + 9;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Rectangle getBoundingBox(){
        return this.boundingBox;
    }

}