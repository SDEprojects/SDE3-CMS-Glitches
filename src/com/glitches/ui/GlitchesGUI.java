package com.glitches.ui;

import com.SpaceInvaders.app.App;
import com.SpaceInvaders.ui.GameMainFrame;
import com.brickbreaker.StartBrickBreaker;
import com.frogger.StartFroggerGame;
import com.glitches.Rooms;
import com.glitches.TicketCounter.GetPrize;
import com.glitches.TicketCounter.TicketCounter;
import com.glitches.models.Player;
import com.glitches.models.Room;
import com.snake.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class GlitchesGUI extends JFrame {
    private JButton startButton;
    private JTextField nameTextField;
    private JTextPane textArea;
    private JButton choice1Button;
    private JButton choice3Button;
    private JButton choice2Button;
    private JButton choice4Button;
    private JButton choice5Button;
    private JPanel contentPane;
    private Player player = new Player();
    private Room currentRoom = Rooms.getRoom("IntroArcade");

    WelcomeScreenHandler wsHandler = new WelcomeScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();


    public GlitchesGUI () {
        super("Glitches!!Arcade***");
        this.setContentPane(contentPane);
//        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        //add(contentPane);
        startButton.addActionListener(wsHandler);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    // not sure how, but this is the first page that pops up with START button
    public class WelcomeScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            player.setName(nameTextField.getText());
            startGame();
        }
    }

    //
    public void startGame() {
        contentPane.setSize(700, 700);
        startButton.setVisible(false);
        nameTextField.setVisible(false);

        // listens for buttons clicked
        initButtons();

        // listens for updating currentRoom
        runGame();
    }

    // controls for navigating through the rooms of the arcade
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
                case "c4":
                    currentRoom = Rooms.getRoom(currentRoom.getChoice4());
                    break;
                case "c5":
                    currentRoom = Rooms.getRoom(currentRoom.getChoice5());
            }
            runGame();
        }
    }

    // only display choices that are available according to the xml map
    public void setVisibleButtons(int number) {
        if(number == 0) {
            choice1Button.setVisible(false);
            choice2Button.setVisible(false);
            choice3Button.setVisible(false);
            choice4Button.setVisible(false);
            choice5Button.setVisible(false);
        } else if(number == 1) {
            choice1Button.setVisible(true);
            choice2Button.setVisible(false);
            choice3Button.setVisible(false);
            choice4Button.setVisible(false);
            choice5Button.setVisible(false);
        } else if(number == 2) {
            choice1Button.setVisible(true);
            choice2Button.setVisible(true);
            choice3Button.setVisible(false);
            choice4Button.setVisible(false);
            choice5Button.setVisible(false);
        } else if(number == 3) {
            choice1Button.setVisible(true);
            choice2Button.setVisible(true);
            choice3Button.setVisible(true);
            choice4Button.setVisible(false);
            choice5Button.setVisible(false);
        } else if(number == 4) {
            choice1Button.setVisible(true);
            choice2Button.setVisible(true);
            choice3Button.setVisible(true);
            choice4Button.setVisible(true);
            choice5Button.setVisible(false);
        } else if(number == 5) {
            choice1Button.setVisible(true);
            choice2Button.setVisible(true);
            choice3Button.setVisible(true);
            choice4Button.setVisible(true);
            choice5Button.setVisible(true);
        }
    }

    public void runGame() {
        if(currentRoom.getName().equals("IntroArcade")) {
            textArea.setText(player.getName() + currentRoom.getStoryText());
        } else if (currentRoom.getName().equals("FroggerTerminal")) {
            textArea.setText(currentRoom.getStoryText());
            player.addToInventory("Green Key");
            // method that calls StartFroggerGame.main() method
            runFrogger();
            // change the room to break out of this loop
            currentRoom = Rooms.getRoom("FroggerTerminalEnd");
            runGame();
        } else if (currentRoom.getName().equals("SnakeTerminal")) {
            textArea.setText(currentRoom.getStoryText());
            player.addToInventory("Purple Key");
            // method that calls SnakeMiniGame.main() method
            runSnake();
            // change the room to break out of this loop
            currentRoom = Rooms.getRoom("SnakeTerminalEnd");
            runGame();
        } else if (currentRoom.getName().equals("SpaceInvaderTerminal")) {
            textArea.setText(currentRoom.getStoryText());
            runSpaceInvaders();
            // change the room to break out of this loop
            currentRoom = Rooms.getRoom("SpaceInvaderTerminalEnd");
            runGame();
        } else if (currentRoom.getName().equals("BrickBreakerTerminal")) {
            textArea.setText(currentRoom.getStoryText());
            runBrickBreaker();
            //change the room to break out of this loop
            currentRoom = Rooms.getRoom("BrickBreakerTerminalEnd");
            runGame();
        } else{
            textArea.setText(currentRoom.getStoryText() + " Total tickets won: " + player.getTickets());
        } else if (currentRoom.getName().equals("TicketCounterTerminal")) {
            textArea.setText(currentRoom.getStoryText());
            runTicketCounter();
            currentRoom = Rooms.getRoom("GoldPath2");
            runGame();
        } else if (currentRoom.getName().equals("GoldPath2")) {
            // checks if player has two Keys in inventory
            if(player.getInventory().contains("Green Key") && player.getInventory().contains("Purple Key")) {
                currentRoom = Rooms.getRoom("ExitDoorWin");
                runGame();
            } else {
                currentRoom = Rooms.getRoom("ExitDoorWin");
                textArea.setText(currentRoom.getStoryText());
            }
        } else {
            textArea.setText(currentRoom.getStoryText() + " Total tickets won: " + player.getTickets() + " .  Inventory : " + player.getInventory());
        }
        // take the currentRoom's buttons and display
        setVisibleButtons(currentRoom.getVisibleButtons());
        // set the text for the each btn with corresponding xml key
        choice1Button.setText(currentRoom.getBtn1Text());
        choice2Button.setText(currentRoom.getBtn2Text());
        choice3Button.setText(currentRoom.getBtn3Text());
        choice4Button.setText(currentRoom.getBtn4Text());
        choice5Button.setText(currentRoom.getBtn5Text());
    }

    public void runSnake() {
      SnakeMiniGame.main(player);
    }

    public void runFrogger() {
        StartFroggerGame.main(player);
    }

    public void runBrickBreaker() {

        StartBrickBreaker.main();
    }
    public void runSpaceInvaders() {
        App.main(new GameMainFrame());}

    public void runTicketCounter() {
        GetPrize.main((player)); }


    public void initButtons() {
        choice1Button.addActionListener(choiceHandler);
        choice1Button.setActionCommand("c1");
        choice2Button.addActionListener(choiceHandler);
        choice2Button.setActionCommand("c2");
        choice3Button.addActionListener(choiceHandler);
        choice3Button.setActionCommand("c3");
        choice4Button.addActionListener(choiceHandler);
        choice4Button.setActionCommand("c4");
        choice5Button.addActionListener(choiceHandler);
        choice5Button.setActionCommand("c5");
    }

}