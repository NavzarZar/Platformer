package menus;

import menus.panels.ChooseLevelPanel;
import menus.windows.ChooseLevelWindow;

/**
 * The ChooseLevelMenu class represents the menu for choosing game levels.
 */
public class ChooseLevelMenu {
    private ChooseLevelPanel chooseLevelPanel;
    private ChooseLevelWindow chooseLevelWindow;

    /**
     * Constructs a new ChooseLevelMenu.
     */
    public ChooseLevelMenu() {
        chooseLevelPanel = new ChooseLevelPanel();
        chooseLevelWindow = new ChooseLevelWindow(chooseLevelPanel);
    }
}
