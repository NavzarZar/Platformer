package menus;

import menus.panels.LevelCompletePanel;
import menus.windows.LevelCompleteWindow;

public class LevelCompleteMenu {
    LevelCompletePanel levelCompletePanel;
    LevelCompleteWindow levelCompleteWindow;
    public LevelCompleteMenu()
    {
        levelCompletePanel = new LevelCompletePanel();
        levelCompleteWindow = new LevelCompleteWindow(levelCompletePanel);
    }
}
