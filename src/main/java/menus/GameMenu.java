package menus;

import menus.panels.StartMenuPanel;
import menus.windows.StartMenuWindow;

/**
 * The GameMenu class represents the main menu of the game.
 */
public class GameMenu {
    private StartMenuPanel startMenuPanel;
    private StartMenuWindow startMenuWindow;

    /**
     * Constructs a new GameMenu and initializes its components.
     */
    public GameMenu() {
        startMenuPanel = new StartMenuPanel();
        startMenuWindow = new StartMenuWindow(startMenuPanel);
    }
}
