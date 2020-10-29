package com.glitches.HighScore;

import com.SpaceInvaders.ui.GamePanel;
import com.brickbreaker.BrickPanel;
import com.frogger.frames.FroggerPanel;
import com.glitches.models.Player;
import com.snake.SnakePanel;

import java.io.*;
import java.security.PublicKey;
import java.util.HashMap;

public class HighScores implements java.io.Serializable {

    public static String name = "player";
    public static int froggerScore;
    public static int brickScore;
    public static int spaceScore;
    public static int pacScore;
    public static int snakeScore;
    public static int totalScore;
    public static HashMap<String, Integer> totalhighscore;

    public static void main(String[] args) {
        HighScore();
    }
    public static void HighScore() {
        test();
        getScores();
        totalScore();
        score(name , totalScore, brickScore, froggerScore, pacScore, snakeScore, spaceScore);
        deSerialize();
    }

    private static void test() {
        name = "jon";
        totalScore = 150;
        froggerScore = 10;
        brickScore = 20;
        pacScore = 30;
        snakeScore = 40;
        spaceScore = 50;

        System.out.println(name);
        System.out.println(totalScore);
        System.out.println(froggerScore);
        System.out.println(brickScore);
        System.out.println(pacScore);
        System.out.println(spaceScore);
        System.out.println(snakeScore);
    }

    public static void score(String name, int totalScore, int brickScore, int froggerScore, int pacScore, int snakeScore, int spaceScore) {


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
        }
        catch (IOException i) {
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
        }
        catch (IOException i) {
            i.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("name: " + hs.name);
        System.out.println("toats: " + hs.totalScore);
        System.out.println("brick: " + hs.brickScore);
        System.out.println("frog: " + hs.froggerScore);
        System.out.println("pac: " + hs.pacScore);
        System.out.println("snake: " + hs.snakeScore);
        System.out.println("space: " + hs.spaceScore);

    }








    private static void getScores() {
        getName();
        getBrickScore();
        getFroggerScore();
        getPacScore();
        getSnakeScore();
        getSpaceScore();
    }

    private static void totalScore() {
        totalScore = froggerScore +brickScore + pacScore + spaceScore + snakeScore;

    }








    //Getters

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
