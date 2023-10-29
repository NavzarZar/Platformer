package menus;

import menus.panels.FinishedGamePanel;
import menus.windows.FinishedGameWindow;

/**
 * The FinishedGameMenu class represents the menu for a finished game.
 */
public class FinishedGameMenu {
    private FinishedGamePanel finishedGamePanel;
    private FinishedGameWindow finishedGameWindow;

    /**
     * Constructs a new FinishedGameMenu.
     */
    public FinishedGameMenu() {
        finishedGamePanel = new FinishedGamePanel();
        finishedGameWindow = new FinishedGameWindow(finishedGamePanel);
    }
}
