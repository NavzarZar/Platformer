package inputs.buttonListeners;

import game.Game;
import menus.ControlMenu;
import menus.panels.PauseMenuPanel;
import menus.panels.StartMenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static menus.GlobalMethods.getFrameForComponent;

public class StartMenuButtonListener implements ActionListener {

    StartMenuPanel startMenuPanel;
    PauseMenuPanel pauseMenuPanel;

    public StartMenuButtonListener(StartMenuPanel startMenuPanel) {
        this.startMenuPanel = startMenuPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startMenuPanel.getStartButton()) {
            Game.isPaused = false;
            new Game();
            getFrameForComponent(startMenuPanel.getStartButton()).dispose();
        }
        else if (e.getSource() == startMenuPanel.getExitButton()) {
            System.exit(0);
        }
        else if (e.getSource() == startMenuPanel.getChooseLvlButton()) {
            System.out.println(1);
        }
        else if (e.getSource() == startMenuPanel.getControlsButton()) {
            new ControlMenu();
            getFrameForComponent(startMenuPanel).dispatchEvent(new WindowEvent(getFrameForComponent(startMenuPanel), WindowEvent.WINDOW_CLOSING));
        }

    }
}
