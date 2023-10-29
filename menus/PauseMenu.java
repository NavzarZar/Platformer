package menus;

import menus.panels.PauseMenuPanel;
import menus.windows.PauseMenuWindow;

/**
 * The PauseMenu class represents the in-game pause menu,
 * providing options to resume the game, restart the level,
 * return to the main menu, or exit the game.
 */
public class PauseMenu {
    private PauseMenuPanel pauseMenuPanel;
    private PauseMenuWindow pauseMenuWindow;

    /**
     * Constructs a new PauseMenu instance.
     */
    public PauseMenu() {
        // Create a new PauseMenuPanel, which contains the
        // UI elements for the pause menu.
        pauseMenuPanel = new PauseMenuPanel();

        // Create a new PauseMenuWindow, which displays the
        // pause menu to the user.
        pauseMenuWindow = new PauseMenuWindow(pauseMenuPanel);
    }
}
