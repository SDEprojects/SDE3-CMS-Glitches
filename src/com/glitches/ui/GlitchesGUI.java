package com.glitches.ui;

import com.frogger.StartFroggerGame;
import com.frogger.frames.FroggerFrame;
import com.glitches.Rooms;
import com.glitches.models.Player;
import com.glitches.models.Room;
import com.snake.*;
import com.sun.java.accessibility.util.EventID;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


class GlitchesGUI extends JFrame {
    private JButton startButton;
    private JTextField nameTextField;
    private JTextPane textArea;
    private JButton choice1Button;
    private JButton choice3Button;
    private JButton choice2Button;
    private JButton choice4Button;
    private JPanel contentPane;
    private Player player = new Player();
    private Room currentRoom = Rooms.getRoom("IntroArcade");

    WelcomeScreenHandler wsHandler = new WelcomeScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();


    public GlitchesGUI () {
        super("Glitches!!");
        this.setContentPane(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
        //add(contentPane);
        startButton.addActionListener(wsHandler);
    }


    public class WelcomeScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            player.setName(nameTextField.getText());
            startGame();

        }
    }

    public class ChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()) {
                case "c1":
                    currentRoom = Rooms.getRoom(currentRoom.getChoice1());
                    break;
                case "c2":
                    currentRoom = Rooms.getRoom(currentRoom.getChoice2());
                    break;
                case "c3":
                    currentRoom = Rooms.getRoom(currentRoom.getChoice3());
                    break;
            }
            runGame();
        }
    }

    public void startGame() {
        contentPane.setSize(800, 800);
        startButton.setVisible(false);
        nameTextField.setVisible(false);
        initButtons();

        runGame();
    }

    public void setVisibleButtons(int number) {
        if(number == 0) {
            choice1Button.setVisible(false);
            choice2Button.setVisible(false);
            choice3Button.setVisible(false);
        } else if(number == 1) {
            choice1Button.setVisible(true);
            choice2Button.setVisible(false);
            choice3Button.setVisible(false);
        } else if(number == 2) {
            choice1Button.setVisible(true);
            choice2Button.setVisible(true);
            choice3Button.setVisible(false);
        } else if(number == 3) {
            choice1Button.setVisible(true);
            choice2Button.setVisible(true);
            choice3Button.setVisible(true);
        } else if(number == 4) {
            choice1Button.setVisible(true);
            choice2Button.setVisible(true);
            choice3Button.setVisible(true);
        }
    }

    public void runGame() {
        if(currentRoom.getName().equals("IntroArcade")) {
            textArea.setText(player.getName() + currentRoom.getStoryText());
        } else if (currentRoom.getName().equals("FroggerTerminal")) {
            textArea.setText(currentRoom.getStoryText());
            player.addToInventory("Green Key");

            runFrogger();
            currentRoom = Rooms.getRoom("FroggerTerminalWin");
            runGame();
        } else if (currentRoom.getName().equals("SnakeTerminal")) {
            textArea.setText(currentRoom.getStoryText());
            player.addToInventory("Purple Key");

            runSnake();
            currentRoom = Rooms.getRoom("SnakeTerminalWin");
            runGame();
        } else if (currentRoom.getName().equals("ExitDoor")) {
            if(player.getInventory().contains("Green Key") && player.getInventory().contains("Purple Key")) {
                currentRoom = Rooms.getRoom("ExitDoorWin");
                runGame();
            } else {
                textArea.setText(currentRoom.getStoryText());
            }
        } else {
            textArea.setText(currentRoom.getStoryText());
        }
        setVisibleButtons(currentRoom.getVisibleButtons());
        choice1Button.setText(currentRoom.getBtn1Text());
        choice2Button.setText(currentRoom.getBtn2Text());
        choice3Button.setText(currentRoom.getBtn3Text());
    }

    public void runSnake() {
        SnakeMiniGame.main(new SnakeFrame());
    }

    public void runFrogger() {
        StartFroggerGame.main(new FroggerFrame());
    }

    public void initButtons() {
        choice1Button.addActionListener(choiceHandler);
        choice1Button.setActionCommand("c1");
        choice2Button.addActionListener(choiceHandler);
        choice2Button.setActionCommand("c2");
        choice3Button.addActionListener(choiceHandler);
        choice3Button.setActionCommand("c3");
    }

}