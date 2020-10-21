package com.SpaceInvaders.models;

import com.SpaceInvaders.constants.Constants;
import com.SpaceInvaders.image.Image;
import com.SpaceInvaders.image.ImageFactory;

import javax.swing.*;

public class Laser extends Sprite {
    public Laser() {

    }

    public Laser(int x, int y) {
        this.x = x;
        this.y = y;
        initialize();
    }

    private void initialize() {
        //getting image
        ImageIcon imageIcon = ImageFactory.createImage(Image.LASER);
        setImage(imageIcon.getImage());

        //making laser originate from middle of spaceship
        setX(x + Constants.SPACESHIP_WIDTH / 2);
        setY(y);
    }


    @Override
    public void move() {
        //laser movement going upwards (negative direction)
        this.y -= Constants.LASER_SPEED;

        //when laser moves off top of screen
        if (this.y < 0) {
            this.die();
        }
    }
}
