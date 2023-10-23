package inputs;

import game.Game;
import menus.ControlMenu;
import menus.panels.ControlsPanel;
import menus.panels.PauseMenuPanel;
import menus.panels.StartMenuPanel;
import menus.windows.ControlsWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuButtonListener implements ActionListener {

    StartMenuPanel startMenuPanel;
    PauseMenuPanel pauseMenuPanel;

    public StartMenuButtonListener(StartMenuPanel startMenuPanel) {
        this.startMenuPanel = startMenuPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startMenuPanel.getStartButton()) {
            new Game();
        }
        if(e.getSource() == startMenuPanel.getExitButton()){
            System.exit(0);
        }
        if(e.getSource() == startMenuPanel.getChooseLvlButton()) {
            System.out.println(1);
        }
        if(e.getSource() == startMenuPanel.getControlsButton()) {
            new ControlMenu();
        }

    }
}
