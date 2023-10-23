package menus;

import menus.panels.StartMenuPanel;
import menus.windows.StartMenuWindow;

public class GameMenu {
    StartMenuPanel startMenuPanel;
    StartMenuWindow startMenuWindow;
    public GameMenu()
    {
        startMenuPanel = new StartMenuPanel();
        startMenuWindow = new StartMenuWindow(startMenuPanel);
    }

}
