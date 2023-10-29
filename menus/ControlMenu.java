package menus;

import menus.panels.ControlsPanel;
import menus.windows.ControlsWindow;

/**
 * The ControlMenu class represents the menu for controlling the game.
 */
public class ControlMenu {
    private ControlsWindow controlsWindow;
    private ControlsPanel controlsPanel;

    /**
     * Constructs a new ControlMenu.
     */
    public ControlMenu() {
        controlsPanel = new ControlsPanel();
        controlsWindow = new ControlsWindow(controlsPanel);
    }
}
