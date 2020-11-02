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
    int totalFood;
    public static int score;
    int hault = 0;
    int spawn = 0;

    public GamePanel() {
        startGame();
        hero = new Hero(300,475, this, this.foods, this.ghosts);
        makeWalls();
        makeGhosts();
        makeFood();
        gameTimer = new Timer();
        totalFood = foods.size(); // 139
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                hero.set();
                for(Ghost ghost: ghosts) {
                    ghost.set(hero);
                }
                checkAllFoodEaten();
                repaint();
            }
        }, 0, 17);
    }

    public void startGame() {
        running = true;
    }

    public void checkAllFoodEaten() {
        if(foods.isEmpty()){
            running = false;
        }
    }

    public void deadByGhost() {
        running = false;
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
        if(hault==0) {
            if(running){
                super.paint(g);

                Graphics2D gtd = (Graphics2D)g;
                hero.draw(gtd);
                for(Wall wall: walls) wall.draw(gtd);
                for(Ghost ghost: ghosts) ghost.draw(gtd);
                for(Food food: foods) food.draw(gtd);
            } else {
                hault++;
                endGameMessage(g);
                gameTimer.cancel();
            }
        }
    }

    public void endGameMessage(Graphics g) { // This method will end the game, tell the player if they won or lost, then restart if needed.
            // set the screen
            g.setColor(Color.green);
            score = totalFood - foods.size();
            Player.tickets += score;
            g.setFont(new Font("TimesRoman", Font.ITALIC, 40));
            if(score == 139) {
                g.drawString("You win! Tickets rewarded: " + score, 20, 150);
            } else {
                g.drawString("You lose. Tickets rewarded: " + score, 20, 150);
            }
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            hero.keyLeft = true;
            if(spawn % 5 == 0) {
                ghosts.add(new Ghost(325, 230, this));
            }
            spawn++;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP) hero.keyUp = true;
        if(e.getKeyCode()==KeyEvent.VK_DOWN) hero.keyDown = true;
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            hero.keyRight = true;
//            if(spawn % 3 == 0) {
//                ghosts.add(new Ghost(285, 300, this));
//                spawn++;
//            }
//            spawn++;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT) hero.keyLeft = false;
        if(e.getKeyCode()==KeyEvent.VK_UP) hero.keyUp = false;
        if(e.getKeyCode()==KeyEvent.VK_DOWN) hero.keyDown = false;
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) hero.keyRight = false;
    }

    public void makeFood(){
        // bottom border
        for(int i = 50; i < 175; i += 25) {
            foods.add(new Food(i, 525));
        }
        for(int i = 275; i < 450; i += 25) {
            foods.add(new Food(i, 525));
        }
        for(int i = 500; i < 650; i += 25) {
            foods.add(new Food(i, 525));
        }
        // left border
        for(int i = 50; i < 550; i += 25){
            foods.add(new Food(35, i));
        }
        // right border
        for(int i = 50; i < 525; i += 25){
            foods.add(new Food(625, i));
        }
        // top border
        for(int i = 50; i < 175; i += 25) {
            foods.add(new Food(i, 35));
        }
        //top mid
        for(int i = 275; i < 450; i += 25) {
            foods.add(new Food(i, 35));
        }
        // top left
        for(int i = 500; i < 650; i += 25) {
            foods.add(new Food(i, 35));
        }
        // top left divider
        for(int i = 50; i < 100; i += 25) {
            foods.add(new Food(250, i));
        }
        // top right divider
        for(int i = 50; i < 100; i += 25) {
            foods.add(new Food(425, i));
        }
        // bottom left divider
        for(int i = 500; i > 400; i -= 25) {
            foods.add(new Food(250, i));
        }
        //bottom right divider
        for(int i = 500; i > 400; i -= 25) {
            foods.add(new Food(425, i));
        }
        // top left island
        for(int i = 75; i < 200; i += 25) {
            foods.add(new Food(150, i));
        }
        // top right island
        for(int i = 75; i < 200; i += 25) {
            foods.add(new Food(525, i));
        }
        // bottom left island
        for(int i = 475; i > 350; i -= 25) {
            foods.add(new Food(150, i));
        }
        // bottom right island
        for(int i = 475; i > 350; i -= 25) {
            foods.add(new Food(525, i));
        }
        // right ghost room wall
        for(int i = 200; i < 375; i += 25) {
            foods.add(new Food(475, i));
        }
        // left ghost room wall
        for(int i = 200; i < 375; i += 25) {
            foods.add(new Food(200, i));
        }
        // center bottom divider wall
        for(int i = 275; i < 400; i += 25) {
            foods.add(new Food(i, 400));
        }
        // center top divider wall
        for(int i = 275; i < 400; i += 25) {
            foods.add(new Food(i, 175));
        }
        // left mid wall
        for(int i = 75; i < 175; i += 25) {
            foods.add(new Food(i, 225));
        }
        // right mid wall
        for(int i = 500; i < 600; i += 25) {
            foods.add(new Food(i, 225));
        }
    }

    public int totalInitFood(){
        return foods.size();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
