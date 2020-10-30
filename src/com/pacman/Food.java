package com.pacman;

import java.awt.*;

public class Food {
    int x;
    int y;
    int width;
    int height;

    Rectangle hitBox;

    public Food(int x, int y) {
        this.x = x;
        this.y = y;
        width = 10;
        height = 10;
        hitBox = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.yellow);
        gtd.drawRect(x, y, width, height);
        gtd.setColor(Color.white);
        gtd.fillRect(x+1, y+1, width-2, height-2);
    }
}
