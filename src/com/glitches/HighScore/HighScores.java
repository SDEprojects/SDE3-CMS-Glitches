package com.glitches.HighScore;

import com.SpaceInvaders.ui.GamePanel;
import com.brickbreaker.BrickPanel;
import com.frogger.frames.FroggerPanel;
import com.glitches.models.Player;
import com.snake.SnakePanel;

import java.io.*;

public class HighScores implements java.io.Serializable {

    public static String name = "player";
    public static int froggerScore;
    public static int brickScore;
    public static int spaceScore;
    public static int pacScore;
    public static int snakeScore;
    public static int totalScore;

    public static void main(String[] args) {
        HighScore();
    }

    public static void HighScore() {
        getScores();
        serialize(name, totalScore, brickScore, froggerScore, pacScore, snakeScore, spaceScore);
        deSerialize();

    }

    public static void serialize(String name, int totalScore, int brickScore, int froggerScore, int pacScore, int snakeScore, int spaceScore) {

        HighScores hs = new HighScores();
        hs.name = name;
        hs.totalScore = totalScore;
        hs.brickScore = brickScore;
        hs.froggerScore = froggerScore;
        hs.pacScore = pacScore;
        hs.snakeScore = snakeScore;
        hs.spaceScore = spaceScore;

        try {
            FileOutputStream fileout = new FileOutputStream("src/com/glitches/HighScore/highscore.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(hs);
            out.close();
            System.out.println("file saved");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public static void deSerialize() {
        HighScores hs = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/com/glitches/HighScore/highscore.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            hs = (HighScores) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("deserialized");
            return;

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }


    //have input for player to save their scores to their own file
    //have a key/value pair to continue saving additional scores
    //deserialize at beginning of game to show previous high scores

    private static void getScores() {
        getName();
        getTotalScore();
        getBrickScore();
        getFroggerScore();
        getPacScore();
        getSnakeScore();
        getSpaceScore();
    }

    //Getters

    public static int getTotalScore() {
        totalScore = getFroggerScore() +getBrickScore() + getPacScore() + getSpaceScore() + getSnakeScore();
        return totalScore;
    }

    public static String getName() {
        name = Player.getName();
        return name;
    }

    public static int getFroggerScore() {
        froggerScore = FroggerPanel.score;
        return froggerScore;
    }

    public static int getBrickScore() {
        brickScore = BrickPanel.score;
        return brickScore;
    }

    public static int getSpaceScore() {
        spaceScore = GamePanel.score;
        return spaceScore;
    }

    public static int getPacScore() {
        pacScore = com.pacman.GamePanel.score;
        return pacScore;
    }

    public static int getSnakeScore() {
        snakeScore = SnakePanel.blocksEaten;
        return snakeScore;
    }


}
