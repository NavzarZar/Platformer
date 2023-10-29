package menus;

import menus.panels.LevelCompletePanel;
import menus.windows.LevelCompleteWindow;

/**
 * The LevelCompleteMenu class represents the menu
 * displayed when a game level is completed.
 */
public class LevelCompleteMenu {
    private LevelCompletePanel levelCompletePanel;
    private LevelCompleteWindow levelCompleteWindow;

    /**
     * Creates a new LevelCompleteMenu.
     */
    public LevelCompleteMenu() {
        // Initialize the LevelCompletePanel
        levelCompletePanel = new LevelCompletePanel();

        // Initialize the LevelCompleteWindow with
        // the associated LevelCompletePanel
        levelCompleteWindow = new LevelCompleteWindow(levelCompletePanel);
    }

    /**
     * Gets the LevelCompletePanel associated with this menu.
     *
     * @return The LevelCompletePanel.
     */
    public LevelCompletePanel getLevelCompletePanel() {
        return levelCompletePanel;
    }

    /**
     * Gets the LevelCompleteWindow associated with this menu.
     *
     * @return The LevelCompleteWindow.
     */
    public LevelCompleteWindow getLevelCompleteWindow() {
        return levelCompleteWindow;
    }
}
