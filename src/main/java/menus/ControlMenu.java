package menus;

import menus.panels.ControlsPanel;
import menus.windows.ControlsWindow;

public class ControlMenu {
    ControlsWindow controlsWindow;
    ControlsPanel controlsPanel;

    public ControlMenu() {
        controlsPanel = new ControlsPanel();
        controlsWindow = new ControlsWindow(controlsPanel);
    }

}