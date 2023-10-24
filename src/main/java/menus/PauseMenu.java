package menus;

import menus.panels.PauseMenuPanel;
import menus.windows.PauseMenuWindow;

public class PauseMenu {
    PauseMenuPanel pauseMenuPanel;
    PauseMenuWindow pauseMenuWindow;
    public PauseMenu()
    {
       pauseMenuPanel = new PauseMenuPanel();
       pauseMenuWindow = new PauseMenuWindow(pauseMenuPanel);
    }
}
