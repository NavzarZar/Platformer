package menus;

import menus.panels.GameOverPanel;
import menus.windows.GameOverWindow;
/**
 *
 */
public class GameOverMenu {
    GameOverPanel gameOverPanel;
    GameOverWindow gameOverWindow;
    public  GameOverMenu() {
        gameOverPanel = new GameOverPanel();
        gameOverWindow = new GameOverWindow(gameOverPanel);
    }
}
