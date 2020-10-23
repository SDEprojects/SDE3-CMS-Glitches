package com.pacman;

import com.glitches.models.Player;

//import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener {

    Hero hero;
    ArrayList<Wall> walls = new ArrayList<>();
    Timer gameTimer;

    public GamePanel() {
        hero = new Hero(300,450, this);
        makeWalls();
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                hero.set();
                repaint();
            }
        }, 0, 17);
    }

    public void makeWalls() {
        // bottom border
        for(int i = 25; i < 675; i += 25) {
            walls.add(new Wall(i, 550, 25, 25));
        }
        // left border
        for(int i = 0; i < 575; i += 25){
            walls.add(new Wall(0, i, 25, 25));
        }
        // right border
        for(int i = 0; i < 550; i += 25){
            walls.add(new Wall(650, i, 25, 25));
        }
        // top border
        for(int i = 25; i < 675; i += 25) {
            walls.add(new Wall(i, 0, 25, 25));
        }
        // top left divider
        for(int i = 25; i < 100; i += 25) {
            walls.add(new Wall(175, i, 50, 25));
        }
        // top right divider
        for(int i = 25; i < 100; i += 25) {
            walls.add(new Wall(450, i, 50, 25));
        }
        // bottom left divider
        for(int i = 550; i > 450; i -= 25) {
            walls.add(new Wall(175, i, 50, 25));
        }
        //bottom right divider
        for(int i = 550; i > 450; i -= 25) {
            walls.add(new Wall(450, i, 50, 25));
        }
        // top left island
        for(int i = 75; i < 200; i += 25) {
            walls.add(new Wall(75, i, 50, 25));
        }
        // top right island
        for(int i = 75; i < 200; i += 25) {
            walls.add(new Wall(550, i, 50, 25));
        }
        // bottom left island
        for(int i = 475; i > 350; i -= 25) {
            walls.add(new Wall(75, i, 50, 25));
        }
        // bottom right island
        for(int i = 475; i > 350; i -= 25) {
            walls.add(new Wall(550, i, 50, 25));
        }
        // right ghost room wall
        for(int i = 200; i < 375; i += 25) {
            walls.add(new Wall(400, i, 50, 25));
        }
        // left ghost room wall
        for(int i = 200; i < 375; i += 25) {
            walls.add(new Wall(225, i, 50, 25));
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D gtd = (Graphics2D)g;
        hero.draw(gtd);
        for(Wall wall: walls) wall.draw(gtd);
    }



    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT) hero.keyLeft = true;
        if(e.getKeyCode()==KeyEvent.VK_UP) hero.keyUp = true;
        if(e.getKeyCode()==KeyEvent.VK_DOWN) hero.keyDown = true;
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) hero.keyRight = true;
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT) hero.keyLeft = false;
        if(e.getKeyCode()==KeyEvent.VK_UP) hero.keyUp = false;
        if(e.getKeyCode()==KeyEvent.VK_DOWN) hero.keyDown = false;
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) hero.keyRight = false;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
