package game;

import physics.Collision;
import inputs.mouseAndKeyboard.KeyboardInputs;
import menus.GameOverMenu;
import java.awt.event.WindowEvent;
import static menus.GlobalMethods.getFrameForComponent;

public class Game implements Runnable {
    public static boolean pressedRestart = false;
    public GamePanel gamePanel;
    private final Player player = new Player();
    public static boolean isPaused = false;
    public static boolean gameOver = false;
    private static boolean levelWon = false;
    public static boolean pressedReturnToMainMenu = false;

    private static int level = 3;


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
                if(pressedReturnToMainMenu){
                    getFrameForComponent(gamePanel).dispatchEvent(new WindowEvent(getFrameForComponent(gamePanel), WindowEvent.WINDOW_CLOSING));
                    pressedReturnToMainMenu = false;
                }

                if (player.getPlayerX() > GameWindow.width * 3 - 160) {
                    levelWon = true;
                }

                if (Collision.collisionSpike(player) || player.getPlayerY() + player.getPlayerHeight() > GameWindow.height - 200) {
                    player.setVelocityX(0);
                    gameOver = true;
                    new GameOverMenu();
                    getFrameForComponent(gamePanel).dispatchEvent(new WindowEvent(getFrameForComponent(gamePanel), WindowEvent.WINDOW_CLOSING));
                }

                if (!isPaused) {
                    if (KeyboardInputs.movingLeft) {
                        player.moveLeft();
                    } else if (KeyboardInputs.movingRight) {
                        player.moveRight();
                    }
                    player.makePlayerFall();
                }

                if(pressedRestart){
                    KeyboardInputs.movingLeft = false;
                    KeyboardInputs.movingRight = false;
                    player.setPlayerIsJumping(false);
                    player.setPlayerX(0);
                    player.setPlayerY(500);
                    pressedRestart = false;
                }
                if (gameOver) {
                    KeyboardInputs.movingRight = false;
                    KeyboardInputs.movingLeft = false;
                }

                if (levelWon) {

                }

                gamePanel.repaint();
                lastFrame = now;

            }

        }
    }

    public Game() {
        gamePanel = new GamePanel(player);
        new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    public static int getLevel() {
        return level;
    }

}