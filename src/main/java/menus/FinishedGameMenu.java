package menus;

import menus.panels.FinishedGamePanel;
import menus.windows.FinishedGameWindow;

public class FinishedGameMenu {
    FinishedGamePanel finishedGamePanel;
    FinishedGameWindow finishedGameWindow;
    public FinishedGameMenu()
    {
        finishedGamePanel = new FinishedGamePanel();
        finishedGameWindow = new FinishedGameWindow(finishedGamePanel);
    }
}