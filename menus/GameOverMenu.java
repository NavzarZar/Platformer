package menus;

import menus.panels.GameOverPanel;
import menus.windows.GameOverWindow;

/**
 * The GameOverMenu class represents the game over menu of the game.
 */
public class GameOverMenu {
    private GameOverPanel gameOverPanel;
    private GameOverWindow gameOverWindow;

    /**
     * Constructs a new GameOverMenu and initializes its components.
     */
    public GameOverMenu() {
        gameOverPanel = new GameOverPanel();
        gameOverWindow = new GameOverWindow(gameOverPanel);
    }
}
