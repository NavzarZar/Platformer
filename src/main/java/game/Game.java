package game;

import menus.FinishedGameMenu;
import menus.LevelCompleteMenu;
import physics.Collision;
import inputs.keyboard.KeyboardInputs;
import menus.GameOverMenu;
import java.awt.event.WindowEvent;
import static menus.GlobalMethods.getFrameForComponent;

/**
 * The `Game` class represents the main game controller.
 * It manages the game loop and game state transitions.
 */
public class Game implements Runnable {
    public static boolean pressedRestart = false;
    public GamePanel gamePanel;
    private final Player player = new Player();
    public static boolean isPaused = false;
    public static boolean gameOver = false;
    private static boolean levelWon = false;
    public static boolean pressedReturnToMainMenu = false;

    private static int level = 1;

    /**
     * Starts the game loop in a separate thread.
     */
    private void startGameLoop() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * The main game loop. Manages game logic, rendering, and state transitions.
     */
    public void run() {
        int SET_FPS = 120;
        double timePerFrame = 1000000000.0 / SET_FPS;
        long lastFrame = System.nanoTime();
        long now;

        while (!gameOver) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                if (pressedReturnToMainMenu) {
                    // Close the game window when returning to the main menu.
                    getFrameForComponent(gamePanel).dispatchEvent(new WindowEvent(getFrameForComponent(gamePanel), WindowEvent.WINDOW_CLOSING));
                    pressedReturnToMainMenu = false;
                }

                if (player.getPlayerX() > GameWindow.width * 3 - 160) {
                    // The player has won the level.
                    levelWon = true;
                }

                if (Collision.collisionSpike(player) || player.getPlayerY() + player.getPlayerHeight() > GameWindow.height - 200) {
                    // Handle player collision with spikes or falling off the screen.
                    player.setVelocityX(0);
                    gameOver = true;
                    new GameOverMenu();
                    getFrameForComponent(gamePanel).dispatchEvent(new WindowEvent(getFrameForComponent(gamePanel), WindowEvent.WINDOW_CLOSING));
                }

                if (!isPaused) {
                    // Handle player movement and gravity when the game is not paused.
                    if (KeyboardInputs.movingLeft) {
                        player.moveLeft();
                    } else if (KeyboardInputs.movingRight) {
                        player.moveRight();
                    }
                    player.makePlayerFall();
                }

                if (pressedRestart) {
                    // Handle restarting the game.
                    KeyboardInputs.movingLeft = false;
                    KeyboardInputs.movingRight = false;
                    player.setPlayerIsJumping(false);
                    player.setPlayerX(0);
                    player.setPlayerY(500);
                    pressedRestart = false;
                }

                if (levelWon) {
                    // Handle level completion.
                    while (player.getPlayerY() + player.getPlayerHeight() > 0) {
                        player.setPlayerY(player.getPlayerY() - 1);
                        try {
                            Thread.sleep(2);
                            gamePanel.repaint();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (Game.getLevel() < 3) {
                        new LevelCompleteMenu();
                        getFrameForComponent(gamePanel).dispatchEvent(new WindowEvent(getFrameForComponent(gamePanel), WindowEvent.WINDOW_CLOSING));
                        levelWon = false;
                        KeyboardInputs.movingRight = false;
                        KeyboardInputs.movingLeft = false;
                        break;
                    } else if (Game.getLevel() == 3) {
                        new FinishedGameMenu();
                        levelWon = false;
                        getFrameForComponent(gamePanel).dispatchEvent(new WindowEvent(getFrameForComponent(gamePanel), WindowEvent.WINDOW_CLOSING));
                        KeyboardInputs.movingRight = false;
                        KeyboardInputs.movingLeft = false;
                        break;
                    }
                }

                if (gameOver) {
                    // Reset player movement when the game is over.
                    KeyboardInputs.movingRight = false;
                    KeyboardInputs.movingLeft = false;
                }

                gamePanel.repaint();
                lastFrame = now;
            }
        }
    }

    /**
     * Constructs a new game and initializes the game panel.
     */
    public Game() {
        gamePanel = new GamePanel(player);
        new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    /**
     * Gets the current game level.
     *
     * @return The current game level.
     */
    public static int getLevel() {
        return level;
    }

    /**
     * Sets the current game level.
     *
     * @param level The new game level to set.
     */
    public static void setLevel(int level) {
        Game.level = level;
    }
}
