package game;

import javax.swing.*;
import inputs.KeyboardInputs;

import java.awt.*;

public class Game implements Runnable {
    private final GamePanel gamePanel;
    private void startGameLoop() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        int SET_FPS = 120;
        double timePerFrame = 1000000000.0 / SET_FPS;
        boolean gameOver = false;
        boolean gameMenu = true;
        long lastFrame = System.nanoTime();
        long now;
        JLabel coordinateLabel1 = new JLabel();
        JLabel coordinateLabel2 = new JLabel();
        JLabel coordinateLabel3 = new JLabel();
        JLabel coordinateLabel4 = new JLabel();

        coordinateLabel1.setSize(400, 50);
        coordinateLabel2.setSize(400, 100);
        coordinateLabel3.setSize(400, 150);
        coordinateLabel4.setSize(400, 200);

        coordinateLabel1.setLocation(10, 0);
        coordinateLabel2.setLocation(10, 5);
        coordinateLabel3.setLocation(10, 15);
        coordinateLabel4.setLocation(10, 20);

        while (!gameOver) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                coordinateLabel1.setText("Up-left Corner: " + "X: " + gamePanel.player.getPlayerX() + " Y: " + gamePanel.player.getPlayerY());
                gamePanel.add(coordinateLabel1);

                coordinateLabel2.setText("Up-right Corner: " + "X: " + (gamePanel.player.getPlayerX() + gamePanel.player.getPlayerWidth()) + " Y: " + gamePanel.player.getPlayerY());
                gamePanel.add(coordinateLabel2);

                coordinateLabel3.setText("Down-Left Corner: " + "X: " + gamePanel.player.getPlayerX() + " Y: " + (gamePanel.player.getPlayerY() + gamePanel.player.getPlayerHeight()));
                gamePanel.add(coordinateLabel3);

                coordinateLabel4.setText("Down-Right Corner: " + "X: " + (gamePanel.player.getPlayerX() + gamePanel.player.getPlayerWidth()) + " Y: " + (gamePanel.player.getPlayerY() + gamePanel.player.getPlayerHeight()));
                gamePanel.add(coordinateLabel4);



                if (KeyboardInputs.movingLeft) {
                    gamePanel.player.moveLeft(gamePanel.getMap());
                } else if (KeyboardInputs.movingRight) {
                    gamePanel.player.moveRight(gamePanel.getMap());
                }
                gamePanel.player.makePlayerFall(gamePanel.getMap());
                gamePanel.player.setPlayerX((int) (gamePanel.player.getPlayerX() + gamePanel.player.getPlayerVelocityX()));

                gamePanel.repaint();
                lastFrame = now;
            }
        }
    }

    public Game() {
        gamePanel = new GamePanel();

        GameWindow gameWindow = new GameWindow(gamePanel);

        gamePanel.requestFocus();
        startGameLoop();
    }
}
