package com.pacman;

//import java.awt.*;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;

public class Wall {
    int x;
    int y;
    int width;
    int height;

    Rectangle hitBox;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y =y;
        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.cyan);
        gtd.drawRect(x, y, width, height);
        gtd.setColor(Color.blue);
        gtd.fillRect(x+1, y+1, width-2, height-2);
    }
}
