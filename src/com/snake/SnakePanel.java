package com.snake;

import com.glitches.Rooms;
import com.glitches.models.Player;
import com.glitches.models.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;


public class SnakePanel extends JPanel implements ActionListener {

    // Instance Variables / Fields
    static final int SCREEN_WIDTH = 700;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 30;
    static final int DELAY = 175;
    final int x[] = new int[SCREEN_WIDTH / UNIT_SIZE];
    final int y[] = new int[SCREEN_HEIGHT / UNIT_SIZE];
    int bodyParts = 2;
    int blocksEaten;
    int blockX;
    int blockY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    // IS this player the same object from GlitchesGUI ???
    Player player;
    Random random;
    private JButton restartButton;

    // Ctor
    SnakePanel(Player player) {
        this.player = player;
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    // Methods
//    private void addRestartButton() { // New game button. Will close out old game.
//        String buttonText = "New Game slappy mcgoooo";
//        restartButton = new JButton(buttonText);
//        Font font = new Font("TimesRoman", Font.ITALIC, 40);
//        restartButton.setFont(font);
//        setLayout(null);
//        restartButton.setBounds(100, 600, 600, 50);
//        add(restartButton);
//        restartButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//                // getTopLevelAncestor - then - setVisible(false)
//                System.out.println("Slappy");
//            }
//        });
//    }

    public void startGame() {
        newBlock();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) { // Draw a graphic if running, else end the game.

        if (running) {

            g.setColor(Color.green);
            g.fillOval(blockX, blockY, UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                }
                else {
                    g.setColor(new Color(80,170,20));
                }
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
        else {
            endGameMessage(g); // End the game.
        }
    }


    public void endGameMessage(Graphics g) { // This method will end the game, tell the player if they won or lost, then restart if needed.
        if (blocksEaten < 10) {
            // give tickets to player
            int winnings = blocksEaten/2;
            System.out.println("hello");
            System.out.println(player.getName());
            player.setTickets(winnings);

            // set the screen
            g.setColor(Color.green);
            g.setFont(new Font("TimesRoman", Font.ITALIC, 40));
            g.drawString("You lose. Tickets rewarded: " + winnings, 10, 100);
//            addRestartButton();
            System.out.println("tickets won: " + winnings);
        } else if (blocksEaten == 10) {
            player.setTickets(blocksEaten);
            g.setColor(Color.green);
            g.setFont(new Font("TimesRoman", Font.ITALIC, 30));
            g.drawString("You ate 10! Tickets rewarded:" + blocksEaten, 10, 100);
            System.out.println("tickets won: " + blocksEaten);
        }
    }

    // randomly choose a place for snake food within the screen bounds
    public void newBlock() {
        blockX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        blockY = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }

    public void move() {
        for(int i = bodyParts; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] -= UNIT_SIZE;
                break;
            case 'D':
                y[0] += UNIT_SIZE;
                break;
            case 'L':
                x[0] -= UNIT_SIZE;
                break;
            case 'R':
                x[0] += UNIT_SIZE;
                break;
        }
    }

    // check if snake is currently eating a block of food, then grow snake
    public void checkBlock() {
        if((x[0] == blockX) && (y[0] == blockY)) {
            bodyParts++;
            blocksEaten++;
            newBlock();
        }
    }

    public void checkCollisions() {

        // check to see if snake head position is overlapping part of your body
        for(int i = bodyParts; i>0; i--) {
            if((x[0] == x[i]) && (y[0] == y[i])) {

                running = false;
            }
        }

        if(blocksEaten == 10) { // Important! If Snake eats 10 blocks, the game moves forward!
            running = false;
//          currentRoom = Rooms.getRoom("SnakeTerminalWin");
        }

        if(x[0] < 0) {
            running = false;
        }

        if(x[0] > SCREEN_WIDTH ) {
            running = false;
        }

        if(y[0] < 0) {
            running = false;
        }

        if(y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }

    // Action Events

    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            move();
            checkBlock();
            checkCollisions();
        }
        repaint();
    }

    // Key Adapter
    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}