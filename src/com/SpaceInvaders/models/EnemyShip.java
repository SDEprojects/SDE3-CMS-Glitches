package com.SpaceInvaders.models;

import com.SpaceInvaders.image.Image;
import com.SpaceInvaders.image.ImageFactory;

import javax.swing.*;

public class EnemyShip extends Sprite {

    //setting as visible, when they die, they become invisible
    private boolean visible = true;

    public EnemyShip(int x, int y) {
        this.x = x;
        this.y = y;
        initialize();
    }

    private void initialize() {
        ImageIcon imageIcon = ImageFactory.createImage(Image.UFO);
        setImage(imageIcon.getImage());
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }



    public void move(int direction) {
        this.x += direction;
    }

    @Override
    public void move() {

    }
}
