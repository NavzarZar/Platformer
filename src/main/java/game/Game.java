package game;

import javax.swing.*;
import inputs.KeyboardInputs;
import physics.Collision;

public class Game implements Runnable {
    private final GamePanel gamePanel;
    private final Player player = new Player();

    private void startGameLoop() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        int SET_FPS = 120;
        double timePerFrame = 1000000000.0 / SET_FPS;
        boolean gameOver = false;
        long lastFrame = System.nanoTime();
        long now;

        while (!gameOver) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {

                if (Collision.collisionSpike(player)) {
                    gameOver = true;
                }


                if (KeyboardInputs.movingLeft) {
                    player.moveLeft();
                } else if (KeyboardInputs.movingRight) {
                    player.moveRight();
                }
                player.makePlayerFall();
                player.setPlayerX((int) (player.getPlayerX() + player.getPlayerVelocityX()));

                gamePanel.repaint();
                lastFrame = now;
            }
        }
    }

    public Game() {
        gamePanel = new GamePanel(player);
        GameWindow gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }
}
