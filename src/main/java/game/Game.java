package game;

import javax.swing.*;

import inputs.mouseAndKeyboard.KeyboardInputs;
import menus.panels.PauseMenuPanel;

public class Game implements Runnable {
    private final GamePanel gamePanel;
    private final Player player = new Player();
    private final PauseMenuPanel pauseMenuPanel;

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
                coordinateLabel1.setText("Up-left Corner: " + "X: " + player.getPlayerX() + " Y: " + player.getPlayerY());
                gamePanel.add(coordinateLabel1);

                coordinateLabel2.setText("Up-right Corner: " + "X: " + (player.getPlayerX() + player.getPlayerWidth()) + " Y: " + player.getPlayerY());
                gamePanel.add(coordinateLabel2);

                coordinateLabel3.setText("Down-Left Corner: " + "X: " + player.getPlayerX() + " Y: " + (player.getPlayerY() + player.getPlayerHeight()));
                gamePanel.add(coordinateLabel3);

                coordinateLabel4.setText("Down-Right Corner: " + "X: " + (player.getPlayerX() + player.getPlayerWidth()) + " Y: " + (player.getPlayerY() + player.getPlayerHeight()));
                gamePanel.add(coordinateLabel4);

                if (player.hasHitSpike()) {
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
        pauseMenuPanel = new PauseMenuPanel();
        GameWindow gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }
}