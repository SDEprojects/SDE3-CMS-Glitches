package com.SpaceInvaders.models;

import com.SpaceInvaders.constants.Constants;
import com.SpaceInvaders.image.Image;
import com.SpaceInvaders.image.ImageFactory;

import javax.swing.*;

public class Bomb extends Sprite{

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
        initialize();
    }

    private void initialize() {
        ImageIcon imageIcon = ImageFactory.createImage(Image.BOMB);
        setImage(imageIcon.getImage());
    }


    @Override
    public void move() {

        this.y++;
        //dies at bottom of frame
        if (y >= Constants.BOARD_HEIGHT - Constants.BOMB_HEIGHT) {
            die();
        }

    }
}
