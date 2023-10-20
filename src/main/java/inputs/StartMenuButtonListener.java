package inputs;

import game.Game;
import menus.PauseMenuPanel;
import menus.StartMenuPanel;

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

    }
}
