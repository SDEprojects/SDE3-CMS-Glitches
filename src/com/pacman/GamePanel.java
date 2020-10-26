package com.pacman;

import com.glitches.models.Player;

//import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener {

    Hero hero;
    ArrayList<Ghost> ghosts = new ArrayList<>();
    ArrayList<Wall> walls = new ArrayList<>();
    ArrayList<Food> foods = new ArrayList<>();
    Timer gameTimer;
    boolean running = false;

    public GamePanel() {
        startGame();
        hero = new Hero(300,475, this, this.foods);
        makeWalls();
        makeGhosts();
        makeFood();
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                hero.set();
                for(Ghost ghost: ghosts) {
                    ghost.set();
                }
                checkDeath();
                repaint();
            }
        }, 0, 17);
    }

    public void startGame() {
        running = true;
    }

    public void checkDeath() {
        for(Ghost ghost: ghosts) {
            if(ghost.x == hero.x && ghost.y == hero.y) {
                System.out.println("dead");
                running = false;
            }
        }
    }

    public void makeGhosts() {
        ghosts.add(new Ghost(285, 300, this));
        ghosts.add(new Ghost(325, 300, this));
        ghosts.add(new Ghost(325, 230, this));
        ghosts.add(new Ghost(285, 225, this));
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
        // bottom ghost room wall
        for(int i = 275; i < 400; i += 25) {
            walls.add(new Wall(i, 350, 25, 25));
        }
        // center bottom divider wall
        for(int i = 275; i < 400; i += 25) {
            walls.add(new Wall(i, 425, 25, 50));
        }
        // center top divider wall
        for(int i = 275; i < 400; i += 25) {
            walls.add(new Wall(i, 100, 25, 50));
        }
        // left mid wall
        for(int i = 75; i < 175; i += 25) {
            walls.add(new Wall(i, 250, 25, 75));
        }
        // right mid wall
        for(int i = 500; i < 600; i += 25) {
            walls.add(new Wall(i, 250, 25, 75));
        }
    }

    public void paint(Graphics g) {
        if(running){
            super.paint(g);

            Graphics2D gtd = (Graphics2D)g;
            hero.draw(gtd);
            for(Wall wall: walls) wall.draw(gtd);
            for(Ghost ghost: ghosts) ghost.draw(gtd);
            for(Food food: foods) food.draw(gtd);
        } else {
            endGameMessage(g);
        }
    }

    public void endGameMessage(Graphics g) { // This method will end the game, tell the player if they won or lost, then restart if needed.
//        if (blocksEaten < 10) {
//            // give tickets to player
//            int winnings = blocksEaten;
//            player.setTickets(winnings);

            // set the screen
            g.setColor(Color.green);
            g.setFont(new Font("TimesRoman", Font.ITALIC, 40));
            g.drawString("You lose. Tickets rewarded: " + 10, 10, 100);
//            addRestartButton();
            System.out.println("tickets won: " + 10);
//        } else if (blocksEaten == 10) {
////            player.setTickets(blocksEaten);
//            g.setColor(Color.green);
//            g.setFont(new Font("TimesRoman", Font.ITALIC, 30));
//            g.drawString("You ate 10! Tickets rewarded:" + blocksEaten, 10, 100);
//        }
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

    public void makeFood(){
        // bottom border
        for(int i = 25; i < 675; i += 25) {
            foods.add(new Food(i, 525));
        }
        // left border
        for(int i = 0; i < 575; i += 25){
            foods.add(new Food(35, i));
        }
        // right border
        for(int i = 0; i < 550; i += 25){
            foods.add(new Food(625, i));
        }
        // top border
        for(int i = 25; i < 675; i += 25) {
            foods.add(new Food(i, 35));
        }
        // top left divider
        for(int i = 25; i < 100; i += 25) {
            foods.add(new Food(175, i));
        }
        // top right divider
        for(int i = 25; i < 100; i += 25) {
            foods.add(new Food(450, i));
        }
        // bottom left divider
        for(int i = 550; i > 450; i -= 25) {
            foods.add(new Food(175, i));
        }
        //bottom right divider
        for(int i = 550; i > 450; i -= 25) {
            foods.add(new Food(450, i));
        }
        // top left island
        for(int i = 75; i < 200; i += 25) {
            foods.add(new Food(75, i));
        }
        // top right island
        for(int i = 75; i < 200; i += 25) {
            foods.add(new Food(550, i));
        }
        // bottom left island
        for(int i = 475; i > 350; i -= 25) {
            foods.add(new Food(75, i));
        }
        // bottom right island
        for(int i = 475; i > 350; i -= 25) {
            foods.add(new Food(550, i));
        }
        // right ghost room wall
        for(int i = 200; i < 375; i += 25) {
            foods.add(new Food(400, i));
        }
        // left ghost room wall
        for(int i = 200; i < 375; i += 25) {
            foods.add(new Food(225, i));
        }
        // bottom ghost room wall
        for(int i = 275; i < 400; i += 25) {
            foods.add(new Food(i, 350));
        }
        // center bottom divider wall
        for(int i = 275; i < 400; i += 25) {
            foods.add(new Food(i, 425));
        }
        // center top divider wall
        for(int i = 275; i < 400; i += 25) {
            foods.add(new Food(i, 100));
        }
        // left mid wall
        for(int i = 75; i < 175; i += 25) {
            foods.add(new Food(i, 250));
        }
        // right mid wall
        for(int i = 500; i < 600; i += 25) {
            foods.add(new Food(i, 250));
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
