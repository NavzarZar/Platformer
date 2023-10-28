package menus;

import menus.panels.LevelCompletePanel;
import menus.windows.LevelCompleteWindow;
import org.w3c.dom.ls.LSOutput;

// Level complete menu
public class LevelCompleteMenu {
    LevelCompletePanel levelCompletePanel;
    LevelCompleteWindow levelCompleteWindow;
    public LevelCompleteMenu()
    {
        levelCompletePanel = new LevelCompletePanel();
        levelCompleteWindow = new LevelCompleteWindow(levelCompletePanel);
    }
}
