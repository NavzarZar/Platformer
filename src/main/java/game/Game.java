package game;

import javax.swing.*;

import inputs.buttonListeners.PauseMenuButtonListener;
import inputs.mouseAndKeyboard.KeyboardInputs;
import menus.GameOverMenu;

import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

public class Game implements Runnable {
    public GamePanel gamePanel;
    private final Player player = new Player();
    public static boolean isPaused = false;
    public static boolean gameOver = false;
    private void startGameLoop() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        int SET_FPS = 120;
        double timePerFrame = 1000000000.0 / SET_FPS;
        long lastFrame = System.nanoTime();
        long now;

        while (!gameOver) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {

                if (player.hasHitSpike()) {
                    player.setVelocityX(0);
                    gameOver = true;
                    new GameOverMenu();
                    getFrameForComponent(gamePanel).dispatchEvent(new WindowEvent(getFrameForComponent(gamePanel), WindowEvent.WINDOW_CLOSING));
                }
                if(!isPaused)
                {
                    if (KeyboardInputs.movingLeft) {
                        player.moveLeft();
                    } else if (KeyboardInputs.movingRight) {
                        player.moveRight();
                    }
                    player.makePlayerFall();
                }
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