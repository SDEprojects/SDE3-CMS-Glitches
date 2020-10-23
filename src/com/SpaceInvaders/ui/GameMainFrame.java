package com.SpaceInvaders.ui;

import com.SpaceInvaders.constants.Constants;
import com.SpaceInvaders.image.Image;
import com.SpaceInvaders.image.ImageFactory;
import com.glitches.models.Player;

import javax.swing.*;

public class GameMainFrame extends JFrame {

    public GameMainFrame(Player player) {
        initializeLayout(player);
    }

    private void initializeLayout(Player player) {

        add(new GamePanel(player));

        setTitle(Constants.Title);  // from Constants Class

        pack();  // makes frame same size and layout as subcomponents

        //setting Icon as spaceship image through image enum and getting image from the imagefactory
        setIconImage(ImageFactory.createImage(Image.SPACESHIP).getImage());


        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //close when x is clicked
        setLocationRelativeTo(null);  //  centered in middle of screen
        setResizable(false);  // user can't resize screen
        setVisible(true);  // frame is visible to user

    }


}
