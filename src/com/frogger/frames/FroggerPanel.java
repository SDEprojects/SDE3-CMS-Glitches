package com.frogger.frames;

import com.frogger.conditions.*;
import com.frogger.objects.*;

import com.glitches.models.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class FroggerPanel extends JPanel implements ActionListener, Runnable {

    public static int HEIGHT = 450;
    public static int WIDTH = 700;
    public static int score;
    Player player;
    private final CollisionDetector checkForCollision;

    BufferedImage car1_Left, car1_Right, car2_Left, car2_Right, limo_Left, limo_Right, semi_Left, semi_Right, frogUp, frogDown,
            frogLeft, frogRight, frogLife;
    FroggerGame game;

    public FroggerPanel(Player player) {
        this.player = player;
        this.addKeyListener(new MyKeyAdapter());
        setSize(WIDTH, HEIGHT);
        this.checkForCollision = new CollisionDetector();

        reset();
        Thread pThread;

        try {
            pThread = new Thread(this);
            pThread.start();
        } catch (Exception e) {
            System.err.println("Error creating thread.");
            e.printStackTrace();
            System.exit(-2);
        }

        try {
            car1_Left = ImageIO.read((new File("src/com/frogger/textures/Car1-Left.png")));
            car1_Right = ImageIO.read((new File("src/com/frogger/textures/Car1-Right.png")));
            car2_Left = ImageIO.read((new File("src/com/frogger/textures/Car2-Left.png")));
            car2_Right = ImageIO.read((new File("src/com/frogger/textures/Car2-Right.png")));
            limo_Left = ImageIO.read((new File("src/com/frogger/textures/Limo-Left.png")));
            limo_Right = ImageIO.read((new File("src/com/frogger/textures/Limo-Right.png")));
            semi_Left = ImageIO.read((new File("src/com/frogger/textures/Semi-Left.png")));
            semi_Right = ImageIO.read((new File("src/com/frogger/textures/Semi-Right.png")));
            frogUp = ImageIO.read((new File("src/com/frogger/textures/FrogUp.png")));
            frogDown = ImageIO.read((new File("src/com/frogger/textures/FrogDown.png")));
            frogLeft = ImageIO.read((new File("src/com/frogger/textures/FrogLeft.png")));
            frogRight = ImageIO.read((new File("src/com/frogger/textures/FrogRight.png")));
            frogLife = ImageIO.read((new File("src/com/frogger/textures/FrogLife.png")));

        } catch (Exception e) {
            System.err.println("Error Loading Images: " + e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }
        //addKeyListener(this);
    }

    @Deprecated
    public void keyReleased(KeyEvent e) {
    }

    @Deprecated
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void run() {
        while (FroggerGame.PLAYING == 0) {
            update();
            repaint();
            try {
                if ((FroggerGame.WIN) || (FroggerGame.DEAD)) {
                    YouWin youWin = new YouWin(true, 0, player); //
                    youWin.setBounds(0, 0, WIDTH, HEIGHT);
                    this.getParent().getParent().add(youWin, 0);
                    Thread.sleep(50000);
                    FroggerGame.PLAYING = 1;
                    break;
                }
                Thread.sleep(35);
            } catch (Exception e) {
                System.out.println("I can't fix this bug!");
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    // check for user input directional keys
    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if ((game.getFrog().getY() - 40) > 30)
                        game.getFrog().setY(game.getFrog().getY() - 40);
                    game.getFrog().setDirection(Frog.UP);
                    score++;
                    player.setTickets(score/2);
                    break;
                case KeyEvent.VK_DOWN:
                    if ((game.getFrog().getY() + 40) < getHeight() - 100)
                        game.getFrog().setY(game.getFrog().getY() + 40);
                    game.getFrog().setDirection(Frog.DOWN);
                    score++;
                    player.setTickets(score/2);
                    break;
                case KeyEvent.VK_LEFT:
                    if ((game.getFrog().getX() - 30) > 0)
                        game.getFrog().setX(game.getFrog().getX() - 40);
                    game.getFrog().setDirection(Frog.LEFT);
                    score++;
                    player.setTickets(score/2);
                    break;
                case KeyEvent.VK_RIGHT:
                    if ((game.getFrog().getX() + 40) < getWidth() - 30)
                        game.getFrog().setX(game.getFrog().getX() + 40);
                    game.getFrog().setDirection(Frog.RIGHT);
                    score++;
                    player.setTickets(score/2);
                    break;
            }
        }
    }


    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.drawLine(0, 75, getWidth(), 75);
        g.drawLine(0, 275, getWidth(), 275);
        //road--------------------------------------
        g.setColor(Color.GRAY);
        g.fillRect(0, 76, getWidth(), 199);
        //bottom black bar----------------------
        g.setColor(Color.BLACK);
        g.fillRect(0, getHeight() - 100, getWidth(), 300);
        //yellow lines on road----------------
        g.setColor(Color.yellow);
        for (int y = 116; y < 264; y += 39) {
            for (int x = 10; x < getWidth() - 10; x += 90) {
                g.fillRect(x, y, 60, 4);
            }
        }

        g.setColor(Color.gray); // Text.
        g.setFont(new Font("TimesRoman", Font.ITALIC, 40));
        g.drawString("Lives:", 10, getHeight() - 15);

        g.setColor(Color.RED); // Player lives.
        for (int i = 0; i < game.getLives(); i++) {
            g.drawString("♥", 130 + i * 30, getHeight() - 15);
        }

        g.setColor(Color.gray); //for score
        g.setFont(new Font("TimesRoman", Font.ITALIC, 40));
        g.drawString("Score: " + score, getWidth() -200, getHeight()- 15);

        // paint the frog image based on the most recent direction change
        switch (game.getFrog().getDirection()) {
            case Frog.UP:
                g.drawImage(frogUp, game.getFrog().getX(), game.getFrog().getY(), null);
                break;
            case Frog.DOWN:
                g.drawImage(frogDown, game.getFrog().getX(), game.getFrog().getY(), null);
                break;
            case Frog.LEFT:
                g.drawImage(frogLeft, game.getFrog().getX(), game.getFrog().getY(), null);
                break;
            case Frog.RIGHT:
                g.drawImage(frogRight, game.getFrog().getX(), game.getFrog().getY(), null);
                break;
        }

        // Moving Vehicles
        for (CarLane cl : game.getCarLanes())
        {
            for (int p = 0; p < cl.laneItems.size(); p++)
            {
                if (cl.laneItems.get(p).getDirection() == Lane.RIGHT && cl.laneItems.get(p).getType() == Car.CAR_1) {
                    g.drawImage(car1_Right, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                } else if (cl.laneItems.get(p).getDirection() == Lane.LEFT && cl.laneItems.get(p).getType() == Car.CAR_1) {
                    g.drawImage(car1_Left, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                } else if (cl.laneItems.get(p).getDirection() == Lane.RIGHT && cl.laneItems.get(p).getType() == Car.CAR_2) {
                    g.drawImage(car2_Right, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                } else if (cl.laneItems.get(p).getDirection() == Lane.LEFT && cl.laneItems.get(p).getType() == Car.CAR_2) {
                    g.drawImage(car1_Left, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                } else if (cl.laneItems.get(p).getDirection() == Lane.LEFT && cl.laneItems.get(p).getType() == Car.LIMO) {
                    g.drawImage(limo_Left, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                } else if (cl.laneItems.get(p).getDirection() == Lane.RIGHT && cl.laneItems.get(p).getType() == Car.LIMO) {
                    g.drawImage(limo_Right, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                } else if (cl.laneItems.get(p).getDirection() == Lane.LEFT && cl.laneItems.get(p).getType() == Car.SEMI) {
                    g.drawImage(semi_Left, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                } else if (cl.laneItems.get(p).getDirection() == Lane.RIGHT && cl.laneItems.get(p).getType() == Car.SEMI) {
                    g.drawImage(semi_Right, (int) cl.laneItems.get(p).getX(), (int) cl.laneItems.get(p).getY(), null);
                }
            }
        }
    }

    void update() {
        game.update();
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    void reset() {
        this.game = new FroggerGame();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}