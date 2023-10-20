package menus;

import menus.StartMenuPanel;
import menus.StartMenuWindow;

public class GameMenu {
    StartMenuPanel startMenuPanel;
    StartMenuWindow startMenuWindow;
    public GameMenu()
    {
        startMenuPanel = new StartMenuPanel();
        startMenuWindow = new StartMenuWindow(startMenuPanel);
    }

}
