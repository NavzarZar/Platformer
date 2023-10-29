package game;

import inputs.keyboard.KeyboardInputs;
import menus.FinishedGameMenu;
import menus.GameOverMenu;
import menus.LevelCompleteMenu;
import java.awt.event.WindowEvent;
import physics.Collision;
import static menus.GlobalMethods.getFrameForComponent;

/**
 * The `Game` class represents the main game controller.
 * It manages the game loop and game state transitions.
 */
public class Game implements Runnable {


    /**
     * Indicates whether the game should be restarted.
     */
    private static boolean pressedRestart = false;

    /**
     * The panel where the game is displayed.
     */
    private GamePanel gamePanel;

    /**
     * The player character in the game.
     */
    private final Player player = new Player();

    /**
     * Indicates whether the game is currently paused.
     */
    private static boolean isPaused = false;

    /**
     * Indicates whether the game is over.
     */
    private static boolean gameOver = false;

    /**
     * Indicates whether the current level is won.
     */
    private static boolean levelWon = false;

    /**
     * Indicates whether the user wants to return to the main menu.
     */
    private static boolean pressedReturnToMainMenu = false;

    /**
     * The current level of the game.
     */
    private static int level = 1;


    /**
     * Checks if the restart button is pressed.
     *
     * @return true if the restart button is pressed, false otherwise.
     */
    public static boolean isPressedRestart() {
        return pressedRestart;
    }

    /**
     * Sets the state of the restart button.
     *
     * @param pressedRestart true to indicate the restart button is pressed,
     * false otherwise.
     */
    public static void setPressedRestart(boolean pressedRestart) {
        Game.pressedRestart = pressedRestart;
    }

    /**
     * Sets the state of the game's pause.
     *
     * @param isPaused true to indicate that the game is paused,
     * false otherwise.
     */
    public static void setIsPaused(boolean isPaused) {
        Game.isPaused = isPaused;
    }

    /**
     * Checks if the game is over.
     *
     * @return true if the game is over, false otherwise.
     */
    public static boolean isGameOver() {
        return gameOver;
    }

    /**
     * Sets the state of the game's over status.
     *
     * @param gameOver true to indicate that the game is over, false otherwise.
     */
    public static void setGameOver(boolean gameOver) {
        Game.gameOver = gameOver;
    }

    /**
     * Sets the state of the user's desire to return to the main menu.
     *
     * @param pressedReturnToMainMenu true to indicate the user's intention
     * to return to the main menu, false otherwise.
     */
    public static void setPressedReturnToMainMenu(
            boolean pressedReturnToMainMenu) {
        Game.pressedReturnToMainMenu = pressedReturnToMainMenu;
    }


    /**
     * Starts the game loop in a separate thread.
     */
    private void startGameLoop() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    public static boolean isIsPaused() {
        return isPaused;
    }

    /**
     * The main game loop. Manages game logic, rendering, and state transitions.
     */
    public void run() {
        int fps = 120;
        double milliseconds = 1000000000.0;
        double timePerFrame = milliseconds / fps;
        long lastFrame = System.nanoTime();
        long now;

        while (!gameOver) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                if (pressedReturnToMainMenu) {
                    // Close the game window when returning to the main menu.
                    getFrameForComponent(gamePanel).dispatchEvent(
                            new WindowEvent(getFrameForComponent(gamePanel),
                                    WindowEvent.WINDOW_CLOSING));
                    pressedReturnToMainMenu = false;
                }

                if (player.getPlayerX() > GameWindow.WIDTH * 3 - 160) {
                    // The player has won the level.
                    levelWon = true;
                }

                if (Collision.collisionSpike(player)
                        || player.getPlayerY() + player.getPlayerHeight()
                                > GameWindow.HEIGHT - 200) {
                    // Handle player collision with spikes or
                    // falling off the screen.
                    player.setVelocityX(0);
                    gameOver = true;
                    new GameOverMenu();
                    getFrameForComponent(gamePanel).dispatchEvent(
                            new WindowEvent(getFrameForComponent(gamePanel),
                                    WindowEvent.WINDOW_CLOSING));
                }

                if (!isPaused) {
                    // Handle player movement and gravity
                    // when the game is not paused.
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
                        getFrameForComponent(gamePanel).dispatchEvent(
                                new WindowEvent(getFrameForComponent(gamePanel),
                                        WindowEvent.WINDOW_CLOSING));
                        levelWon = false;
                        KeyboardInputs.movingRight = false;
                        KeyboardInputs.movingLeft = false;
                        break;
                    } else if (Game.getLevel() == 3) {
                        new FinishedGameMenu();
                        levelWon = false;
                        getFrameForComponent(gamePanel).dispatchEvent(
                                new WindowEvent(getFrameForComponent(gamePanel),
                                        WindowEvent.WINDOW_CLOSING));
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
