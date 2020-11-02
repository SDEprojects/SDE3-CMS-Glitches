package com.brickbreaker;

import com.glitches.models.Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

//ActionListener for moving ball.
public class BrickPanel extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    public static int score = 0;

    private int totalBricks = 16;

    private Timer timer;
    private int delay = 10;
    private boolean hault = true;
    private int playerX = 300;

    private int ballPosX = 290;
    private int ballPosY = 350;
    private int ballDirX = getRandomNumberForX();
    private int ballDirY = getRandomNumberForY();
    //private String TICKETS = "Total tickets won!: " + score;

    private BrickFrame mapPlay;

    public BrickPanel() {
        mapPlay = new BrickFrame(10, 10);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics graphics) {
        //background
        graphics.setColor(Color.black);
        graphics.fillRect(1, 1, 690, 590);

        //drawing map of bricks
        mapPlay.draw((Graphics2D) graphics, Color.CYAN);

        //border
        graphics.setColor(Color.yellow);
        graphics.fillRect(0, 0, 3, 590);
        graphics.fillRect(0, 0, 690, 3);
        graphics.fillRect(690, 1, 3, 590);

        //score needs to be fixed
        graphics.setColor(Color.white);
        graphics.setFont(new Font("serif", Font.BOLD, 22));
        graphics.drawString("Score: " + score, 490, 30);

        //paddle
        graphics.setColor(Color.green);
        graphics.fillRect(playerX, 550, 150, 8);

        if (!play) {
            //game start message
            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
            graphics.drawString("Press Enter to start the game!", 90, 350);

            //ball hiding
            graphics.setColor(Color.black);
        } else {
            //ball showing
        graphics.setColor(Color.white);
        }
        graphics.fillOval(ballPosX, ballPosY, 20, 20);
        //ball color & size change
        if (score >= 50 && score < 100) {

            graphics.setColor(Color.yellow);
            graphics.fillOval(ballPosX, ballPosY, 21, 21);
        } else if (score >= 100 && score < 175) {
            //ball
            graphics.setColor(Color.orange);
            graphics.fillOval(ballPosX, ballPosY, 22, 22);
        } else if (score >= 175) {
            //ball
            graphics.setColor(Color.red);
            graphics.fillOval(ballPosX, ballPosY, 23, 23);
        }

        if (totalBricks <= 0) {
            play = false;
            ballDirX = 0;
            ballDirY = 0;

            //hiding the ball when it's game over
            graphics.setColor(Color.black);
            graphics.fillOval(ballPosX, ballPosY, 23, 23);

            graphics.setColor(Color.RED);
            graphics.setFont(new Font("serif", Font.BOLD, 20));
            graphics.drawString("You Win! Score: " + score, 200,300);

            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font("serif", Font.BOLD, 20));
            graphics.drawString("Press Enter to Restart..", 230, 230);

            //above score hiding
            graphics.setColor(Color.black);
            graphics.setFont(new Font("serif", Font.BOLD, 22));
            graphics.drawString("Score: " + score, 490, 30);

            //hide remains bricks
            mapPlay.draw((Graphics2D) graphics, Color.BLACK);

            //paddle
            graphics.setColor(Color.black);
            graphics.fillRect(playerX, 550, 100, 8);

            if(!play){
                endGame();
            }
        }
        if (ballPosY > 570) { //ball fell below floor
            play = false;
            ballDirX = 0;
            ballDirY = 0;
            endGame();
            //hiding after game over
            graphics.setColor(Color.black);
            graphics.fillOval(ballPosX, ballPosY, 23, 23);

            graphics.setColor(Color.RED);
            graphics.setFont(new Font("serif", Font.BOLD, 30));
            graphics.drawString("Game Over! Score: "+ score , 200, 300);

            //above score hiding
            graphics.setColor(Color.black);
            graphics.setFont(new Font("serif", Font.BOLD, 22));
            graphics.drawString("Score: " + score, 490,30);

            //hide remaining bricks
            mapPlay.draw((Graphics2D) graphics, Color.BLACK);

            //paddle
            graphics.setColor(Color.black);
            graphics.fillRect(playerX, 550, 100, 8);

            if(!play){
                endGame();
            }
        }

        graphics.dispose();
    }
    public void endGame(){
        if(hault) {
            Player.tickets += score;
            System.out.println("hault");
        }
        hault = false;
    }



    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                play = true;
                hault = true;
                playerX = 310;
                ballPosX = 290;
                ballPosY = 350;
                ballDirX = getRandomNumberForX();
                ballDirY = getRandomNumberForY();
                totalBricks = 100;

                mapPlay = new BrickFrame(10, 10);
                score = 10;
                repaint();
            }
        }
    }

    public void moveRight() {
        play = true;
        playerX += 30;
    }

    public void moveLeft() {
        play = true;
        playerX -= 30;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if (play) {
            if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballDirY = -ballDirY;
            }

            A:
            for (int i = 0; i < mapPlay.map.length; i++) {
                for (int j = 0; j < mapPlay.map[0].length; j++) {
                    if (mapPlay.map[i][j] > 0) {
                        int brickX = j * mapPlay.brickWidth + 80;
                        int brickY = i * mapPlay.brickHeight + 50;
                        int brickWidth = mapPlay.brickWidth;
                        int brickHeight = mapPlay.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle brickRect = rect;

                        if (ballRect.intersects(brickRect)) {
                            mapPlay.setBrickValue(0, i, j);
                            totalBricks--;
                            score += 5;

                            if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
                                ballDirX = -ballDirX;
                            } else {
                                ballDirY = -ballDirY;

                            }
                            break A;
                        }
                    }
                }
            }
            ballPosX += ballDirX;
            ballPosY += ballDirY;

            if (ballPosX < 0) { //for left
                ballDirX = -ballDirX;
            }
            if (ballPosY < 0) { //top
                ballDirY = -ballDirY;
            }
            //right
            if (ballPosX > 670) {
                ballDirX = -ballDirX;
            }

        }
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int getRandomNumberForY() {
        Random random = new Random();
        int max = -1;
        int min = -5;
        int randomNumber = min + random.nextInt(max - min + 1);
        return randomNumber;
    }

    public int getRandomNumberForX() {
        Random random = new Random();
        int max = -1;
        int min = -3;
        int randomNumber = min + random.nextInt(max- min + 1);
        return randomNumber;
    }

}
