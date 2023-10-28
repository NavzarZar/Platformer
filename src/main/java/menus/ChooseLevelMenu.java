package menus;

import menus.panels.ChooseLevelPanel;
import menus.windows.ChooseLevelWindow;
/**
 *
 */
public class ChooseLevelMenu {
    ChooseLevelPanel chooseLevelPanel;
    ChooseLevelWindow chooseLevelWindow;
    public ChooseLevelMenu()
    {
        chooseLevelPanel = new ChooseLevelPanel();
        chooseLevelWindow = new ChooseLevelWindow(chooseLevelPanel);
    }

}
