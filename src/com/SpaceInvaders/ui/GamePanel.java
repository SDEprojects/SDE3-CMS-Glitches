package com.SpaceInvaders.ui;

import com.SpaceInvaders.constants.Constants;
import com.SpaceInvaders.image.Image;
import com.SpaceInvaders.image.ImageFactory;
import com.SpaceInvaders.listeners.GameEventListener;
import com.SpaceInvaders.models.Bomb;
import com.SpaceInvaders.models.EnemyShip;
import com.SpaceInvaders.models.Laser;
import com.glitches.models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class GamePanel extends JPanel {

    private List<EnemyShip> enemyShips;
    private List<Bomb> bomb;
    private Laser laser;
    private int direction = -1;
    private int deaths = 0;
    private String message;
    private Random generator;
    public static int score;
    private int lives = 2;
    private ImageIcon backgroundImage;
    private Timer timer;
    private com.SpaceInvaders.models.Spaceship spaceship;
    private boolean inGame = true;
    Player player;


    public GamePanel(Player player) {
        this.player = player;
        initializeVariables();
        initializeGame();
        initializeLayout();
    }

    public void initializeGame() {
        for(int i = 0; i < Constants.ENEMY_SHIPS_ROW; i++) {
            for(int j=0; j < Constants.ENEMY_SHIPS_COLUMN; j++) {
                //space between each enemy ship
                EnemyShip enemyShips = new EnemyShip(Constants.ENEMY_SHIP_INIT_X + 50 * j, Constants.ENEMY_SHIP_INIT_Y + 50 * i);
                this.enemyShips.add(enemyShips);
            }
        }
    }

    private void initializeVariables() {
        this.generator = new Random();
        this.spaceship = new com.SpaceInvaders.models.Spaceship();
        this.laser = new Laser();
        this.enemyShips = new ArrayList<>();
        this.bomb = new ArrayList<>();
        // where to get background image
        this.backgroundImage = ImageFactory.createImage(Image.BACKGROUND);
        //after every 10 ms doOneLoop() is being called
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.timer.start();  //starts timer
    }

    private void initializeLayout() {
        addKeyListener(new GameEventListener(this));
        setFocusable(true);  // focuses on opening to game panel
        // setting frame to be same size as board
        setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
    }

    private void drawPlayer(Graphics g) {
        // image, x, y, observer(gamePanel)
        g.drawImage(spaceship.getImage(), spaceship.getX(),spaceship.getY(), this);
    }

    private void drawLaser(Graphics g) {
        //draw laser and position
        if(!laser.isDead()) {  // if laser is not dead, draw it.
            g.drawImage(laser.getImage(), laser.getX(), laser.getY(), this);
        }
    }

    private void drawEnemy(Graphics g) {
        for (EnemyShip enemyShip : this.enemyShips) {
            if (enemyShip.isVisible()) {
                g.drawImage(enemyShip.getImage(), enemyShip.getX(), enemyShip.getY(), this);
            }
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage.getImage(), 0,0, null);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        //draw player unless game is over
        if(inGame) {
            drawScore(g);
            drawPlayer(g);
            drawLaser(g);
            drawEnemy(g);
            drawBombs(g);
        } else {
            if (timer.isRunning()) {
                timer.stop();
            }
            drawGameOver(g);
        }
        //makes sure display is up to date.
        Toolkit.getDefaultToolkit().sync();


    }


    private void drawScore(Graphics g) {
        if (!inGame) {
            return;
        }
        Font font = new Font("Space", Font.BOLD, 20);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g.setColor(Color.gray);
        g.setFont(font);
        g.drawString("Score: " + score, Constants.BOARD_WIDTH - 150, 50);
        g.drawString("Shields: " + lives, 50, 50);

    }

    private void drawGameOver(Graphics g) {
        g.drawImage(backgroundImage.getImage(), 0, 0, null);

        Font font = new Font("Space", Font.BOLD, 75);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(message, (Constants.BOARD_WIDTH - fontMetrics.stringWidth(message)) / 2, Constants.BOARD_HEIGHT / 2 -100);

    }

    private void drawBombs(Graphics g) {
        for (Bomb bomb: this.bomb)
            if (!bomb.isDead()) {
                g.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
            }
    }

    public void doOneLoop() {
        update();
        repaint();  // repaints after update paintComponent()

    }

    private void update() {
        //you lose
        if (spaceship.isDead()) {
            inGame = false;
            //message = Constants.GAME_OVER;
            message = Constants.TICKETS;

        }
        //you win
        if(deaths == this.enemyShips.size()) {
            inGame = false;
            //message = Constants.WIN;
            message = Constants.TICKETS;

        }

        this.spaceship.move();

        if (!laser.isDead()){

            int shotX = laser.getX();
            int shotY = laser.getY();

            for (EnemyShip enemy: this.enemyShips) {
                int enemyX = enemy.getX();
                int enemyY = enemy.getY();

                if(!enemy.isVisible()) continue;

                //collision detection laser and enemy
                if (shotX >= (enemyX) && shotX <= (enemyX + Constants.ENEMY_SHIP_WIDTH) && shotY >= (enemyY) && shotY <= (enemyY + Constants.ENEMY_SHIP_HEIGHT)) {
                    enemy.setVisible(false);
                    laser.die();
                    deaths++;
                    score++;
                    player.setTickets(1);
                }
            }
            this.laser.move();
        }


        for(EnemyShip enemyShip: this.enemyShips) {
            // when enemy ships get to right border flip direction
            if (enemyShip.getX() >+ Constants.BOARD_WIDTH - 2 * Constants.BORDER_PADDING && direction != -1) {
                direction = -1;

                Iterator<EnemyShip> ufoIterator = enemyShips.iterator();
                while (ufoIterator.hasNext()) {
                    EnemyShip ufo = ufoIterator.next();
                    ufo.setY(ufo.getY() + Constants.INVADING);
                }

            }
            //when enemy ships get to left border flip direction
            if (enemyShip.getX() <= Constants.BORDER_PADDING && direction != 1) {
                direction = 1;

                Iterator<EnemyShip> ufoIterator = enemyShips.iterator();
                while (ufoIterator.hasNext()) {
                    EnemyShip ufo = ufoIterator.next();
                    ufo.setY(ufo.getY() + Constants.INVADING);
                }
            }

            if (enemyShip.isVisible()) {

                //ufo reach spaceship
                if (enemyShip.getY() > Constants.BOARD_HEIGHT - 100 - Constants.SPACESHIP_HEIGHT) {
                    spaceship.die();
                }

                enemyShip.move(direction);
            }
        }
        //creating bombs
        for (EnemyShip enemyShip: this.enemyShips) {
            if (enemyShip.isVisible() && generator.nextDouble() < Constants.BOMB_DROPPING_PROBABILITY) {
                Bomb bomb = new Bomb(enemyShip.getX(), enemyShip.getY());
                this.bomb.add(bomb);
            }
        }
        //moving bombs
        for (Bomb bomb: bomb) {

            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int spaceshipX = spaceship.getX();
            int spaceshipY = spaceship.getY();

            //collision of bomb and spaceship
            if (!bomb.isDead() && !spaceship.isDead()) {
                if (bombX >= (spaceshipX) && bombX <= (spaceshipX + Constants.SPACESHIP_WIDTH) && bombY >= (spaceshipY) && bombY <= (spaceshipY + Constants.SPACESHIP_HEIGHT)) {
                    bomb.die();
                    lives --;

                    if (lives < 0) {
                        spaceship.die();
                    }

                }

                if (!bomb.isDead()) {
                    bomb.move();
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        this.spaceship.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        this.spaceship.keyPressed(e);  //move spaceship

        // pressing space bar for shooting laser
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            int laserX = this.spaceship.getX();
            int laserY = this.spaceship.getY();

            if (inGame && laser.isDead()) {
                laser = new Laser(laserX, laserY);  //position of laser
            }


        }
//    }


    }}
